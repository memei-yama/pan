//山﨑里沙,2022/12/22
//新規登録の際の必要事項が入力されてないときに画面を表示するプログラム
package com.example.foodmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpError extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_error);

        findViewById(R.id.button40).setOnClickListener(this);//戻るボタン
    }
    //ボタンを押下したらログインに遷移する
    @Override
    public void onClick(View v) {
        Intent fin = new Intent(this, SignUp.class);

        if (v.getId() == R.id.button40) {
            startActivity(fin);
        }
    }
}
