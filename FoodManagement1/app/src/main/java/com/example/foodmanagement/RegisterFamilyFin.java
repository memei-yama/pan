//山﨑里沙,2022/12/29
//家族登録の完了画面プログラム
package com.example.foodmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterFamilyFin extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_familyfin);

        findViewById(R.id.button22).setOnClickListener(this);//戻るボタン

        findViewById(R.id.homeButton).setOnClickListener(this);//ホームボタン
        findViewById(R.id.mypageButton).setOnClickListener(this);//マイページボタン
        findViewById(R.id.timelineButton).setOnClickListener(this);//タイムラインボタン
        findViewById(R.id.messageButton).setOnClickListener(this);//メッセージボタン
    }
    //ボタンを押下したら適切な画面に遷移する
    @Override
    public void onClick(View v) {
        //画面遷移用
        Intent fin = new Intent(this, Account.class);
        //ベルトの遷移用
        Intent home = new Intent(this, Home.class);
        Intent mypage = new Intent(this, Account.class);
        Intent timeline = new Intent(this, TimelineMain.class);
        Intent talk = new Intent(this, TalkMain.class);

        if (v.getId() == R.id.button22) {
            //ユーザ検索画面へ遷移
            startActivity(fin);
        } else if (v.getId() == R.id.homeButton) {
            //アカウント削除画面へ遷移
            startActivity(home);
        }
        else if (v.getId() == R.id.mypageButton) {
            //アカウント削除画面へ遷移
            startActivity(mypage);
        }
        else if (v.getId() == R.id.timelineButton) {
            //アカウント削除画面へ遷移
            startActivity(timeline);
        }
        else if (v.getId() == R.id.messageButton) {
            //アカウント削除画面へ遷移
            startActivity(talk);
        }
    }
}
