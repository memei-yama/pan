//山﨑里沙,2022/12/29
//フレンドユーザを検索結果を確認するプログラム,これは使わない(RegisterFamilyで実装)
package com.example.foodmanagement;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegisterFriendCheck extends AppCompatActivity implements View.OnClickListener {
    //変数の定義
    TextView view_user_mail;
    TextView view_user_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_familycheck);

        findViewById(R.id.button24).setOnClickListener(this);//キャンセルボタン
        findViewById(R.id.button25).setOnClickListener(this);//申請ボタン

        //ユーザ名とユーザIDを表示するテキストのIDを取得する
        view_user_mail = findViewById(R.id.textView10);
        view_user_name = findViewById(R.id.textView5);
        //RegisterFamilySearch2からユーザIDとユーザ名を受け取る
        Intent user_mail = getIntent();
        Intent user_name = getIntent();
        String get_user_mail = user_mail.getStringExtra("user_mail");
        String get_user_name = user_name.getStringExtra("user_name");
        //受け取ったユーザIDとユーザ名を挿入する
        view_user_mail.setText(get_user_mail);
        view_user_name.setText(get_user_name);
    }

    //ボタンを押下したら適切な画面に遷移する
    @Override
    public void onClick(View v) {
        //画面遷移用
        Intent next = new Intent(this, RegisterFamilyFin.class);
        Intent cancel = new Intent(this, RegisterFriendSearch.class);

        if (v.getId() == R.id.button24) {
            //ユーザ検索画面へ遷移
            startActivity(cancel);
        } else if (v.getId() == R.id.button25) {
            //登録完了画面へ遷移
            //フレンド登録作業を行う
            RegisterFriendCheck.MyAsync asynk = new RegisterFriendCheck.MyAsync();
            asynk.execute();
            startActivity(next);
        }
    }

    public final class MyAsync extends AsyncTask<String, Void, String> {
        //API
        private final String API_URL_PREFIX = "ec2-3-95-224-49.compute-1.amazonaws.com";


        public MyAsync() {
        }


        @Override
        protected String doInBackground(String... params) {
            final StringBuilder result = new StringBuilder();
            Uri.Builder uriBuilder = new Uri.Builder();
            uriBuilder.scheme("http");
            uriBuilder.authority(API_URL_PREFIX);
            uriBuilder.path("/insertFriendInfo.php");
            uriBuilder.appendQueryParameter("sendUser_id", "111");
            uriBuilder.appendQueryParameter("recUser_id", "222");
            final String uriStr = uriBuilder.build().toString();

            try {
                URL url = new URL(uriStr);
                HttpURLConnection con = null;
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setDoInput(true);
                con.connect(); //HTTP接続

                final InputStream in = con.getInputStream();
                final InputStreamReader inReader = new InputStreamReader(in);
                final BufferedReader bufReader = new BufferedReader(inReader);

                String line = null;
                while ((line = bufReader.readLine()) != null) {
                    result.append(line);
                }
                Log.e("but", result.toString());
                bufReader.close();
                inReader.close();
                in.close();

            } catch (Exception e) { //エラー
                Log.e("button", e.getMessage());
            }

            return result.toString(); //onPostExecuteへreturn
        }
    }
}
