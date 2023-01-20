//小川歩華,2022/12/19
//下のアイコンを押したら遷移するプログラム
package com.example.foodmanagement;

import android.os.Bundle;
import android.view.View; //ボタンクリックのライブラリ
import android.content.Intent; //画面遷移のライブラリ

import androidx.appcompat.app.AppCompatActivity;

public class Belt extends AppCompatActivity implements View.OnClickListener {
    int button = 0; //どこのボタンが押されているかの条件判定用

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.belt);

        findViewById(R.id.homeButton).setOnClickListener(this);
        findViewById(R.id.mypageButton).setOnClickListener(this);
        findViewById(R.id.timelineButton).setOnClickListener(this);
        findViewById(R.id.messageButton).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
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
