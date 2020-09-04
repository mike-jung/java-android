package org.techtown.study19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout1;

    ArrayList<Car> cars = new ArrayList<Car>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout1 = findViewById(R.id.layout1);

    }

    public void onButton1Clicked(View v) {
        Benz benz = new Benz(this);
        cars.add(benz);

        Toast.makeText(getApplicationContext(), "Benz 구매함.", Toast.LENGTH_LONG).show();

        addToLayout();
    }

    public void onButton2Clicked(View v) {
        BMW bmw = new BMW(this);
        cars.add(bmw);

        Toast.makeText(getApplicationContext(), "BMW 구매함.", Toast.LENGTH_LONG).show();

        addToLayout();
    }

    private void addToLayout() {
        Button button = new Button(this);
        button.setTag((cars.size()-1));
        button.setText("Car " + cars.size());
        button.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 50);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Button curButton = (Button) v;
                int index = ((Integer) curButton.getTag()).intValue();
                Car curCar = cars.get(index);

                if (curCar instanceof Benz) {
                    Toast.makeText(getApplicationContext(), "지금 선택하신 차는 Benz 차종입니다.", Toast.LENGTH_LONG).show();
                } else if (curCar instanceof BMW) {
                    Toast.makeText(getApplicationContext(), "지금 선택하신 차는 BMW 차종입니다.", Toast.LENGTH_LONG).show();
                }
            }

        });

        layout1.addView(button);
    }

}