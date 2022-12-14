//山﨑里沙,2022/12/14
//初期画面からログイン画面と新規登録画面に遷移することができる
package com.example.foodmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //buttonはログイン,button2は新規登録
        findViewById(R.id.button).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.button2).setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            Intent intent = new Intent(getApplication(), LoginAccount.class);
            startActivity(intent);
        } else if (v.getId() == R.id.button2) {
            Snackbar.make(v, "ボタン２が押されました", Snackbar.LENGTH_SHORT).show();

        }
    }
}