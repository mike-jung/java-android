package org.techtown.calculator;

import android.content.Context;
import android.widget.Toast;

public class Calculator {
    Context context;

    public Calculator(Context context) {
        this.context = context;
    }

    public int add(int a, int b) {
        Toast.makeText(context, "더하기를 했습니다.", Toast.LENGTH_LONG).show();
        return a + b;
    }

}
