package org.techtown.study20;

import android.content.Context;
import android.widget.Toast;

public class BMW extends CarPrototype {

	public BMW(Context context) {
		super(context);
	}

	@Override
	public void doRun() {
		Toast.makeText(context, "BMW의 doRun 메서드가 호출되었습니다.", Toast.LENGTH_LONG).show();
	}

}

