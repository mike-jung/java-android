package org.techtown.study20;

import android.content.Context;
import android.widget.Toast;

public class Benz extends CarPrototype {

	public Benz(Context context) {
		super(context);
	}

	@Override
	public void doRun() {
		Toast.makeText(context, "Benz의 doRun 메서드가 호출되었습니다.", Toast.LENGTH_LONG).show();
	}

}
