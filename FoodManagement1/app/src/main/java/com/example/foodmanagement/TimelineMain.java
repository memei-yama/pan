//小川歩華，2022/12/19
//タイムライン画面を表示するプログラム
package com.example.foodmanagement;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

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
        String[] datas = {"2023/1/14", "2023/1/16", "2023/1/30", "2023/2/3"};
        String[] nums = {"2", "1", "5", "1"};
        String[] foods = {"りんご", "玉ねぎ", "みかん", "もも"};
        int[] images = {R.drawable.people1, R.drawable.people2, R.drawable.people3, R.drawable.people4};
        //仮データここまで

        ArrayList<Map<String, Object>> listData = new ArrayList<>();
        for (int i=0; i < names.length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("tl_name", names[i]);
            item.put("tl_data", datas[i]);
            item.put("tl_num", nums[i]);
            item.put("food", foods[i]);
            item.put("tlimageView", images[i]);
            listData.add(item);
        }

        //ListViewにデータをセット
        ListView list = findViewById(R.id.timelineList);
        list.setAdapter(new SimpleAdapter(
                this, listData, R.layout.list_tl,
                new String[] {"tl_name", "tl_data", "tl_num", "food", "tlimageView"},
                new int[] {R.id.tl_name, R.id.tl_data, R.id.tl_num, R.id.food, R.id.tlimageView}
        ));

        //AsyncTaskClass task = new AsyncTaskClass();
        //task.execute("");
    }

    @Override
    public void onClick(View v) {
        Intent send = new Intent(this, TimelineSend.class);
        startActivity(send);
    }


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
