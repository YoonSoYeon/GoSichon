package kr.hs.emirim.namsojeongyou.gosichon2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MapActivity extends Activity implements OnClickListener {

	ImageView map_1, map_2, map_3, map_4;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);

	

		map_1 = (ImageView) findViewById(R.id.map_1);
		map_2 = (ImageView) findViewById(R.id.map_2);
		map_3 = (ImageView) findViewById(R.id.map_3);
		map_4 = (ImageView) findViewById(R.id.map_4);

		map_1.setOnClickListener(this);
		map_2.setOnClickListener(this);
		map_3.setOnClickListener(this);
		map_4.setOnClickListener(this);
	}// onCreate

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.map_1:
			intent=new Intent(this,MapActivity_1.class);
			startActivity(intent);
			break;
		case R.id.map_2:
			intent=new Intent(this,MapActivity_2.class);
			startActivity(intent);
			break;
		case R.id.map_3:
			intent=new Intent(this,MapActivity_3.class);
			startActivity(intent);
			break;
		case R.id.map_4:
			intent=new Intent(this,MapActivity_4.class);
			startActivity(intent);
			break;

		}

	}

}