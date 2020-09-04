package org.techtown.study20;

import java.util.ArrayList;

import android.content.Context;
import android.widget.Toast;

public abstract class CarPrototype implements Car {
	Context context;

	int price;

	public static ArrayList<Car> cars = new ArrayList<Car>();

	public CarPrototype(Context context) {
		this.context = context;
	}

	@Override
	public void doStart() {
		Toast.makeText(context, "CarPrototype의 doStart 메서드가 호출되었습니다.", Toast.LENGTH_LONG).show();
	}

	@Override
	public abstract void doRun();

	@Override
	public void doTurn() {
		Toast.makeText(context, "CarPrototype의 doTurn 메서드가 호출되었습니다.", Toast.LENGTH_LONG).show();
	}

	@Override
	public void doStop() {
		Toast.makeText(context, "CarPrototype의 doStop 메서드가 호출되었습니다.", Toast.LENGTH_LONG).show();
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
