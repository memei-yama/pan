//山﨑里沙,2022/12/24
//マイページからフレンドメニューを表示するプログラム
package com.example.foodmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ViewFriend extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend_mamu);

        findViewById(R.id.button14).setOnClickListener(this);//フレンド表示ボタン
        findViewById(R.id.button15).setOnClickListener(this);//フレンド登録ボタン
        findViewById(R.id.button16).setOnClickListener(this);//フレンド承認ボタン
        findViewById(R.id.button17).setOnClickListener(this);//フレンド削除ボタン
    }

    //ボタンを押下したら適切な画面に遷移する
    @Override
    public void onClick(View v) {
        //画面遷移用
        Intent show_friend = new Intent(this, DisplayFamilyFriend.class);
        Intent register_friend = new Intent(this, RegisterFriend.class);
        Intent approval_friend = new Intent(this, Approval.class);
        Intent delete_friend = new Intent(this, DeleteFriend.class);

        if (v.getId() == R.id.button14) {
            //フレンド表示画面へ遷移
            startActivity(show_friend);
        } else if (v.getId() == R.id.button15) {
            //フレンド登録画面へ遷移
            startActivity(register_friend);
        } else if (v.getId() == R.id.button16) {
            //フレンド承認画面へ遷移
            startActivity(approval_friend);
        } else if (v.getId() == R.id.button17) {
            //フレンド削除画面へ遷移
            startActivity(delete_friend);
        }
    }
}