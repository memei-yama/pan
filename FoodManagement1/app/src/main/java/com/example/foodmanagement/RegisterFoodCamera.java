//山口芽依,2023/01/05
//食品登録の際にカメラ読み取りをするプログラム

package com.example.foodmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

//カメラ読み取りで追加したimport

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.widget.TextView;
import android.widget.Toast;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.CompoundBarcodeView;
import com.journeyapps.barcodescanner.camera.CameraSettings;
import java.util.List;


public class RegisterFoodCamera extends AppCompatActivity implements View.OnClickListener{
//public class RegisterFoodCamera extends AppCompatActivity{
    CompoundBarcodeView barcodeView;
    private String lastResult;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_foodcamera);

        //入力ボタン
        findViewById(R.id.button49).setOnClickListener(this);

        if(ActivityCompat.checkSelfPermission(RegisterFoodCamera.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            String[] permissions = {Manifest.permission.CAMERA};
            ActivityCompat.requestPermissions(RegisterFoodCamera.this, permissions, 100);
            return;
        }

        CameraSetting();
        readBarcode();

        //読み取りが終わったらRegisterFood.javaに遷移する

    }

    //画面遷移
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button49) { //次へボタン
            //動画用
             String food_name = "こっぺぱん";

            Intent register_food = new Intent(this, RegisterFood.class);
            register_food.putExtra("get_food_name", food_name);
            startActivity(register_food);
        }
    }



    private void CameraSetting() {
        barcodeView = findViewById(R.id.barcodeView);
        CameraSettings settings = barcodeView.getBarcodeView().getCameraSettings();
        barcodeView.getBarcodeView().setCameraSettings(settings);
        barcodeView.setStatusText("バーコードが読めます");
        barcodeView.resume();
        readBarcode();
    }

    private void readBarcode() {
        barcodeView.decodeContinuous(new BarcodeCallback() {
            final TextView getNumber = findViewById(R.id.getNumber);

            @Override
            public void barcodeResult(BarcodeResult result) {
                //このif文で、不必要な連続読みを防ぐ
                if (result.getText() == null || result.getText().equals(lastResult)) {
                    return;
                }
                //このif文で、読み取られたバーコードがJANコードかどうか判定する
                if (result.getBarcodeFormat() != BarcodeFormat.EAN_13) {
                    return;
                }
                lastResult = result.getText();
                Toast.makeText(RegisterFoodCamera.this, "読み取りました", Toast.LENGTH_LONG).show();
                getNumber.setText(result.getText());

                //読み取りが終わったらRegisterFood.javaに遷移する
                //Intent register_self = new Intent(this, RegisterFood.class);
                //startActivity(register_self);

            }

            @Override
            public void possibleResultPoints(List<ResultPoint> resultPoints) {
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.checkSelfPermission(RegisterFoodCamera.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
        }
        CameraSetting();
    }

}