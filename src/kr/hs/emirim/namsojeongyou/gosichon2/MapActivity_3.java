package kr.hs.emirim.namsojeongyou.gosichon2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class MapActivity_3 extends Activity implements OnClickListener,
		OnLongClickListener {
	// 가게
	ImageView chamjjajang, backgajib;
	// 말풍선
	ImageView chamjjajang_mal, backgajib_mal;
	// Visibility 보여지는지 안보여지는지 보기 위해서 사용하는 변수.
	boolean show1 = false, show2 = false;

	private CustomDialog mCustomDialog;
	int selectId;// id값 얻기 위해서;

	String store_name[] = { "참짜장 기계우동", "백가집"};
	int i;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map3);

		SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);

		// 가게
		chamjjajang = (ImageView) findViewById(R.id.store_chamjjajang);
		backgajib = (ImageView) findViewById(R.id.store_backgajib);

		// 말풍선
		 chamjjajang_mal = (ImageView)
		 findViewById(R.id.store_chamjjajang_mal);
		 backgajib_mal = (ImageView) findViewById(R.id.store_backgajib_mal);

		chamjjajang.setOnLongClickListener(this);
		backgajib.setOnLongClickListener(this);
		
	}// onCreate

	// 왼쪽 버튼 (확인)
	private View.OnClickListener leftClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {

			switch (selectId) {
			case R.id.store_chamjjajang:
				savePreferences("chamjjajang", true);
				break;
			case R.id.store_backgajib:
				savePreferences("back", true);
			}

			Toast.makeText(getApplicationContext(), "도장찍기 완료!",
					Toast.LENGTH_SHORT).show();
			mCustomDialog.dismiss();
		}
	};

	// 오른쪽 버튼 (취소)
	private View.OnClickListener rightClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			Toast.makeText(getApplicationContext(), "취소되었습니다.",
					Toast.LENGTH_SHORT).show();
			mCustomDialog.cancel();

		}
	};

	// 값 저장하기
	private void savePreferences(String key, boolean value) {
		SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
		SharedPreferences.Editor edit = pref.edit();
		edit.putBoolean(key, value);
		edit.commit();
	}

	@Override
	protected void onResume() {
		//가게
		chamjjajang.setOnClickListener(this);
		backgajib.setOnClickListener(this);
		//말풍선
		chamjjajang_mal.setOnClickListener(this);
		backgajib_mal.setOnClickListener(this);
		super.onResume();
	}

	@Override
	public void onClick(View v) {
		selectId = v.getId();// id값을 얻어와야 한다. (왼쪽 확인버튼과 관련)
		//가게관련
		switch (v.getId()) {
		case R.id.store_chamjjajang:
			Toast.makeText(MapActivity_3.this, "참짜장 기계우동", Toast.LENGTH_SHORT)
					.show();
			if (show1 == false) {
				chamjjajang_mal.setVisibility(View.VISIBLE); // 화면에보임
				show1 = true;
			} else if (show1 == true) {
				chamjjajang_mal.setVisibility(View.INVISIBLE);// 화면에 안보임.
				show1 = false;
			}
			break;
		case R.id.store_backgajib:
			Toast.makeText(MapActivity_3.this, "백가집", Toast.LENGTH_SHORT)
					.show();
			if (show2 == false) {
				backgajib_mal.setVisibility(View.VISIBLE); // 화면에보임
				show2 = true;
			} else if (show2 == true) {
				backgajib_mal.setVisibility(View.INVISIBLE);// 화면에 안보임.
				show2 = false;
			}
			break;
		}
		//말풍선관련
		switch (v.getId()) {
		case R.id.store_chamjjajang_mal:
			Intent intent1 = new Intent(MapActivity_3.this, StoreActivity.class);
			intent1.putExtra("position", 7);
			startActivity(intent1);
			break;
		case R.id.store_backgajib_mal:
			Intent intent2 = new Intent(MapActivity_3.this, StoreActivity.class);
			intent2.putExtra("position", 2);
			startActivity(intent2);
			break;
		}

	}

	@Override
	public boolean onLongClick(View v) {
		selectId = v.getId();//id값을 얻어와야 한다. (왼쪽 확인버튼과 관련)
		switch (v.getId()) {
		case R.id.store_chamjjajang:i = 0;break;
		case R.id.store_backgajib:i = 1;break;
		}
		mCustomDialog = new CustomDialog(MapActivity_3.this, store_name[i]
				+ "\n" + "도장을 찍으시겠습니까?", " ", leftClickListener,
				rightClickListener);
		mCustomDialog.show();
		// 다음 이벤트 계속 진행 false, 이벤트 완료 true
		return false;
	}
}