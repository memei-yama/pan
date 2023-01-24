//山﨑里沙,2022/12/27
//家族のグループ名を処理するプログラム
package com.example.foodmanagement;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegisterFamilyName extends AppCompatActivity implements View.OnClickListener {
    //変数の定義
    private EditText family_name;
    static String final_family_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_familyname);

        //家族グループ名
        family_name = (EditText) findViewById(R.id.editTextTextPersonName2);

        findViewById(R.id.button19).setOnClickListener(this);//次へボタン
        findViewById(R.id.button18).setOnClickListener(this);//戻るボタン

        findViewById(R.id.homeButton).setOnClickListener(this);//ホームボタン
        findViewById(R.id.mypageButton).setOnClickListener(this);//マイページボタン
        findViewById(R.id.timelineButton).setOnClickListener(this);//タイムラインボタン
        findViewById(R.id.messageButton).setOnClickListener(this);//メッセージボタン
    }

    //ボタンを押下したら適切な画面に遷移する
    @Override
    public void onClick(View v) {
        //画面遷移用
        Intent next = new Intent(this, RegisterFamilySearch.class);
        Intent cancel = new Intent(this, ViewFamily.class);

        //ベルトの遷移用
        Intent home = new Intent(this, Home.class);
        Intent mypage = new Intent(this, Account.class);
        Intent timeline = new Intent(this, TimelineMain.class);
        Intent talk = new Intent(this, TalkMain.class);

        if (v.getId() == R.id.button19) {
            //入力されたユーザ名を取得する
            String get_family_name = family_name.getText().toString();
            //データベースへの登録作業を記述
            RegisterFamilyName.MyAsync asynk = new RegisterFamilyName.MyAsync(family_name);
            asynk.execute();
            //ユーザ検索画面へ遷移
            startActivity(next);
        } else if (v.getId() == R.id.button18) {
            //家族メニュー画面へ遷移
            startActivity(cancel);
        } else if (v.getId() == R.id.homeButton) {
            //アカウント削除画面へ遷移
            startActivity(home);
        }
        else if (v.getId() == R.id.mypageButton) {
            //アカウント削除画面へ遷移
            startActivity(mypage);
        }
        else if (v.getId() == R.id.timelineButton) {
            //アカウント削除画面へ遷移
            startActivity(timeline);
        }
        else if (v.getId() == R.id.messageButton) {
            //アカウント削除画面へ遷移
            startActivity(talk);
        }
    }

    public final class MyAsync extends AsyncTask<String, Void, String> {
        //static String final_user_id;

        //private final WeakReference<TextView> titleViewReference;
        //private final WeakReference<TextView> dateViewReference;

        //API
        private final String API_URL_PREFIX = "ec2-54-84-168-166.compute-1.amazonaws.com";

        //入力されたユーザ名を取得する
        String get_family_name = family_name.getText().toString();

        public MyAsync(EditText family_name) {
            //titleViewReference = new WeakReference<TextView>(user_mail);
            //dateViewReference = new WeakReference<TextView>(user_passwd);
        }


        @Override
        protected String doInBackground(String... params) {
            final StringBuilder result = new StringBuilder();
            Uri.Builder uriBuilder = new Uri.Builder();
            uriBuilder.scheme("http");
            uriBuilder.authority(API_URL_PREFIX);
            uriBuilder.path("/insertFamilyGroup.php");
            //uriBuilder.path("/books/v1/volumes");
            uriBuilder.appendQueryParameter("user_id", "111");
            uriBuilder.appendQueryParameter("user_name", get_family_name);
            //uriBuilder.appendQueryParameter("q", "夏目漱石");
            final String uriStr = uriBuilder.build().toString();

            try {
                URL url = new URL(uriStr);
                HttpURLConnection con = null;
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setDoInput(true);
                RegisterFamilyName.final_family_name = get_family_name;
                con.connect(); //HTTP接続

                final InputStream in = con.getInputStream();
                final InputStreamReader inReader = new InputStreamReader(in);
                final BufferedReader bufReader = new BufferedReader(inReader);

                String line = null;
                while ((line = bufReader.readLine()) != null) {
                    result.append(line);
                }
                Log.e("but",result.toString());
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
