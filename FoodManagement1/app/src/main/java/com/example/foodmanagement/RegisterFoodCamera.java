//山口芽依,2023/01/05
//食品登録の際にカメラ読み取りをするプログラム

package com.example.foodmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;


public class RegisterFoodCamera extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_foodmenu);



        //バーコード(JANコード)読み取りの処理


        //読み取りが終わったらRegisterFood.javaに遷移する
        Intent register_self = new Intent(this, RegisterFood.class);

        startActivity(register_self);
    }

}
