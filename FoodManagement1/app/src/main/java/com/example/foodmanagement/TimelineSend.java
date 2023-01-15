//小川歩華，2022/12/19
//新規タイムラインを追加するプログラム
package com.example.foodmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View; //ボタンクリックのライブラリ
import android.content.Intent; //画面遷移のライブラリ
import android.widget.EditText;

public class TimelineSend extends AppCompatActivity implements View.OnClickListener {
    private EditText food_name;
    private EditText food_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_send);

        food_name = (EditText) findViewById(R.id.foodName1);
        food_num = (EditText) findViewById(R.id.foodNum1);

        findViewById(R.id.button31).setOnClickListener(this); //戻るボタン
        findViewById(R.id.button32).setOnClickListener(this); //投稿ボタン
    }

    @Override
    public void onClick(View v) {
        Intent main = new Intent(this, TimelineMain.class);
        if (v.getId() == R.id.button32) {
            String get_food_name = food_name.getText().toString();
            String get_food_num_string = food_num.getText().toString();
            int get_food_num = Integer.parseInt(get_food_num_string);

            startActivity(main);

        } else if (v.getId() == R.id.button31) {
            startActivity(main);
        }
    }
}
