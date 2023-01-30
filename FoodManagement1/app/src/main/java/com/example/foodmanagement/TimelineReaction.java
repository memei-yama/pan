//小川歩華，2022/12/19
//タイムラインにリアクションを追加するプログラム
package com.example.foodmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TimelineReaction extends AppCompatActivity implements View.OnClickListener{
    int button = 3;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_reaction);

        //仮データ
        String[] names = {"ゆみ", "はなこ", "たくや", "まさお"};

        ArrayList<Map<String, Object>> listData = new ArrayList<>();
        for (int i=0; i < names.length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("displayUser1", names[i]);
            listData.add(item);
        }

        //ListViewにデータをセット
        ListView list = findViewById(R.id.reactionList);
        list.setAdapter(new SimpleAdapter(
                this, listData, R.layout.list_reaction,
                new String[] {"displayUser1"},
                new int[] {R.id.displayUser1}
        ));

        findViewById(R.id.button50).setOnClickListener(this);

        findViewById(R.id.homeButton).setOnClickListener(this);//ホーム
        findViewById(R.id.mypageButton).setOnClickListener(this);//マイページ
        findViewById(R.id.timelineButton).setOnClickListener(this);//タイムライン
        findViewById(R.id.messageButton).setOnClickListener(this);//メッセージ
    }

    @Override
    public void onClick(View v) {
        Intent back = new Intent(this, TimelineMain.class);
        startActivity(back);

        //ベルトのボタン処理
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
