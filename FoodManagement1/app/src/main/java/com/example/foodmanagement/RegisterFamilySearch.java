//山﨑里沙,2022/12/27
//家族のユーザ検索をするプログラム
package com.example.foodmanagement;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegisterFamilySearch extends AppCompatActivity implements View.OnClickListener {
    //変数の定義
    private EditText family_mail;
    TextView view_user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_family);

        //メールアドレス
        family_mail = (EditText) findViewById(R.id.editTextTextPersonName3);

        findViewById(R.id.button20).setOnClickListener(this);//検索ボタン
        findViewById(R.id.button26).setOnClickListener(this);//戻るボタン

        //view_user_id = findViewById(R.id.textView2);
        //view_user_id.setText(SignUp.final_user_id);
        //String name = "abc";
        //view_user_id.setText(RegisterFamilyName.final_family_name);
    }

    //ボタンを押下したら適切な画面に遷移する
    @Override
    public void onClick(View v) {
        String user_mail;
        String user_name;
        //画面遷移用
        Intent register_family = new Intent(this, RegisterFamilyName.class);
        Intent error = new Intent(this, RegisterFamilyError.class);
        Intent search = new Intent(this, RegisterFamilySearch2.class);

        if (v.getId() == R.id.button20) {
            //入力されたメールアドレスを取得する
            String get_family_mail = family_mail.getText().toString();
            //一致するデータがDBにあるか検索(ユーザIDとユーザ名が返ってくる)
            RegisterFamilySearch.MyAsync asynk = new RegisterFamilySearch.MyAsync();
            asynk.execute();
            user_mail = "yamada_ken@gmail.com";
            user_name = "YamadaKen";
            if (user_mail.equals("")){
                startActivity(error);
            } else {
                //検索結果で取得したユーザidとユーザ名を次の画面に渡す
                search.putExtra("user_name",user_name);
                search.putExtra("user_mail",user_mail);
                //検索結果表示画面へ遷移
                startActivity(search);
            }
        } else if (v.getId() == R.id.button26) {
            startActivity(register_family);
        }
    }

    public final class MyAsync extends AsyncTask<String, Void, String> {

        //API
        private final String API_URL_PREFIX = "ec2-3-95-224-49.compute-1.amazonaws.com";
        //入力されたメールアドレスを取得する
        String get_family_mail = family_mail.getText().toString();

        public MyAsync() {
        }


        @Override
        protected String doInBackground(String... params) {
            final StringBuilder result = new StringBuilder();
            Uri.Builder uriBuilder = new Uri.Builder();
            uriBuilder.scheme("http");
            uriBuilder.authority(API_URL_PREFIX);
            //uriBuilder.path("search");
            uriBuilder.path("serchUser.php");
            uriBuilder.appendQueryParameter("user_mail", get_family_mail);
            //SignUp.final_user_id= uriBuilder.build().toString();
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
