//小川歩華, 2023/1/3
//timelineMainに表示されるタイムラインのプログラム
package com.example.foodmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class timelineList extends AppCompatActivity implements View.OnClickListener{
    boolean favorite = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_tl);

        findViewById(R.id.heratButton).setOnClickListener(this);
        ImageButton myImage = findViewById(R.id.heratButton);
    }

    @Override
    public void onClick(View v){
        ImageButton heart = findViewById(R.id.heratButton);

        if (!favorite) {
            heart.setImageResource(R.drawable.color_heart);
            favorite = true;

        } else if (favorite) {
            heart.setImageResource(R.drawable.heart);
            favorite = false;
        }
    }

}
