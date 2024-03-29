//山口芽依,2022/12/18
//食品の詳細情報を表示するプログラム

package com.example.foodmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Message;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FoodDetails extends AppCompatActivity implements View.OnClickListener{

    //値の受け取り用
    private TextView food_name;
    private TextView food_date;
    private TextView food_shop;
    private TextView food_num;

    private TextView spinner_item;
    private TextView category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_details);

        //Register⇒Home⇒Details値の受けとり
        Intent intent = getIntent();
        String details_food_name = intent.getStringExtra("get_food_name");
        String details_food_date = intent.getStringExtra("get_food_date");
        String details_spinnerItems = intent.getStringExtra("get_spinnerItems");
        String details_food_shop = intent.getStringExtra("get_food_shop");
        String details_food_num = intent.getStringExtra("get_food_num");
        String details_category = intent.getStringExtra("get_category");


        food_name = (TextView) findViewById(R.id.foodName6);
        food_date = (TextView) findViewById(R.id.data3);
        food_shop = (TextView) findViewById(R.id.shopName6);
        food_num = (TextView) findViewById(R.id.foodNum6);

        //賞味or消費のTextView
        spinner_item = (TextView) findViewById(R.id.textView36);
        //カテゴリー名のTextView
        category = (TextView) findViewById(R.id.textView35);


        //RegisterFood ⇒ Home ⇒ Details で受け取った値をtextviewにセット
        food_name.setText(details_food_name);
        food_date.setText(details_food_date);
        food_shop.setText(details_food_shop);
        food_num.setText(details_food_num);

        spinner_item.setText(details_spinnerItems);
        category.setText(details_category);



        //各種ボタン設定
        //戻る
        findViewById(R.id.button36).setOnClickListener(this);
        //更新
        findViewById(R.id.button35).setOnClickListener(this);
        //削除
        findViewById(R.id.button33).setOnClickListener(this);

        //ホームボタン
        findViewById(R.id.homeButton).setOnClickListener(this);
        //マイページ
        findViewById(R.id.mypageButton).setOnClickListener(this);
        //タイムライン
        findViewById(R.id.timelineButton).setOnClickListener(this);
        //メッセージ
        findViewById(R.id.messageButton).setOnClickListener(this);
    }

    //画面遷移
    @Override
    public void onClick(View v){
        Intent home = new Intent(this, Home.class);
        Intent food_update = new Intent(this, FoodUpdate.class);
        Intent food_delete = new Intent(this, FoodDelete.class);

        Intent mypage = new Intent(this, Account.class);
        Intent timeline = new Intent(this, TimelineMain.class);
        Intent message = new Intent(this, Message.class);


        if (v.getId() == R.id.button36){
            //ホーム画面

            home.putExtra("get_food_name", food_name.getText().toString());
            home.putExtra("get_food_date", food_date.getText().toString());
            home.putExtra("get_spinnerItems", spinner_item.getText().toString());
            home.putExtra("get_food_shop", food_shop.getText().toString());
            home.putExtra("get_food_num", food_num.getText().toString());
            home.putExtra("get_category", category.getText().toString());

            startActivity(home);

        //ベルトの遷移
        }else if (v.getId() == R.id.homeButton) { //ホームボタン
            startActivity(home);

        }else if (v.getId() == R.id.mypageButton) { //マイページボタン
            startActivity(mypage);

        }else if (v.getId() == R.id.timelineButton) { //タイムラインボタン
            startActivity(timeline);

        }else if (v.getId() == R.id.messageButton) { //メッセージボタン
            startActivity(message);
        }

    }
}