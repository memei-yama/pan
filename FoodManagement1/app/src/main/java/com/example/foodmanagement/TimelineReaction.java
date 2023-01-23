//小川歩華，2022/12/19
//タイムラインにリアクションを追加するプログラム
package com.example.foodmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TimelineReaction extends AppCompatActivity{
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
    }
}
