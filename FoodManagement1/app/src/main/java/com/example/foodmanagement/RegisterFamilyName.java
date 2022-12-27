//山﨑里沙,2022/12/27
//家族のグループ名を処理するプログラム
package com.example.foodmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterFamilyName extends AppCompatActivity implements View.OnClickListener {
    //変数の定義
    private EditText family_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_familyname);

        //家族グループ名
        family_name = (EditText) findViewById(R.id.editTextTextPersonName2);

        findViewById(R.id.button19).setOnClickListener(this);//次へボタン
        findViewById(R.id.button18).setOnClickListener(this);//戻るボタン
    }

    //ボタンを押下したら適切な画面に遷移する
    @Override
    public void onClick(View v) {
        //画面遷移用
        Intent next = new Intent(this, RegisterFamilySearch2.class);
        Intent cancel = new Intent(this, ViewFamily.class);

        if (v.getId() == R.id.button19) {
            //入力されたユーザ名を取得する
            String get_family_name = family_name.getText().toString();
            //データベースへの登録作業を記述
            //ユーザ検索画面へ遷移
            startActivity(next);
        } else if (v.getId() == R.id.button18) {
            //家族メニュー画面へ遷移
            startActivity(cancel);
        }
    }
}
