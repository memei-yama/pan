//山﨑里沙,2022/12/31
//家族・フレンドを表示させるプログラム
package com.example.foodmanagement;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayFamilyFriend extends AppCompatActivity {
    public static Map<String, String> data;
    public static List<Map<String, String>> dataList;
    public static ListView listView;
    public static ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_familyfriend);
        dataList = new ArrayList<Map<String, String>>();

        // ListViewに表示するためのDATAを作成する
        int MAXDATA = 10;//表示させる個数はこれが制御している
        for (int i = 0; i < MAXDATA; i++) {
            data = new HashMap<String, String>();
            data.put("text1", "タイトル" + i);//このタイトルをユーザ名に変える
            dataList.add(data);
        }

        // アダプターにデータを渡す
        adapter = new ListViewAdapter(
                this,
                dataList,
                R.layout.row,
                new String[] { "text1"},
                new int[] { android.R.id.text1});

        // ListViewにアダプターをSETする
        //listView = (ListView) findViewById(R.id.mainlist);//idが決まったら値をsetする
        //listView.setAdapter(adapter);
        //listView.setTextFilterEnabled(false);
    }
}
