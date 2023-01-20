//小川歩華，2022/12/19
//タイムラインにリアクションを追加するプログラム
package com.example.foodmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TimelineReaction extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_reaction);
    }
    //データベースからgoodの値をとってきてtrueだったらtextviewに表示させる
}
