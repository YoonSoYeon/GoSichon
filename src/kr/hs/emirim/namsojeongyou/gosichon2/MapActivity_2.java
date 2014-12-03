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

public class MapActivity_2 extends Activity implements OnClickListener,
		OnLongClickListener {
	// 가게
	ImageView bonggusu, cafelavingne, bubblytea, thebcup, soondae;
	// 말풍선
	ImageView bonggusu_mal, cafelavingne_mal, bubblytea_mal, thebcup_mal,
			soondae_mal;

	// Visibility 보여지는지 안보여지는지 보기 위해서 사용하는 변수.
	boolean show1 = false, show2 = false, show3 = false, show4 = false,
			show5 = false;

	private CustomDialog mCustomDialog;
	int selectId;// id값 얻기 위해서

	String store_name[] = { "봉구스밥버거", "cafe' Lavingne", "Bubbly tea",
			"The B컵닭", "개경순대국" };
	int i;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map2);
		SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);

		// 가게
		bonggusu = (ImageView) findViewById(R.id.store_bonggusu);
		cafelavingne = (ImageView) findViewById(R.id.store_cafelavingne);
		bubblytea = (ImageView) findViewById(R.id.store_bubblytea);
		thebcup = (ImageView) findViewById(R.id.store_thebcup);
		soondae = (ImageView) findViewById(R.id.store_soondae);

		// 말풍선
		bonggusu_mal = (ImageView) findViewById(R.id.store_bongusu_mal);
		cafelavingne_mal = (ImageView) findViewById(R.id.store_cafelavingne_mal);
		bubblytea_mal = (ImageView) findViewById(R.id.store_bubblytea_mal);
		thebcup_mal = (ImageView) findViewById(R.id.store_thebcup_mal);
		soondae_mal = (ImageView) findViewById(R.id.store_soondae_mal);

		// 봉구스 밥버거
		bonggusu.setOnLongClickListener(this);
		cafelavingne.setOnLongClickListener(this);
		bubblytea.setOnLongClickListener(this);
		thebcup.setOnLongClickListener(this);
		soondae.setOnLongClickListener(this);

	}// onCreate

	// 왼쪽 버튼 (확인)
	private View.OnClickListener leftClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (selectId) {
			case R.id.store_bonggusu:
				savePreferences("bonggusu", true);
				break;
			case R.id.store_cafelavingne:
				savePreferences("cafelavingne", true);
				break;
			case R.id.store_bubblytea:
				savePreferences("bubblytea", true);
				break;
			case R.id.store_thebcup:
				savePreferences("thebcup", true);
				break;
			case R.id.store_soondae:
				savePreferences("soondae", true);
				break;

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
		bonggusu.setOnClickListener(this);
		cafelavingne.setOnClickListener(this);
		bubblytea.setOnClickListener(this);
		thebcup.setOnClickListener(this);
		soondae.setOnClickListener(this);
		//말풍선
		bonggusu_mal.setOnClickListener(this);
		cafelavingne_mal.setOnClickListener(this);
		bubblytea_mal.setOnClickListener(this);
		thebcup_mal.setOnClickListener(this);
		soondae_mal.setOnClickListener(this);
		super.onResume();
	}

	@Override
	public void onClick(View v) {
		selectId = v.getId();// id값을 얻어와야 한다. (왼쪽 확인버튼과 관련)
		//가게 관련
		switch (v.getId()) {
		case R.id.store_bonggusu:
			Toast.makeText(MapActivity_2.this, "봉구스밥버거", Toast.LENGTH_SHORT)
					.show();
			if (show1 == false) {
				bonggusu_mal.setVisibility(View.VISIBLE); // 화면에보임
				show1 = true;
			} else if (show1 == true) {
				bonggusu_mal.setVisibility(View.INVISIBLE);// 화면에 안보임.
				show1 = false;
			}
			break;
		case R.id.store_cafelavingne:
			Toast.makeText(MapActivity_2.this, "cafe' Lagingne",
					Toast.LENGTH_SHORT).show();
			if (show2 == false) {
				cafelavingne_mal.setVisibility(View.VISIBLE); // 화면에보임
				show2 = true;
			} else if (show2 == true) {
				cafelavingne_mal.setVisibility(View.INVISIBLE);// 화면에 안보임.
				show2 = false;
			}
			break;
		case R.id.store_bubblytea:
			Toast.makeText(MapActivity_2.this, "Bubbly tea", Toast.LENGTH_SHORT)
					.show();
			if (show3 == false) {
				bubblytea_mal.setVisibility(View.VISIBLE); // 화면에보임
				show3 = true;
			} else if (show3 == true) {
				bubblytea_mal.setVisibility(View.INVISIBLE);// 화면에 안보임.
				show3 = false;
			}
			break;
		case R.id.store_thebcup:
			Toast.makeText(MapActivity_2.this, "The B컵닭", Toast.LENGTH_SHORT)
					.show();
			if (show4 == false) {
				thebcup_mal.setVisibility(View.VISIBLE); // 화면에보임
				show4 = true;
			} else if (show4 == true) {
				thebcup_mal.setVisibility(View.INVISIBLE);// 화면에 안보임.
				show4 = false;
			}
			break;
		case R.id.store_soondae:
			Toast.makeText(MapActivity_2.this, "계경순대국", Toast.LENGTH_SHORT)
					.show();
			if (show5 == false) {
				soondae_mal.setVisibility(View.VISIBLE); // 화면에보임
				show5 = true;
			} else if (show5 == true) {
				soondae_mal.setVisibility(View.INVISIBLE);// 화면에 안보임.
				show5 = false;
			}
			break;
		}
		//말풍선 관련
		switch (v.getId()) {
		case R.id.store_bongusu_mal:
			Intent intent1 = new Intent(MapActivity_2.this, StoreActivity.class);
			intent1.putExtra("position", 3);
			startActivity(intent1);
			break;
		case R.id.store_cafelavingne_mal:
			Intent intent2 = new Intent(MapActivity_2.this, StoreActivity.class);
			intent2.putExtra("position", 13);
			startActivity(intent2);
			break;
		case R.id.store_thebcup_mal:
			Intent intent3 = new Intent(MapActivity_2.this, StoreActivity.class);
			intent3.putExtra("position", 15);
			startActivity(intent3);
			break;
		case R.id.store_bubblytea_mal:
			Intent intent4 = new Intent(MapActivity_2.this, StoreActivity.class);
			intent4.putExtra("position", 12);
			startActivity(intent4);
			break;
		case R.id.store_soondae_mal:
			Intent intent5 = new Intent(MapActivity_2.this, StoreActivity.class);
			intent5.putExtra("position", 0);
			startActivity(intent5);
			break;
		}
	}

	@Override
	public boolean onLongClick(View v) {
		selectId = v.getId();//id값을 얻어와야 한다. (왼쪽 확인버튼과 관련)
		switch (v.getId()) {
		case R.id.store_bonggusu:i = 0;break;
		case R.id.store_cafelavingne:i = 1;break;
		case R.id.store_bubblytea:i = 2;break;
		case R.id.store_thebcup:i = 3;break;
		case R.id.store_soondae: i = 4;break;

		}
		mCustomDialog = new CustomDialog(MapActivity_2.this, store_name[i]
				+ "\n" + "도장을 찍으시겠습니까?", " ", leftClickListener,
				rightClickListener);
		mCustomDialog.show();
		// 다음 이벤트 계속 진행 false, 이벤트 완료 true
		return false;
	}

}