//山口芽依,2023/01/05
//食品登録の方法を選択するためのプログラム

package com.example.foodmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.content.Intent;

public class RegisterFoodMenu extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_foodmenu);

        //各種ボタン設定
        //カメラ読み取り
        findViewById(R.id.button45).setOnClickListener(this);
        //手入力
        findViewById(R.id.button44).setOnClickListener(this);
        //ホームボタン
        findViewById(R.id.homeButton).setOnClickListener(this);
        //マイページ
        findViewById(R.id.mypageButton).setOnClickListener(this);
        //タイムライン
        findViewById(R.id.timelineButton).setOnClickListener(this);
        //メッセージ
        findViewById(R.id.messageButton).setOnClickListener(this);
    }

    //画面遷移
    @Override
    public void onClick(View v) {
        //今はどちらもRegisterFoodに遷移するようにしている
        Intent register_camera = new Intent(this, RegisterFoodCamera.class);
        Intent register_self = new Intent(this, RegisterFood.class);
        Intent home = new Intent(this, Home.class);
        Intent mypage = new Intent(this, Account.class);
        Intent timeline = new Intent(this, TimelineMain.class);
        Intent message = new Intent(this, Message.class);

        //どのボタンが押下されたか、それによる画面遷移
        if (v.getId() == R.id.button45){ //カメラ読み取りボタン
            startActivity(register_camera);

        } else if (v.getId() == R.id.button44){ //手入力ボタン
            startActivity(register_self);

        }else if (v.getId() == R.id.homeButton) { //ホームボタン
            startActivity(home);

        }else if (v.getId() == R.id.mypageButton) { //マイページボタン
            startActivity(mypage);

        }else if (v.getId() == R.id.timelineButton) { //タイムラインボタン
            startActivity(timeline);

        }else if (v.getId() == R.id.messageButton) { //メッセージボタン
            startActivity(message);
        }

    }


}
