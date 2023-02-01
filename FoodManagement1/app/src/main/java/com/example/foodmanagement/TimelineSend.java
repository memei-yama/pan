//小川歩華，2022/12/19
//新規タイムラインを追加するプログラム
package com.example.foodmanagement;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentOnAttachListener;

import android.app.Activity;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View; //ボタンクリックのライブラリ
import android.content.Intent; //画面遷移のライブラリ
import android.widget.EditText;
import android.widget.ImageButton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TimelineSend extends AppCompatActivity implements View.OnClickListener {
    private EditText food_name;
    private EditText food_num;
    private ImageButton image;
    private Bitmap bitmap;
    private Uri getUri;

    int button = 3;

    //カメラのアクティビティ
    ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
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
                        //Uri getUri = getUriFromBitmap(bitmap);
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_send);

        food_name = (EditText) findViewById(R.id.foodName1);
        food_num = (EditText) findViewById(R.id.foodNum1);
        image = (ImageButton) findViewById(R.id.camera);

        findViewById(R.id.button31).setOnClickListener(this); //戻るボタン
        findViewById(R.id.button32).setOnClickListener(this); //投稿ボタン

        image = findViewById(R.id.camera);
        image.setOnClickListener(this); //画像挿入ボタン

        findViewById(R.id.homeButton).setOnClickListener(this);//ホーム
        findViewById(R.id.mypageButton).setOnClickListener(this);//マイページ
        findViewById(R.id.timelineButton).setOnClickListener(this);//タイムライン
        findViewById(R.id.messageButton).setOnClickListener(this);//メッセージ
    }



    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(v.getId() == R.id.camera) resultLauncher.launch(intent);

        Intent main = new Intent(this, TimelineMain.class);
        Intent next = new Intent(this, TimelineMainNext.class);
        if (v.getId() == R.id.button32) {
            /*
            String get_food_name = food_name.getText().toString();
            String get_food_num = food_num.getText().toString();

            TimelineSend.TimelinePost TLPost = new TimelineSend.TimelinePost(food_name, food_num);
            TLPost.execute();
             */

            startActivity(next);

        } else if (v.getId() == R.id.button31) {
            startActivity(main);
        }

        Intent home = new Intent(this, Home.class);
        Intent mypage = new Intent(this, Account.class);
        Intent timeline = new Intent(this, TimelineMain.class);
        Intent talk = new Intent(this, TalkMain.class);
        if (v.getId() == R.id.homeButton && button != 1) {
            startActivity(home);
            button = 1;

        } else if (v.getId() == R.id.mypageButton && button != 2) {
            startActivity(mypage);
            button = 2;

        } else if (v.getId() == R.id.timelineButton && button != 3) {
            startActivity(timeline);
            button = 3;

        } else if (v.getId() == R.id.messageButton && button != 4) {
            startActivity(talk);
            button = 4;
        }
    }

    /* Bitmapを一時ファイルとして保存してUriを返す。
    public Uri getUriFromBitmap(Bitmap bitmap)
    {
        File tmpFile = new File(getExternalCacheDir(),
                String.valueOf(System.currentTimeMillis()) + ".png");

        FileOutputStream fos = null;
        try {
            tmpFile.createNewFile();
            fos = new FileOutputStream(tmpFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, tmpFile.getName());
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/png");
        values.put(MediaStore.Images.Media.DATA,
                tmpFile.getAbsolutePath());
        Uri ImageUri = getContentResolver().insert(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        System.out.print(ImageUri.toString());
        return ImageUri;
    }
     */

    /*
    /**データベース接続
    public final class TimelinePost extends AsyncTask<String,String,String> {
        private final String API_URL_PREFIX = "ec2-18-212-59-223.compute-1.amazonaws.com";
        String get_food_name = food_name.getText().toString();
        String get_food_num = food_num.getText().toString();
        String get_image_uri = getUri.toString();

        public TimelinePost(EditText food_name,EditText food_num) {
        }

        @Override
        protected String doInBackground(String... strings) {
            //final StringBuilder result = new StringBuilder();
            Uri.Builder uriBuilder = new Uri.Builder();
            uriBuilder.scheme("http");
            uriBuilder.authority(API_URL_PREFIX);
            uriBuilder.path("insertTimelineInfo.php");
            final String uriStr = uriBuilder.build().toString();

            RequestBody formBody = new FormBody.Builder()
                    .add("user_id", "111")
                    .add("food_name", get_food_name)
                    .add("food_num", get_food_num)
                    .add("image_link", get_image_uri)
                    .build();

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(uriStr)
                    .post(formBody)
                    .build();

            try {
                Response response = client.newCall(request).execute();
                return response.body().toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String str) {
            Log.d("Debug", str);
        }
    }
    */
}
