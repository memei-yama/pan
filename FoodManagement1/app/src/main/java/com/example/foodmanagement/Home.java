//山口芽依,2023/01/03
//ホーム画面のプログラム

package com.example.foodmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.content.Intent;
import android.widget.GridView;
import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity implements View.OnClickListener{

    private final String[]  sample ={
            "りんご", "じゃがいも"
    };

    //private final List<Integer> imgList = new ArrayList<>();

    //値の受け取り用
    private String home_food_name;
    private String home_food_date;
    private String home_spinnerItems;
    private String home_food_shop;
    private String home_food_num;
    private String home_category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_grid); //xmlファイル名変更

        //RegisterFood.javaから値の受け取り
        Intent intent = getIntent();

        home_food_name = intent.getStringExtra("get_food_name");
        home_food_date = intent.getStringExtra("get_food_date");
        home_spinnerItems = intent.getStringExtra("get_spinnerItems");
        home_food_shop = intent.getStringExtra("get_food_shop");
        home_food_num = intent.getStringExtra("get_food_num");
        home_category = intent.getStringExtra("get_category");


        //各種ボタン設定
        //食品登録
        findViewById(R.id.regFood).setOnClickListener(this);

        //食品を選択（食品詳細表示）

        //削除モード
        findViewById(R.id.delFood).setOnClickListener(this);

        //ホームボタン
        findViewById(R.id.homeButton).setOnClickListener(this);
        //マイページ
        findViewById(R.id.mypageButton).setOnClickListener(this);
        //タイムライン
        findViewById(R.id.timelineButton).setOnClickListener(this);
        //メッセージ
        findViewById(R.id.messageButton).setOnClickListener(this);


        //表示
        //GridView = (GridView)findViewById(R.id.food_grid);


    }

    @Override
    public void onClick(View v) {
        Intent food_register_menu = new Intent(this, RegisterFoodMenu.class);
        Intent food_details = new Intent(this, FoodDetails.class);
        Intent food_search = new Intent(this, FoodSearch.class);
        Intent food_sort = new Intent(this, FoodSearch.class);
        Intent favorite = new Intent(this, Favorite.class);
        Intent delete_mode = new Intent(this, DeleteMode.class);

        Intent home = new Intent(this, Home.class);
        Intent mypage = new Intent(this, Account.class);
        Intent timeline = new Intent(this, TimelineMain.class);
        Intent message = new Intent(this, Message.class);


        //どのボタンが押下されたか、それによる画面遷移
        if (v.getId() == R.id.regFood){ //食品登録ボタン
            startActivity(food_register_menu);

        } else if (v.getId() == R.id.delFood){ //削除モードボタン
            //startActivity(delete_mode);

            //食品詳細用
            //FoodDetails.javaへの受け渡し用
            food_details.putExtra("get_food_name", home_food_name);
            food_details.putExtra("get_food_date", home_food_date);
            food_details.putExtra("get_spinnerItems", home_spinnerItems);
            food_details.putExtra("get_food_shop", home_food_shop);
            food_details.putExtra("get_food_num", home_food_num);
            food_details.putExtra("get_category", home_category);

            startActivity(food_details); //今は削除モードを押すと食品詳細が出るようになってる


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

