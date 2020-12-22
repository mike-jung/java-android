package org.techtown.calculator;

public class MyCalculator extends CalculatorAdapter {

    public int add(int a, int b) {
        int result = a + b;
        addHistory(a, b, CalcData.TYPE_ADD, result);

        return result;
    }

}
