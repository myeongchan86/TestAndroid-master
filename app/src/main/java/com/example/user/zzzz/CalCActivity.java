package com.example.user.zzzz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalCActivity extends AppCompatActivity {
    private EditText et_no1, et_no2;
    private TextView tv_sign, tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_c);
        init();

    }

    private void init() {
        getSupportActionBar().setTitle(R.string.calcname);
        et_no1 = findViewById(R.id.et_no1);
        et_no1.setShowSoftInputOnFocus(false);
        et_no2 = findViewById(R.id.et_no2);
        et_no2.setShowSoftInputOnFocus(false);
        tv_sign = findViewById(R.id.tv_sign);
        tv_result = findViewById(R.id.tv_result);
    }

    public void calc_sign(View v) {
        Button sign = (Button)v;
        String str_sign = sign.getText().toString();
        String str_tv_result = tv_result.getText().toString();

        if(str_tv_result.equals("") || str_tv_result == null) {
            if (!str_sign.equals("C")) {
                tv_sign.setText(str_sign);
            } else {
                et_no1.setText("");
                tv_sign.setText("");
                et_no2.setText("");
                tv_result.setText("");
            }
        } else {
            et_no1.setText(str_tv_result);
            et_no2.setText("");
            tv_result.setText("");
            if (!str_sign.equals("C")) {
                tv_sign.setText(str_sign);
            } else {
                et_no1.setText("");
                tv_sign.setText("");
                et_no2.setText("");
                tv_result.setText("");
            }
        }
    }

    public void calc_num(View v) {
        Button num = (Button)v;
        String str_num = num.getText().toString();
        String tmp_et_no1 = et_no1.getText().toString();
        String tmp_et_no2 = et_no2.getText().toString();

        if(tv_sign == null || tv_sign.getText().toString().equals("")|| et_no1.getText().toString().equals("")) {
            tmp_et_no1 += str_num;
            et_no1.setText(tmp_et_no1);
            tv_sign.setText("");
            et_no2.setText("");
            tv_result.setText("");
        } else {
            tmp_et_no2 += str_num;
            et_no2.setText(tmp_et_no2);
        }

    }

    public void calc_anser(View v) {
        String str_first_num = et_no1.getText().toString();
        int first_num = checkInteger(str_first_num);
        double d_first_num = (double) first_num;
        String str_second_num = et_no2.getText().toString();
        int second_num = checkInteger(str_second_num);

        String sign = tv_sign.getText().toString();
        String tmp = "";
        String tmp2 = "";

        if (str_first_num.equals("") || str_second_num.equals("")) {

            tmp = "값을입력해";
        }
        tv_result.setText(tmp);

        if (str_second_num.equals("")) {
            tmp = "값을입력해";

            tv_result.setText(tmp);


    }else if (sign.equals("/")) {
            if (first_num == 0 || second_num == 0) {
                tmp = "에러에러";
            } else {
                tmp = String.format("%.3f", d_first_num / second_num);
            }
            tv_result.setText(tmp);




        } else if (sign.equals("*")) {
            tmp = String.valueOf(first_num * second_num);
            tv_result.setText(tmp);
        } else if (sign.equals("+")) {
            tmp = String.valueOf(first_num + second_num);
            tv_result.setText(tmp);
        } else if (sign.equals("-")) {
            tmp = String.valueOf(first_num - second_num);
            tv_result.setText(tmp);
        }
    }
    private int checkInteger(String str) {
        int tmp = 0;
        try {
            tmp = Integer.parseInt(str);
        } catch(Exception e) {
        }

        return tmp;
    }
}
