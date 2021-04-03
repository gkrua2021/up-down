package com.example.a20210217;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    Button bt1;
    Button bt2;
    TextView tv1;
    TextView tv2;
    int number = 0;
    int i = 1;
    int a = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.et11);
        bt1 = (Button)findViewById(R.id.bt1);
        bt2= (Button)findViewById(R.id.bt2);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a == 0) {
                    number = (int) (Math.random() * 50) + 1;
                    tv1.setText("숫자 생성!");
                    Toast.makeText(getApplicationContext(), "숫자가 생성 되었습니다!", Toast.LENGTH_SHORT).show();
                    a += 1;
                }
                else{
                    Toast.makeText(getApplicationContext(), "이미 진행중인 게임이 있습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (number == 0) {
                    Toast.makeText(getApplicationContext(),"숫자를 먼저 생성해주세요",Toast.LENGTH_SHORT).show();
                } else {
                    if (Integer.parseInt(et1.getText().toString()) < number) {
                        tv1.setText("up");
                        i++;
                        tv2.append("\n" + et1.getText().toString() + "::   up");
                        et1.setText(null);
                    } else if (Integer.parseInt(et1.getText().toString()) > number) {
                        tv1.setText("down");
                        tv2.append("\n" + et1.getText().toString() + "::   down");
                        et1.setText(null);
                        i++;
                    } else if (Integer.parseInt(et1.getText().toString()) == number) {
                        tv2.append("\n" + et1.getText().toString() + "::   정답");
                        tv1.setText("정답");
                        tv1.setText("질문 횟수" + i);
                        a = 0;
                    }
                    else if(et1.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(),"숫자를 입력해주세요",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}