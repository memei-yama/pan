//山﨑里沙,2022/12/31
//家族・フレンドを表示させるプログラム
package com.example.foodmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayFamilyFriend extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener{
    public static Map<String, String> data;
    public static List<Map<String, String>> dataList;
    public static ListView listView;
    public static ListViewAdapter adapter;
    private int button = 4;

    private static final String[] friend = {"たくや", "やま", "おが", "なか"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_familyfriend);
        dataList = new ArrayList<Map<String, String>>();

        //フレンド登録している人の検索
        // ListViewに表示するためのDATAを作成する
        //int MAXDATA = 2;//表示させる個数はこれが制御している
        //String[] friend = new String[MAXDATA];
        //String[] friend = new String[]{"山田花子", "佐藤健太", "田中さとみ"};
        /*
        for (int i = 0; i < MAXDATA; i++) {
            data = new HashMap<String, String>();
            data.put("text1", friend[i]);//このタイトルをユーザ名に変える
            dataList.add(data);
        }

         */

        // アダプターにデータを渡す
        adapter = new ListViewAdapter(
                this,
                dataList,
                R.layout.row,
                //new String[] {"text1"},
                friend,
                new int[] { android.R.id.text1});

        // ListViewにアダプターをSETする
        listView = (ListView) findViewById(R.id.reactionList);//idが決まったら値をsetする
        listView.setAdapter(adapter);
        listView.setTextFilterEnabled(false);

        //リストの名前を選択
        listView.setOnItemClickListener(this);

        findViewById(R.id.homeButton).setOnClickListener(this);
        findViewById(R.id.mypageButton).setOnClickListener(this);
        findViewById(R.id.timelineButton).setOnClickListener(this);
        findViewById(R.id.messageButton).setOnClickListener(this);
    }

    //onClickとonItemClickの位置が逆だったら上手く画面遷移できません．なんで？
    @Override
    public void onClick(View v) {
        //ベルトの処理
        Intent home = new Intent(this, Home.class);
        Intent mypage = new Intent(this, Account.class);
        Intent timeline = new Intent(this, TimelineMain.class);
        Intent talk = new Intent(this, DisplayFamilyFriend.class);

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

    //トーク画面に移動
    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        Intent talk = new Intent(this.getApplicationContext(), TalkMain.class);
        String selectedText = friend[position];
        startActivity(talk);
    }
}
