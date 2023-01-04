//小川歩華，2022/12/19
//タイムライン画面を表示するプログラム
package com.example.foodmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class timelineMain extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_main);

        findViewById(R.id.button30).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent send = new Intent(this, timelineSend.class);
        startActivity(send);
    }
}
