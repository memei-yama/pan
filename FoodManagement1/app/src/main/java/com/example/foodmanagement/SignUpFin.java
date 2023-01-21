//山﨑里沙,2022/12/22
//新規登録完了画面を表示するプログラム
package com.example.foodmanagement;

import static com.example.foodmanagement.SignUp.final_user_id;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpFin extends AppCompatActivity implements View.OnClickListener{
    //変数の定義
    TextView view_user_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_fin);

        findViewById(R.id.button43).setOnClickListener(this);//戻るボタン

        view_user_id = findViewById(R.id.a1);
        //view_user_id.setText(SignUp.final_user_id);
        //String name = "abc";
        view_user_id.setText(SignUp.final_user_id);
    }
    //ボタンを押下したらログイン画面に遷移する
    @Override
    public void onClick(View v) {
        Intent fin = new Intent(this, LoginAccount.class);

        if (v.getId() == R.id.button43) {
            startActivity(fin);
        }
    }
}
