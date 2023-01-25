//山口芽依,2023/01/03
//ホーム画面のプログラム

package com.example.foodmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class Home extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_grid); //xmlファイル名変更

        //各種ボタン設定
        //食品登録
        findViewById(R.id.regFood).setOnClickListener(this);

        //食品を選択（食品詳細表示）

        //削除モード
        //findViewById(R.id.delFood).setOnClickListener(this);


        //表示
        //mGridView = (GridView)findViewById(R.id.food_grid);


        //RegisterFoodからの値を取得
        Intent intent = getIntent();
        String food_name = intent.getStringExtra("get_food_name");
        String food_date = intent.getStringExtra("get_food_date");
        String spinnerItems = intent.getStringExtra("get_spinnerItems");
        String food_shop = intent.getStringExtra("get_food_shop");
        String food_num = intent.getStringExtra("get_food_num");
        String category = intent.getStringExtra("get_category");


    }

    @Override
    public void onClick(View v) {
        Intent food_register_menu = new Intent(this, RegisterFoodMenu.class);
        Intent food_details = new Intent(this, FoodDetails.class);
        Intent food_search = new Intent(this, FoodSearch.class);
        Intent food_sort = new Intent(this, FoodSearch.class);
        Intent favorite = new Intent(this, Favorite.class);
        Intent delete_mode = new Intent(this, DeleteMode.class);


        //どのボタンが押下されたか、それによる画面遷移
        if (v.getId() == R.id.regFood){ //食品登録ボタン
            startActivity(food_register_menu);
        } else if (v.getId() == R.id.delFood){ //削除モードボタン
            startActivity(delete_mode);
        }

    }
}

