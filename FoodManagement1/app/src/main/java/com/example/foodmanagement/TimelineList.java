//小川歩華, 2023/1/3
//timelineMainに表示されるタイムラインのプログラム
package com.example.foodmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class TimelineList extends AppCompatActivity implements View.OnClickListener{
    boolean good = false;
    //データベースからgoodの値を取得

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_tl);

        findViewById(R.id.heartButton).setOnClickListener(this); //ハートボタン
    }

    @Override
    public void onClick(View v){
        ImageButton heart = findViewById(R.id.heartButton);

        //goodの値がfalse(リアクションがない)だったらハートマークをつける
        if (!good) {
            heart.setImageResource(R.drawable.color_heart);
            good = true;
            //データベースにユーザIDを格納

            //goodの値がtrue(リアクションがある)だったらハートマークを消す
        } else if (good) {
            heart.setImageResource(R.drawable.heart);
            good = false;
            //データベースからユーザIDを削除
        }
    }

}

