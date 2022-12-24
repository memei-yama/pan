//山﨑里沙,2022/12/24
//マイページから家族メニューを表示するプログラム
package com.example.foodmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ViewFamily extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.family_menu);

        findViewById(R.id.button11).setOnClickListener(this);//家族新規作成ボタン
        findViewById(R.id.button12).setOnClickListener(this);//家族承認ボタン
        findViewById(R.id.button13).setOnClickListener(this);//家族削除ボタン
    }

    //ボタンを押下したら適切な画面に遷移する
    @Override
    public void onClick(View v) {
        //画面遷移用
        Intent register_family = new Intent(this, RegisterFamily.class);
        Intent notice_family = new Intent(this, LoginAccount.class);//承認を実装するなら後から変更
        Intent delete_family = new Intent(this, DeleteFamily.class);

        if (v.getId() == R.id.button11) {
            //家族登録画面へ遷移
            startActivity(register_family);
        } else if (v.getId() == R.id.button12) {
            //家族承認画面へ遷移
            //今はログイン画面、承認を実装するなら変更
            startActivity(notice_family);
        } else if (v.getId() == R.id.button13) {
            //家族削除画面へ遷移
            startActivity(delete_family);
        }
    }
}
