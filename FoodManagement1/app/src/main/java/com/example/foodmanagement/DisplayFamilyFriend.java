//山﨑里沙,2022/12/31
//家族・フレンドを表示させるプログラム
package com.example.foodmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayFamilyFriend extends AppCompatActivity{
    public static Map<String, String> data;
    public static List<Map<String, String>> dataList;
    public static ListView listView;
    public static ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_familyfriend);
        dataList = new ArrayList<Map<String, String>>();

        //フレンド登録している人の検索
        // ListViewに表示するためのDATAを作成する
        int MAXDATA = 2;//表示させる個数はこれが制御している
        //String[] friend = new String[MAXDATA];
        String[] friend = new String[]{"山田花子", "佐藤健太", "田中さとみ"};
        for (int i = 0; i < MAXDATA; i++) {
            data = new HashMap<String, String>();
            data.put("text1", friend[i]);//このタイトルをユーザ名に変える
            dataList.add(data);
        }

        // アダプターにデータを渡す
        adapter = new ListViewAdapter(
                this,
                dataList,
                R.layout.row,
                new String[] {"text1"},
                new int[] { android.R.id.text1});

        // ListViewにアダプターをSETする
        listView = (ListView) findViewById(R.id.reactionList);//idが決まったら値をsetする
        listView.setAdapter(adapter);
        listView.setTextFilterEnabled(false);
    }
}
