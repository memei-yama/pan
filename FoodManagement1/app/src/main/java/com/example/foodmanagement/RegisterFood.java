//山口芽依,2023/01/03
//食品登録のプログラム 手入力ボタンを押すとここに遷移してくる

package com.example.foodmanagement;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Message;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

//賞味or消費
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

//calender
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.icu.util.Calendar;

//個数選択
import android.widget.ImageButton;
import android.widget.NumberPicker;

//お気に入り
import android.widget.ImageView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.view.ViewGroup;



public class RegisterFood extends AppCompatActivity implements View.OnClickListener{

    //変数(テキスト)の設定
    private EditText food_name;
    private String[] spinnerItems = {
            "賞味",
            "消費"
    };
    private EditText food_date;
    private EditText food_shop;
    private EditText category;
    private NumberPicker food_num;
    private ImageButton favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_food);

        //食品名　（テキスト）
        food_name = (EditText) findViewById(R.id.foodName);

        //賞味・消費選択
        Spinner spinner = findViewById(R.id.spinner);

        // ArrayAdapter
        ArrayAdapter<String> adapter
                = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, spinnerItems);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // spinner に adapter をセット
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            //　アイテムが選択された時
            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int position, long id) {
                Spinner spinner = (Spinner)parent;
                String item = (String)spinner.getSelectedItem();
                //textView.setText(item);
            }

            //　アイテムが選択されなかった
            public void onNothingSelected(AdapterView<?> parent) {
                //
            }
        });


        //期限　（カレンダー）
        food_date = (EditText) findViewById(R.id.editTextDate);

        food_date.setOnClickListener(new View.OnClickListener() {
                     @RequiresApi(api = Build.VERSION_CODES.N)
                     @Override
                     public void onClick(View v) {
                         final Calendar date = Calendar.getInstance();

                         DatePickerDialog datePickerDialog = new DatePickerDialog(
                                 RegisterFood.this,
                                 new DatePickerDialog.OnDateSetListener() {
                                     @Override
                                     public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                         //setした日付を取得して表示
                                         food_date.setText(String.format("%d / %02d / %02d", year, month + 1, dayOfMonth));
                                     }
                                 },
                                 date.get(Calendar.YEAR),
                                 date.get(Calendar.MONTH),
                                 date.get(Calendar.DATE)
                         );
                         //dialogを表示
                         datePickerDialog.show();
                     }
        });


        //購入店舗（テキスト）
        food_shop = (EditText) findViewById(R.id.shopName);

        //カテゴリー
        category = (EditText) findViewById(R.id.editTextTextPersonName6);

        //個数　（個数選択）
        food_num = (NumberPicker) findViewById(R.id.foodNum);

        //個数の上限、下限値、初期値設定
        food_num.setMaxValue(50);
        food_num.setMinValue(1);
        food_num.setValue(1);

        //お気に入り
        findViewById(R.id.imageButton2).setOnClickListener(onClickSetImage);


        //戻るボタン
        findViewById(R.id.button37).setOnClickListener(this);
        //登録ボタン
        findViewById(R.id.button38).setOnClickListener(this);

        //ホームボタン
        findViewById(R.id.homeButton).setOnClickListener(this);
        //マイページ
        findViewById(R.id.mypageButton).setOnClickListener(this);
        //タイムライン
        findViewById(R.id.timelineButton).setOnClickListener(this);
        //メッセージ
        findViewById(R.id.messageButton).setOnClickListener(this);

    }

    //ハートマークの画像変更
    View.OnClickListener onClickSetImage = new View.OnClickListener() {
        int res_id = R.drawable.heart;

        @Override
        public void onClick(View v) {
            // 画像情報更新
            switch(res_id) {
                case R.drawable.heart: res_id = R.drawable.color_heart; break;
                case R.drawable.color_heart: res_id = R.drawable.heart; break;
            }

            // 画像切り替え
            ((ImageView)v).setImageResource(res_id);
        }
    };



    //画面遷移
    @Override
    public void onClick(View v) {


        Intent register_menu = new Intent(this, RegisterFoodMenu.class);
        Intent home = new Intent(this, Home.class);
        Intent mypage = new Intent(this, Account.class);
        Intent timeline = new Intent(this, TimelineMain.class);
        Intent message = new Intent(this, Message.class);


        if (v.getId() == R.id.button48){ //登録
            home.putExtra("get_food_name", food_name.getText().toString());
            home.putExtra("get_food_date", food_date.getText().toString());
            home.putExtra("get_spinnerItems", spinnerItems.toString());
            home.putExtra("get_food_shop", food_shop.getText().toString());
            home.putExtra("get_food_num", food_num.toString());
            home.putExtra("get_category", category.getText().toString());
            startActivity(home);

        } else if (v.getId() == R.id.button37){ //戻る
            startActivity(register_menu);

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
