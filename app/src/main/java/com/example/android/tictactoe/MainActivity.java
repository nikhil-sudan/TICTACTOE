package com.example.android.tictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button a1,a2,a3,b1,b2,b3,c1,c2,c3,re;
    Button[] barray;

    Boolean turn=true;
    int turn_count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        a1=(Button)findViewById(R.id.a1);
        a2=(Button)findViewById(R.id.a2);
        a3=(Button)findViewById(R.id.a3);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        c1=(Button)findViewById(R.id.c1);
        c2=(Button)findViewById(R.id.c2);
        c3=(Button)findViewById(R.id.c3);

//Play Again Button
        re=(Button)findViewById(R.id.re);
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(Button b: barray){
                    b.setBackgroundColor(Color.parseColor("#33b5e5"));
                    b.setClickable(true);
                    b.setText("-");
                    turn=true;
                    turn_count=0;
                }
            }
        });

        //ARRAY OF BUTTONS
        barray= new Button[]{a1,a2,a3,b1,b2,b3,c1,c2,c3};

        for(Button b: barray){
            b.setText("-");
        }

        for(Button b: barray){
            b.setOnClickListener( this);
        }

    }

    @Override
    public void onClick(View v) {

        Button b = (Button) v;
        ButtonClicked(b);
    }

    private void ButtonClicked(Button b) {

        if(turn){

            b.setText("X");
            b.setBackgroundColor(Color.RED);

        }else{
            b.setText("O");
            b.setBackgroundColor(Color.YELLOW);
        }

        turn_count++;
        b.setClickable(false);
        turn= !turn;
        checkforwinner(turn);

    }



    private void checkforwinner(Boolean turn) {
        boolean there_is_a_winner = false;

//HORIZONTAL


            if (a1.getText() == a2.getText() && a2.getText() == a3.getText()&&!a1.isClickable()) {
                there_is_a_winner = true;
            }
            else if (b1.getText() == b2.getText() && b2.getText() == b3.getText()&&!b1.isClickable()) {
                there_is_a_winner = true;
            }
            if (c1.getText() == c2.getText() && c2.getText() == c3.getText()&&!c1.isClickable()) {
                there_is_a_winner = true;
            }

//VERTICAL
            if (a1.getText() == b1.getText() && b1.getText() == c1.getText()&&!a1.isClickable()) {
                there_is_a_winner = true;
            }
            if (a2.getText() == b2.getText() && b2.getText() == c2.getText()&&!b2.isClickable()) {
                there_is_a_winner = true;
            }
            if (a3.getText() == b3.getText() && b3.getText() == c3.getText()&&!c3.isClickable()) {
                there_is_a_winner = true;
            }


//DIAGONAL

            if (a1.getText() == b2.getText() && b2.getText() == c3.getText()&&!a1.isClickable()) {
                there_is_a_winner = true;
            }
            if (a3.getText() == b2.getText() && b2.getText() == c1.getText()&&!b2.isClickable()) {
                there_is_a_winner = true;
            }


            if (turn_count==9){
                toast("match is Draw");
                disableallbuttons();
            }



        if (there_is_a_winner) {

            if (!turn) {
                toast("X wins");
            } else {
                toast("O wins");
            }

            disableallbuttons();
        }
    }

    private void disableallbuttons() {
        for(Button b: barray){
            b.setClickable(false);
            b.setBackgroundColor(Color.LTGRAY);
        }

    }

    private void toast(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();

    }
}
