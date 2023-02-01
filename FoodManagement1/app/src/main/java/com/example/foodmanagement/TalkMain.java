//小川歩華，2022/12/19
//トーク一覧を表示するプログラム
package com.example.foodmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TalkMain extends AppCompatActivity implements View.OnClickListener{
    private TextView text;
    private EditText message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.talk_main);

        findViewById(R.id.imageButton5).setOnClickListener(this);
        findViewById(R.id.imageButton4).setOnClickListener(this);
        text = (TextView) findViewById(R.id.textView38);
        message = (EditText) findViewById(R.id.editTextTextPersonName7);
    }

    public void onClick(View v){
        Intent back = new Intent(this, DisplayFamilyFriend.class);
        if (v.getId() == R.id.imageButton4 && text.getVisibility() != View.VISIBLE) {
            text.setVisibility(View.VISIBLE);
            message.getEditableText().clear();
        } else if (v.getId() == R.id.imageButton5) {
            startActivity(back);
        }
    }
}
