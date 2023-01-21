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

        //検索
        //search_button = findViewById(R.id.button ).setOnClickListener(this);

        //並べ替え
        //sort_button = findViewById(R.id.button ).setOnClickListener(this);

        //お気に入り
        //favorite_button = findViewById(R.id.button ).setOnClickListener(this);

        //削除モード
        findViewById(R.id.delFood).setOnClickListener(this);
    }


    //

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

