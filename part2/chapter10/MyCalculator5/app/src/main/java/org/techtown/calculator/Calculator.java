package org.techtown.calculator;

import java.util.ArrayList;

public interface Calculator {

    public void addHistory(int a, int b, int type, int result);

    public void clearHistory();

    public ArrayList<CalcData> getHistory();


    public int add(int a, int b);

    public int subtract(int a, int b) throws UnImplementedException;

    public int multiply(int a, int b) throws UnImplementedException;

    public int divide(int a, int b) throws UnImplementedException;

}
