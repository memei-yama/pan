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
    TextView view_user_mail;
    TextView view_user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_family2);

        //ユーザ名とユーザIDを表示するテキストのIDを取得する
        view_user_mail = findViewById(R.id.textView8);
        view_user_name = findViewById(R.id.textView7);

        findViewById(R.id.button21).setOnClickListener(this);//検索ボタン
        findViewById(R.id.button23).setOnClickListener(this);//ユーザボタン
        findViewById(R.id.button27).setOnClickListener(this);//戻るボタン

        //RegisterFamilySearchからユーザIDとユーザ名を受け取る
        Intent user_mail = getIntent();
        Intent user_name = getIntent();
        String get_user_mail = user_mail.getStringExtra("user_mail");
        String get_user_name = user_name.getStringExtra("user_name");
        //受け取ったユーザIDとユーザ名を挿入する
        view_user_mail.setText(get_user_mail);
        view_user_name.setText(get_user_name);
    }

    //ボタンを押下したら適切な画面に遷移する
    @Override
    public void onClick(View v) {
        //画面遷移用
        Intent check = new Intent(this, RegisterFamilyCheck.class);
        Intent cancel = new Intent(this, RegisterFamilySearch.class);
        if (v.getId() == R.id.button23) {
            //RegisterFamilySearchからユーザIDとユーザ名を受け取る
            Intent user_mail = getIntent();
            Intent user_name = getIntent();
            String get_user_mail = user_mail.getStringExtra("user_mail");
            String get_user_name = user_name.getStringExtra("user_name");
            //検索結果で取得したユーザidとユーザ名を次の画面に渡す
            check.putExtra("user_name",get_user_name);
            check.putExtra("user_mail",get_user_mail);
            //確認画面へ遷移
            startActivity(check);
        } else if (v.getId() == R.id.button27) {
            //検索画面へ遷移
            startActivity(cancel);
        }
    }
}
