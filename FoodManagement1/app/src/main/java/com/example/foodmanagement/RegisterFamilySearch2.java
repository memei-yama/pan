//山﨑里沙,2022/12/27
//家族のユーザ検索の結果を表示するプログラム
package com.example.foodmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterFamilySearch2 extends AppCompatActivity implements View.OnClickListener {
    //変数の定義
    TextView user_name;
    String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_family2);

        user_name = findViewById(R.id.textView3);//後から変更

        //user_button = (Button)findViewById(R.id.button23);
        findViewById(R.id.button21).setOnClickListener(this);//検索ボタン
        findViewById(R.id.button23).setOnClickListener(this);//ユーザボタン

        //RegisterFamilySearchからユーザIDとユーザ名を受け取る
        Intent user_id = getIntent();
        String get_user_id = user_id.getStringExtra("user_id");
        user_name.setText(get_user_id);
    }

    //ボタンを押下したら適切な画面に遷移する
    @Override
    public void onClick(View v) {
        //画面遷移用
        Intent check = new Intent(this, RegisterFamilyCheck.class);
        if (v.getId() == R.id.button23) {
            //確認画面へ遷移
            startActivity(check);
        }
    }
}
