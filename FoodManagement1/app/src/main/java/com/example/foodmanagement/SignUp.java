//山﨑里沙,2022/12/14
//新規登録するプログラム
package com.example.foodmanagement;

import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_account);

        InputMethodManager manager =
                (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //manager.hideSoftInputFromWindow(EditText.getWindowToken(), 0);
        manager.toggleSoftInput (1, InputMethodManager.SHOW_IMPLICIT);
    }
}
