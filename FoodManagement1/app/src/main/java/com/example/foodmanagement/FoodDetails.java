//山口芽依,2022/12/18
//食品の詳細情報を表示するプログラム

package com.example.foodmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;

public class FoodDetails extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_details);

        //各種ボタン設定
        //戻る
        findViewById(R.id.button36).setOnClickListener(this);
        //更新
        findViewById(R.id.button35).setOnClickListener(this);
        //削除
        findViewById(R.id.button33).setOnClickListener(this);
    }

    //画面遷移
    @Override
    public void onClick(View v){
        Intent home = new Intent(this, Home.class);
        Intent food_update = new Intent(this, FoodUpdate.class);
        Intent food_delete = new Intent(this, FoodDelete.class);

        if (v.getId() == R.id.button36){
            //ホーム画面
            startActivity(home);
        }else if (v.getId() == R.id.button35){
            //食品更新
            startActivity(food_update);
        }else if (v.getId() == R.id.button33){
            startActivity(food_delete);
        }

    }
}