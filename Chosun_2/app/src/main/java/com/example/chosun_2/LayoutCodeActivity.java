package com.example.chosun_2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class LayoutCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout mlayout = new LinearLayout(this);
        mlayout.setOrientation(LinearLayout.generateViewId());

        LinearLayout.LayoutParams par =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        Button btn1 = new Button(this);
        btn1.setText("Button1");
        btn1.setLayoutParams(par);
        mlayout.addView(btn1);

        setContentView(mlayout);
    }
}