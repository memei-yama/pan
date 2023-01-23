//山﨑里沙,2022/12/22
//新規登録するプログラム
package com.example.foodmanagement;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

public class SignUp extends AppCompatActivity implements View.OnClickListener{
    static String final_user_id;
    //変数の定義
    private EditText user_name;
    private EditText user_mail;
    private EditText user_address;
    private EditText user_passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_account);

        //ユーザ名
        user_name = (EditText) findViewById(R.id.editTextTextPersonName);
        //メールアドレス
        user_mail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        //住所
        user_address = (EditText) findViewById(R.id.editTextTextPostalAddress);
        //パスワード
        user_passwd = (EditText) findViewById(R.id.editTextTextPassword);

        findViewById(R.id.button3).setOnClickListener(this);//登録ボタン
        findViewById(R.id.button4).setOnClickListener(this);//キャンセルボタン
    }

    @Override
    public void onClick(View v) {
        //画面遷移用
        Intent cancel = new Intent(this, MainActivity.class);
        Intent register_ok = new Intent(this, SignUpFin.class);
        Intent error = new Intent(this,SignUpError.class);

        //登録かキャンセルのボタンを押したとき
        if (v.getId() == R.id.button4) {
            //キャンセルを押したときMainActivity.javaに遷移
            startActivity(cancel);
        } else if (v.getId() == R.id.button3) {
            //入力されたユーザ名を取得する
            String get_user_name = user_name.getText().toString();
            //入力されたメールアドレスを取得する
            String get_user_mail = user_mail.getText().toString();
            //入力された住所を取得する
            String get_user_address = user_address.getText().toString();
            //入力されたパスワードを取得する
            String get_user_passwd = user_passwd.getText().toString();

            //ユーザ情報が書き込まれているか
            if (!get_user_name.equals("") && !get_user_mail.equals("") && !get_user_passwd.equals("")) {
                //ユーザ名とメールアドレスとパスワードがnullじゃなかった時
                //データベースに登録する処理を書く
                SignUp.MyAsync asynk = new SignUp.MyAsync(user_name, user_mail,user_address,user_passwd);
                asynk.execute();
                //asynk.onPostExecute("yyy");
                startActivity(register_ok);
            } else {
                //ユーザ名とメールアドレスとパスワードの一つでもnullだったらエラー画面
                startActivity(error);
            }
        }
    }


    public final class MyAsync extends AsyncTask<String, Void, String> {
        //static String final_user_id;

        //private final WeakReference<TextView> titleViewReference;
        //private final WeakReference<TextView> dateViewReference;

        //API
        private final String API_URL_PREFIX = "ec2-3-86-52-40.compute-1.amazonaws.com";

        //入力されたユーザ名を取得する
        String get_user_name = user_name.getText().toString();
        //入力されたメールアドレスを取得する
        String get_user_mail = user_mail.getText().toString();
        //入力された住所を取得する
        String get_user_address = user_address.getText().toString();
        //入力されたパスワードを取得する
        String get_user_passwd = user_passwd.getText().toString();

        public MyAsync(EditText user_name,EditText user_mail,EditText user_address,EditText user_passwd) {
            //titleViewReference = new WeakReference<TextView>(user_mail);
            //dateViewReference = new WeakReference<TextView>(user_passwd);
        }


        @Override
        protected String doInBackground(String... params) {
            final StringBuilder result = new StringBuilder();
            Uri.Builder uriBuilder = new Uri.Builder();
            uriBuilder.scheme("http");
            uriBuilder.authority(API_URL_PREFIX);
            uriBuilder.path("/insertUserInfo.php");
            //uriBuilder.path("/books/v1/volumes");
            uriBuilder.appendQueryParameter("user_name", get_user_name);
            uriBuilder.appendQueryParameter("user_mail", get_user_mail);
            uriBuilder.appendQueryParameter("user_address", get_user_address);
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
                while ((line = bufReader.readLine()) != null) {
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

        //@Override
        //protected void onPostExecute(String result) { //doInBackgroundが終わると呼び出される
           // SignUp.final_user_id = "111";
            //try {
                //SignUp.final_user_id = "111";
                //JSONObject json = new JSONObject(result);

                //SignUp.final_user_id = "111";

                //SignUp.final_user_id = json.getString("user_id");;
                //String items = json.getString("user_id");
                //JSONArray itemsArray = new JSONArray( "[{\"user_id\":\"29\",\"result\":true}]");
                //JSONArray itemsArray = new JSONArray(items);
                //JSONObject bookInfo = itemsArray.getJSONObject(0);
                //SignUp.final_user_id = bookInfo.getString("user_id");
                //JSONObject bookInfo = itemsArray.getJSONObject(0).getJSONObject("user_id");
                //SignUp.final_user_id = "111";
                //SignUp.final_user_id = bookInfo.getString("user_id");
                //String publishedDate = bookInfo.getString("publishedDate");

                //TextView titleView = titleViewReference.get();
                //TextView dateView = dateViewReference.get();

                //titleView.setText(title);
                //dateView.setText(publishedDate);

            //} catch (JSONException e) {
             //   e.printStackTrace();
            //}

        //}
    }
}
