//小川歩華，2022/12/19
//タイムライン画面を表示するプログラム
package com.example.foodmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TimelineMain extends AppCompatActivity implements View.OnClickListener {
    int button = 3;

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
        int[] images = {R.drawable.tl_apple, R.drawable.tl_onion, R.drawable.tl_orange, R.drawable.tl_peach};
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
        list.setAdapter(new TimelineAdapter(
                this, listData, R.layout.list_tl,
                new String[] {"tl_name", "tl_data", "tl_num", "food", "tlimageView"},
                new int[] {R.id.tl_name, R.id.tl_data, R.id.tl_num, R.id.food, R.id.tlimageView}
        ));

        findViewById(R.id.homeButton).setOnClickListener(this);//ホーム
        findViewById(R.id.mypageButton).setOnClickListener(this);//マイページ
        findViewById(R.id.timelineButton).setOnClickListener(this);//タイムライン
        findViewById(R.id.messageButton).setOnClickListener(this);//メッセージ
    }

    @Override
    public void onClick(View v) {
        Intent send = new Intent(this, TimelineSend.class);
        startActivity(send);

        Intent home = new Intent(this, Home.class);
        Intent mypage = new Intent(this, Account.class);
        Intent timeline = new Intent(this, TimelineMain.class);
        Intent talk = new Intent(this, TalkMain.class);
        if (v.getId() == R.id.homeButton && button != 1) {
            startActivity(home);
            button = 1;

        } else if (v.getId() == R.id.mypageButton && button != 2) {
            startActivity(mypage);
            button = 2;

        } else if (v.getId() == R.id.timelineButton && button != 3) {
            startActivity(timeline);
            button = 3;

        } else if (v.getId() == R.id.messageButton && button != 4) {
            startActivity(talk);
            button = 4;
        }
    }


}
