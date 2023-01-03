//山口芽依,2023/01/03
//食品登録のプログラム

package com.example.foodmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class RegisterFood extends AppCompatActivity implements View.OnClickListener{

    //変数(テキスト)の設定
    private EditText food_name;
    private EditText food_shop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_food); //食品登録に変更

        //各種ボタン設定
        //カメラ読み取りボタン

        //手入力


        //食品名　（テキスト）
        //food_name = findViewById(R.id.)

        //賞味・消費選択

        //期限　（カレンダー）

        //購入店舗（テキスト）
        //food_shop = findViewById(R.id.)

        //個数　（個数選択）


        //追加ボタン
        //findViewById(R.id.button ).setOnClickListener(this);

        //削除ボタン
        //findViewById(R.id.button ).setOnClickListener(this);
    }


    //画面遷移
    @Override
    public void onClick(View v) {

        //Intent register_self = new Intent(this, registerFoodJAN.class);
        //Intent register_JAN = new Intent(this, registerSelf.class);
        Intent home = new Intent(this, Home.class);

        //カメラ読み取りボタンを押した時
        if (v.getId() == R.id.button ){

        }else if (v.getId() == R.id.button ){ //手入力ボタンを押した時


            //food_nameとfood_dateの確認


            startActivity(home);


        }





    }



}
