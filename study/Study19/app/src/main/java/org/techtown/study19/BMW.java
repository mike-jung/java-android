package org.techtown.study19;

import android.content.Context;
import android.widget.Toast;

public class BMW implements Car {
	Context context;
	
	public BMW(Context context) {
		this.context = context;
	}
	
	@Override
	public void doStart() {
		Toast.makeText(context, "BMW의 doStart 메서드가 호출되었습니다.", Toast.LENGTH_LONG).show();
	}

	@Override
	public void doRun() {
		Toast.makeText(context, "BMW의 doRun 메서드가 호출되었습니다.", Toast.LENGTH_LONG).show();
	}

	@Override
	public void doTurn() {
		Toast.makeText(context, "BMW의 doTurn 메서드가 호출되었습니다.", Toast.LENGTH_LONG).show();
	}

	@Override
	public void doStop() {
		Toast.makeText(context, "BMW의 doStop 메서드가 호출되었습니다.", Toast.LENGTH_LONG).show();
	}

}
