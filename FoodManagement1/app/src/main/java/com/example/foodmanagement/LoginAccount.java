//山﨑里沙,2022/12/22
//ログインをするプログラム
package com.example.foodmanagement;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;


public class LoginAccount extends AppCompatActivity implements View.OnClickListener{
    //変数の定義
    private EditText user_mail;
    private EditText user_passwd;
    //API
    private final String API_URL_PREFIX = "ec2-54-84-168-166.compute-1.amazonaws.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginaccount);

        //メールアドレス
        user_mail = (EditText) findViewById(R.id.editTextTextEmailAddress2);
        //パスワード
        user_passwd = (EditText) findViewById(R.id.editTextTextPassword2);

        findViewById(R.id.button5).setOnClickListener(this);//戻るボタン
        findViewById(R.id.button6).setOnClickListener(this);//ログインボタン

    }

    //ボタンを押下したら初期画面かホームに遷移する
    @Override
    public void onClick(View v) {
        //変数の定義
        //DBにあるかどうかを判断する
        boolean correct;
        //画面遷移用
        Intent cancel = new Intent(this, MainActivity.class);
        Intent login = new Intent(this, Home.class);
        Intent error_null = new Intent(this, LoginError.class);
        Intent error_false = new Intent(this, LoginError2.class);

        //戻るボタンを押下したら初期画面に遷移
        if (v.getId() == R.id.button5) {
            startActivity(cancel);
        } else if (v.getId() == R.id.button6) {
            //入力されたメールアドレスを取得する
            String get_user_mail = user_mail.getText().toString();
            //入力されたパスワードを取得する
            String get_user_passwd = user_passwd.getText().toString();

            //メールアドレスとパスワードがDBにあるか検索する
            //String url = "http://appserver/userLogin?user_id=get_user_mail&user_passwd=get_user_passwd";


            MyAsync asynk = new MyAsync(user_mail, user_passwd);
            asynk.execute();

            correct = true;//後から変更

            if (get_user_mail.equals("") || get_user_passwd.equals("")){
                //メールアドレスまたはパスワードがnullだったときLoginErrorNull.javaに遷移
                //今は新規登録画面に遷移
                startActivity(error_null);
            } else if (correct == false) {
                //DBに登録されていないときLoginErrorFalse.javaに遷移
                //今はNews.javaにしている
                startActivity(error_false);
            } else {
                //ログイン成功のときホーム画面に遷移
                startActivity(login);
            }
        }
    }

    class MyAsync extends AsyncTask<String, Void, String> {

        //private final WeakReference<TextView> titleViewReference;
        //private final WeakReference<TextView> dateViewReference;
        //入力されたメールアドレスを取得する
        String get_user_mail = user_mail.getText().toString();
        //入力されたパスワードを取得する
        String get_user_passwd = user_passwd.getText().toString();

        public MyAsync(EditText user_mail,EditText user_passwd) {
            //titleViewReference = new WeakReference<TextView>(user_mail);
            //dateViewReference = new WeakReference<TextView>(user_passwd);
        }


        @Override
        protected String doInBackground(String... params) {
            final StringBuilder result = new StringBuilder();
            Uri.Builder uriBuilder = new Uri.Builder();
            uriBuilder.scheme("http");
            uriBuilder.authority(API_URL_PREFIX);
            uriBuilder.path("/serchPasswd.php");
            uriBuilder.appendQueryParameter("user_id", get_user_mail);
            uriBuilder.appendQueryParameter("user_passwd", get_user_passwd);
            //uriBuilder.appendQueryParameter("q", "夏目漱石");
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
                while((line = bufReader.readLine()) != null) {
                    result.append(line);
                }
                Log.e("but", result.toString());
                bufReader.close();
                inReader.close();
                in.close();
            }

            catch(Exception e) { //エラー
                Log.e("button", e.getMessage());
            }

            return result.toString(); //onPostExecuteへreturn
        }

        @Override
        protected void onPostExecute(String result) { //doInBackgroundが終わると呼び出される
            try {
                JSONObject json = new JSONObject(result);
                String items = json.getString("result");
                JSONArray itemsArray = new JSONArray(items);
                JSONObject bookInfo = itemsArray.getJSONObject(0).getJSONObject("result");

                //String title = bookInfo.getString("title");
                //String publishedDate = bookInfo.getString("publishedDate");

                //TextView titleView = titleViewReference.get();
                //TextView dateView = dateViewReference.get();

                //titleView.setText(title);
                //dateView.setText(publishedDate);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
