package com.example.android.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button a1,a2,a3,b1,b2,b3,c1,c2,c3;
    Button[] barray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a1=(Button)findViewById(R.id.a1);
        a2=(Button)findViewById(R.id.a2);
        a3=(Button)findViewById(R.id.a3);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.a1);
        a1=(Button)findViewById(R.id.a1);
        a2=(Button)findViewById(R.id.a1);
        a3=(Button)findViewById(R.id.a1);






    }
}
