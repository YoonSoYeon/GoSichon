package kr.hs.emirim.namsojeongyou.gosichon2;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivith extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		Handler handler = new Handler(){
			public void handleMessage(android.os.Message msg) {
				finish();
			}
		};
		
		handler.sendEmptyMessageDelayed(0, 3000);
	}//onCreate
}
