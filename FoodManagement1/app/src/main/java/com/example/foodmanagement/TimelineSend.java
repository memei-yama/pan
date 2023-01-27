//小川歩華，2022/12/19
//新規タイムラインを追加するプログラム
package com.example.foodmanagement;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View; //ボタンクリックのライブラリ
import android.content.Intent; //画面遷移のライブラリ
import android.widget.EditText;
import android.widget.ImageButton;

public class TimelineSend extends AppCompatActivity implements View.OnClickListener {
    private EditText food_name;
    private EditText food_num;
    private ImageButton image;

    ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    if(data != null) {
                        Bitmap bitmap;
                        //キャンセルしたケースも含む
                        if (data.getExtras() == null) {
                            Log.d("debug", "cancel ?");
                            return;
                        } else {
                            bitmap = (Bitmap) data.getExtras().get("data");
                            if(bitmap != null) {
                                //画像サイズ計測
                                int bmpWidth = bitmap.getWidth();
                                int bmpHeight = bitmap.getHeight();
                                Log.d("debug", String.format("w= %d", bmpWidth));
                                Log.d("debug", String.format("h= %d", bmpHeight));
                            }
                        }
                        image.setImageBitmap(bitmap);
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_send);

        food_name = (EditText) findViewById(R.id.foodName1);
        food_num = (EditText) findViewById(R.id.foodNum1);

        findViewById(R.id.button31).setOnClickListener(this); //戻るボタン
        findViewById(R.id.button32).setOnClickListener(this); //投稿ボタン
        findViewById(R.id.camera).setOnClickListener(this); //画像挿入ボタン
    }



    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(v.getId() == R.id.camera) {
            resultLauncher.launch(intent);
        }
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
