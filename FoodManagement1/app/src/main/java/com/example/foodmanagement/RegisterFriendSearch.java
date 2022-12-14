//山﨑里沙,2022/12/29
//フレンドユーザを検索するプログラム,これは使わない(RegisterFamilyで実装)
package com.example.foodmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterFriendSearch extends AppCompatActivity implements View.OnClickListener {
    //変数の定義
    private EditText family_mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_family);

        //メールアドレス
        family_mail = (EditText) findViewById(R.id.editTextTextPersonName3);

        findViewById(R.id.button20).setOnClickListener(this);//検索ボタン
        findViewById(R.id.button26).setOnClickListener(this);//戻るボタン
    }

    //ボタンを押下したら適切な画面に遷移する
    @Override
    public void onClick(View v) {
        String user_mail;
        String user_name;
        //画面遷移用
        Intent cancel = new Intent(this, ViewFriend.class);
        Intent error = new Intent(this, RegisterFamilyError.class);
        Intent search = new Intent(this, RegisterFriendSearch2.class);

        if (v.getId() == R.id.button20) {
            //入力されたメールアドレスを取得する
            String get_family_mail = family_mail.getText().toString();
            //一致するデータがDBにあるか検索(ユーザIDとユーザ名が返ってくる)
            user_mail = "yamada_hanako@gmail.com";
            user_name = "yammma";
            if (user_mail.equals("")){
                startActivity(error);
            } else {
                //検索結果で取得したユーザidとユーザ名を次の画面に渡す
                search.putExtra("user_name",user_name);
                search.putExtra("user_mail",user_mail);
                //検索結果表示画面へ遷移
                startActivity(search);
            }
        } else if (v.getId() == R.id.button26) {
            startActivity(cancel);
        }
    }
}
