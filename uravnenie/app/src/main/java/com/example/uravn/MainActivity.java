package com.example.uravn;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import static java.lang.Math.sqrt;

public class MainActivity extends AppCompatActivity {

    double a_d, c_d, b_d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText a = findViewById(R.id.a_inp);
                EditText b = findViewById(R.id.b_inp);
                EditText c = findViewById(R.id.c_inp);
                TextView otv = findViewById(R.id.otv);
                String solve;
                String solve2;
                boolean exep=false;
                try {
                    a_d = Double.parseDouble(a.getText().toString());

                }catch (NumberFormatException a_d){
                    exep= true;
                }
                try {
                    b_d = Double.parseDouble(b.getText().toString());

                }catch (NumberFormatException b_d){
                    exep= true;
                }
                try {
                    c_d = Double.parseDouble(c.getText().toString());

                }catch (NumberFormatException c_d){
                    exep= true;
                }
                if(exep){
                    otv.setTextSize(14);
                    otv.setTextColor(Color.RED);
                    otv.setText("error");

                }else {
                    otv.setTextColor(Color.BLACK);
                    otv.setTextSize(21);

                    double D = b_d*b_d-4*a_d*c_d;
                    if(D==0){
                        solve = "x1= "+String.format("%.2f", (-b_d+sqrt(D))/(2*a_d));
                        otv.setText(solve);

                    }
                    if(D>0){
                        solve = String.format("%.2f", (-b_d+sqrt(D))/(2*a_d));
                        solve2 = String.format("%.2f", (-b_d-sqrt(D))/(2*a_d));
                        otv.setText("x1= "+solve+" ; x2= "+ solve2);
                    }
                    if(D<0){
                        otv.setText("Нет решений");
                    }
                }
            }
        });
    }

}
