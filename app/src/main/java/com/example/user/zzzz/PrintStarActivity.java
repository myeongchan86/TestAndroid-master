package com.example.user.zzzz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PrintStarActivity extends AppCompatActivity {
    private EditText star_editText;
    private Button star_button1;
    private TextView star_textView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_star);
        getSupportActionBar().setTitle("별찍기");
        init();
    }

    private void init() {
        star_editText = findViewById(R.id.star_editText);
        star_button1 = findViewById(R.id.star_button1);
        star_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit_value = star_editText.getText().toString();
                int edit_num_value = checkInteget(edit_value);
                String str = "";

                if(edit_num_value > 0) {
                    for(int i = 1; i <= edit_num_value; i++) {
                        for(int z = 0; z < i; z++) {
                            str += "*";
                        }
                        str += "\n";
                    }

                    star_textView1.setText(str);
                    star_editText.setText(null);
                } else {
                    star_textView1.setText("입력된 값이 없습니다.");
                    star_editText.setText(null);
                }
            }
        });

        star_textView1 = findViewById(R.id.star_textView1);
    }

    private int checkInteget(String str) {
        int tmp = 0;
        try {
            tmp = Integer.parseInt(str);
        } catch(Exception e) {
        }

        return tmp;
    }

}
