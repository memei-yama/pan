//山﨑里沙,2022/12/22
//ログインの際のDBにアカウントがないときに画面を表示するプログラム
package com.example.foodmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class LoginError2 extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_error2);

        findViewById(R.id.button41).setOnClickListener(this);//戻るボタン
    }
    //ボタンを押下したらログインに遷移する
    @Override
    public void onClick(View v) {
        Intent fin = new Intent(this, LoginAccount.class);

        if (v.getId() == R.id.button41) {
            startActivity(fin);
        }
    }
}
