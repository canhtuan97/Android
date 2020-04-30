package vn.hust.edu.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textResult;

    int state;      // trang thai - 1: nhap toan hang 1, 2: nhap toan hang 2
    int op1, op2;   // toan hang 1 va toan hang 2
    int op;         // toan tu - 1: add, 2: sub, 3: mul, 4: div

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResult = findViewById(R.id.text_result);
        Typeface tf = Typeface.createFromAsset(getAssets(), "DS-DIGI.TTF");
        textResult.setTypeface(tf);

        findViewById(R.id.btn_0).setOnClickListener(this);
        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
        findViewById(R.id.btn_3).setOnClickListener(this);
        findViewById(R.id.btn_4).setOnClickListener(this);
        findViewById(R.id.btn_5).setOnClickListener(this);
        findViewById(R.id.btn_6).setOnClickListener(this);
        findViewById(R.id.btn_7).setOnClickListener(this);
        findViewById(R.id.btn_8).setOnClickListener(this);
        findViewById(R.id.btn_9).setOnClickListener(this);

        findViewById(R.id.btn_add).setOnClickListener(this);
        findViewById(R.id.btn_sub).setOnClickListener(this);
        findViewById(R.id.btn_mul).setOnClickListener(this);
        findViewById(R.id.btn_div).setOnClickListener(this);
        findViewById(R.id.btn_equal).setOnClickListener(this);

        findViewById(R.id.btn_CE).setOnClickListener(this);
        findViewById(R.id.btn_C).setOnClickListener(this);
        findViewById(R.id.btn_BS).setOnClickListener(this);
        findViewById(R.id.btn_rev).setOnClickListener(this);

        state = 1;
        op1 = op2 = 0;
        op = 0;
        textResult.setText(String.valueOf(op1));
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_0)
            addDigit(0);
        else if (id == R.id.btn_1)
            addDigit(1);
        else if (id == R.id.btn_2)
            addDigit(2);
        else if (id == R.id.btn_3)
            addDigit(3);
        else if (id == R.id.btn_4)
            addDigit(4);
        else if (id == R.id.btn_5)
            addDigit(5);
        else if (id == R.id.btn_6)
            addDigit(6);
        else if (id == R.id.btn_7)
            addDigit(7);
        else if (id == R.id.btn_8)
            addDigit(8);
        else if (id == R.id.btn_9)
            addDigit(9);
        else if (id == R.id.btn_add)
            selectOperand(1);
        else if (id == R.id.btn_sub)
            selectOperand(2);
        else if (id == R.id.btn_mul)
            selectOperand(3);
        else if (id == R.id.btn_div)
            selectOperand(4);
        else if (id == R.id.btn_equal)
            calculateResult();
        else if (id == R.id.btn_rev)
            reverse();
        else if (id == R.id.btn_C)
            clearAll();
        else if (id == R.id.btn_CE)
            clearOperand();
        else if (id == R.id.btn_BS)
            removeDigit();
    }

    private void removeDigit() {
        if (state == 1) {
            op1 = op1 / 10;
            textResult.setText(String.valueOf(op1));
        } else {
            op2 = op2 / 10;
            textResult.setText(String.valueOf(op2));
        }
    }

    private void clearOperand() {
        if (state == 1) {
            op1 = 0;
            textResult.setText(String.valueOf(op1));
        } else {
            op2 = 0;
            textResult.setText(String.valueOf(op2));
        }
    }

    private void clearAll() {
        state = 1;
        op1 = op2 = 0;
        op = 0;
        textResult.setText(String.valueOf(op1));
    }

    private void reverse() {
        if (state == 1) {
            op1 = -op1;
            textResult.setText(String.valueOf(op1));
        } else {
            op2 = -op2;
            textResult.setText(String.valueOf(op2));
        }
    }

    private void calculateResult() {
        int result = 0;
        if (op == 1)
            result = op1 + op2;
        else if (op == 2)
            result = op1 - op2;
        if (op == 3)
            result = op1 * op2;
        if (op == 4) {
            if (op2 == 0) {
                textResult.setText("ERROR");
            }
            else
                result = op1 / op2;
        }
        if (!(op == 4 && op2 == 0))
            textResult.setText(String.valueOf(result));

        state = 1;
        op1 = op2 = 0;
        op = 0;
    }

    private void selectOperand(int operand) {
        state = 2;
        op = operand;
    }

    private void addDigit(int digit) {
        if (state == 1) {
            int sign = op1 < 0 ? -1 : 1;
            op1 = op1 * 10 + sign * digit;
            textResult.setText(String.valueOf(op1));
        } else {
            int sign = op1 < 0 ? -1 : 1;
            op2 = op2 * 10 + sign * digit;
            textResult.setText(String.valueOf(op2));
        }
    }
}
