//山﨑里沙,2022/12/27
//家族のユーザ検索をするプログラム
package com.example.foodmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterFamilySearch extends AppCompatActivity implements View.OnClickListener {
    //変数の定義
    private EditText family_mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_family);

        //メールアドレス
        family_mail = (EditText) findViewById(R.id.editTextTextPersonName3);

        findViewById(R.id.button20).setOnClickListener(this);//検索ボタン
    }

    //ボタンを押下したら適切な画面に遷移する
    @Override
    public void onClick(View v) {
        String user_id;
        //画面遷移用
        Intent register_family = new Intent(this, RegisterFamilyName.class);
        Intent error = new Intent(this, SignUp.class);//後で変更
        Intent search = new Intent(this, RegisterFamilySearch2.class);

        if (v.getId() == R.id.button20) {
            //入力されたメールアドレスを取得する
            String get_family_mail = family_mail.getText().toString();
            //一致するデータがDBにあるか検索(ユーザIDとユーザ名が返ってくる)
            user_id = "yama";
            if (user_id.equals("")){
                startActivity(error);
            } else {
                //検索結果表示画面へ遷移
                search.putExtra("user_id",user_id);
                startActivity(search);
            }
        }
    }
}
