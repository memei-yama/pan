//山口芽依,2023/01/05
//食品登録の方法を選択するためのプログラム

package com.example.foodmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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
    }

    //画面遷移
    @Override
    public void onClick(View v) {
        //今はどちらもRegisterFoodに遷移するようにしている
        Intent register_camera = new Intent(this, RegisterFoodCamera.class);
        Intent register_self = new Intent(this, RegisterFood.class);


        //どのボタンが押下されたか、それによる画面遷移
        if (v.getId() == R.id.button45){ //カメラ読み取りボタン
            startActivity(register_camera);
        } else if (v.getId() == R.id.button44){ //手入力ボタン
            startActivity(register_self);
        }

    }


}
