package kr.hs.emirim.namsojeongyou.gosichon2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

public class Imagemain extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_main);
		Intent intent = getIntent();
		int position = intent.getIntExtra("position", 0);
		int position2 = intent.getIntExtra("position2", 0);

		ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
		ImageAdapter adapter = new ImageAdapter(this, position);
		viewPager.setAdapter(adapter);
		viewPager.setCurrentItem(position2);
		
	}

}