//小川歩華，2022/12/19
//タイムライン画面を表示するプログラム
package com.example.foodmanagement;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/*
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
*/

public class TimelineMain extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_main);

        findViewById(R.id.button30).setOnClickListener(this); //新規投稿作成ボタン

        //仮データ
        String[] names = {"ゆみ", "はなこ", "たくや", "まさお"};



        ArrayList<Map<String, Object>> listData = new ArrayList<>();
        for (int i=0; i < names.length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("displayUser1", names[i]);
            listData.add(item);

        //AsyncTaskClass task = new AsyncTaskClass();
        //task.execute("");
    }

    @Override
    public void onClick(View v) {
        Intent send = new Intent(this, TimelineSend.class);
        startActivity(send);
    }



    //データベースからTimelineListを取得しtextviewに表示させる
/*
    public class AsyncTaskClass extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground (String... params) {
            //バックグラウンドで行う処理
            Request request = new Request.Builder()
                    .url("http://appserver/getTimeline?timeline_id=1124")
                    .build();

            OkHttpClient client = new OkHttpClient();

            try {
                Response response = client.newCall(request).execute();

                String strData = response.body().string();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return strData;
        }

        @Override
        protected void onPostExecute(String str) {
            //UIスレッドに反映する処理
        }
    }

 */
}
