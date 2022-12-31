//山口芽依,2022/12/14
//ホーム画面のプログラム

package com.example.foodmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//import android.view.View;
//画面遷移にIntenetを使う
//import android.content.Intent;

//public class Home extends AppCompatActivity implements View.OnClickListener{
public class Home extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        //ボタンの設定
        //findViewById(R.id.button).setOnClickListener(this);

    }

    //ボタン押下後の遷移
    /*
    @Override
    public void onCLick(View v){

    }
     */
}