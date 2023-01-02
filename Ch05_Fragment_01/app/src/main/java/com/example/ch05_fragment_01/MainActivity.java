package com.example.ch05_fragment_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public class BlankActivity01 extends AppCompatActivity {
        BlankFragment01 blankFragment01;
        MenuFragment menuFragment;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            blankFragment01 = (BlankFragment01) getSupportFragmentManager().findFragmentById(R.id.mainFragment);
            menuFragment = new MenuFragment();
        }

        public void onFragmentChanged(int index) {
            if (index == 0) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, menuFragment).commit();
            } else if (index == 1) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, blankFragment01).commit();
            }
        }

    }
}

