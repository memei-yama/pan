//山﨑里沙,2022/12/23
//ユーザの初期画面のプログラム
package com.example.foodmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Account extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_account);

        findViewById(R.id.button10).setOnClickListener(this);//アカウント更新ボタン
        findViewById(R.id.button9).setOnClickListener(this);//家族ボタン
        findViewById(R.id.button8).setOnClickListener(this);//フレンドボタン
        findViewById(R.id.button7).setOnClickListener(this);//アカウント削除ボタン

        findViewById(R.id.homeButton).setOnClickListener(this);//ホームボタン
        findViewById(R.id.mypageButton).setOnClickListener(this);//マイページボタン
        findViewById(R.id.timelineButton).setOnClickListener(this);//タイムラインボタン
        findViewById(R.id.messageButton).setOnClickListener(this);//メッセージボタン
    }

    //ボタンを押下したら適切な画面に遷移する
    @Override
    public void onClick(View v) {
        //画面遷移用
        Intent update_user = new Intent(this, UpdateUser.class);
        Intent family = new Intent(this, ViewFamily.class);
        Intent friend = new Intent(this, ViewFriend.class);
        Intent delete_user = new Intent(this, DeleteAccount.class);
        //ベルトの遷移用
        Intent home = new Intent(this, Home.class);
        Intent mypage = new Intent(this, Account.class);
        Intent timeline = new Intent(this, TimelineMain.class);
        Intent talk = new Intent(this, TalkMain.class);

        if (v.getId() == R.id.button10) {
            //アカウント更新画面へ遷移
            startActivity(update_user);
        } else if (v.getId() == R.id.button9) {
            //家族メニュー画面へ遷移
            startActivity(family);
        } else if (v.getId() == R.id.button8) {
            //フレンドメニュー画面へ遷移
            startActivity(friend);
        } else if (v.getId() == R.id.button7) {
            //アカウント削除画面へ遷移
            startActivity(delete_user);
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
