package kr.hs.emirim.namsojeongyou.gosichon2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class MapActivity_4 extends Activity implements OnClickListener,
		OnLongClickListener {
	// 가게
	ImageView tomato, pigmalion, yejjajang, ssagun, basakbasak, amasbin,
			momoyami;
	// 말풍선
	ImageView tomato_mal, pigmalion_mal, yejjajang_mal, ssagun_mal,
			basakbasak_mal, amasbin_mal, momoyami_mal;

	// Visibility 보여지는지 안보여지는지 보기 위해서 사용하는 변수.
	boolean show1 = false, show2 = false, show3 = false, show4 = false,
			show5 = false, show6 = false, show7 = false;

	private CustomDialog mCustomDialog;
	int selectId;// id값 얻기 위해서

	String store_name[] = { "토마토 김밥", "피그말리온", "예 짜장면",
			"싸군", "The 바삭바삭", "아마스빈", "모모야미(33)" };
	int i;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map4);

		SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);

		// 가게
		tomato = (ImageView) findViewById(R.id.store_tomato);
		pigmalion = (ImageView) findViewById(R.id.store_pigmalion);
		yejjajang = (ImageView) findViewById(R.id.store_yejjajang);
		ssagun = (ImageView) findViewById(R.id.store_ssagun);
		basakbasak = (ImageView) findViewById(R.id.store_basakbasak);
		amasbin = (ImageView) findViewById(R.id.store_amasbin);
		momoyami = (ImageView) findViewById(R.id.store_momoyami);

		// 말풍선
		tomato_mal = (ImageView) findViewById(R.id.store_tomato_mal);
		pigmalion_mal = (ImageView) findViewById(R.id.store_pigmalion_mal);
		yejjajang_mal = (ImageView) findViewById(R.id.store_yejjajang_mal);
		ssagun_mal = (ImageView) findViewById(R.id.store_ssagun_mal);
		basakbasak_mal = (ImageView) findViewById(R.id.store_basakbasak_mal);
		amasbin_mal = (ImageView) findViewById(R.id.store_amasbin_mal);
		momoyami_mal = (ImageView) findViewById(R.id.store_momoyami_mal);

		tomato.setOnLongClickListener(this);
		pigmalion.setOnLongClickListener(this);
		yejjajang.setOnLongClickListener(this);
		ssagun.setOnLongClickListener(this);
		basakbasak.setOnLongClickListener(this);
		amasbin.setOnLongClickListener(this);
		momoyami.setOnLongClickListener(this);

	}// onCreate

	// 왼쪽 버튼 (확인)
	private View.OnClickListener leftClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (selectId) {
			case R.id.store_tomato:
				savePreferences("tomato", true);
				break;
			case R.id.store_pigmalion:
				savePreferences("pigmalion", true);
				break;
			case R.id.store_yejjajang:
				savePreferences("yejjajang", true);
				break;
			case R.id.store_ssagun:
				savePreferences("ssagun", true);
				break;
			case R.id.store_basakbasak:
				savePreferences("thebasak", true);
				break;
			case R.id.store_amasbin:
				savePreferences("amasbin", true);
				break;
			case R.id.store_momoyami:
				savePreferences("momoami", true);
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
	protected void onResume() {// 새로고침 같은 코드.
		//가게
		tomato.setOnClickListener(this);
		pigmalion.setOnClickListener(this);
		yejjajang.setOnClickListener(this);
		ssagun.setOnClickListener(this);
		basakbasak.setOnClickListener(this);
		amasbin.setOnClickListener(this);
		momoyami.setOnClickListener(this);
		//말풍선
		tomato_mal.setOnClickListener(this);
		pigmalion_mal.setOnClickListener(this);
		yejjajang_mal.setOnClickListener(this);
		ssagun_mal.setOnClickListener(this);
		basakbasak_mal.setOnClickListener(this);
		amasbin_mal.setOnClickListener(this);
		momoyami_mal.setOnClickListener(this);		
		super.onResume();
	}

	@Override
	public void onClick(View v) {// 클릭 되었을 때
		selectId = v.getId();// id값을 얻어와야 한다. (왼쪽 확인버튼과 관련)
		//가게
		switch (v.getId()) {
		case R.id.store_tomato:
			Toast.makeText(MapActivity_4.this, "토마토김밥", Toast.LENGTH_SHORT)
					.show();
			if (show1 == false) {
				tomato_mal.setVisibility(View.VISIBLE); // 화면에보임
				show1 = true;
			} else if (show1 == true) {
				tomato_mal.setVisibility(View.INVISIBLE);// 화면에 안보임.
				show1 = false;
			}
			break;
		case R.id.store_pigmalion:
			Toast.makeText(MapActivity_4.this, "피그말리온", Toast.LENGTH_SHORT)
					.show();
			if (show2 == false) {
				pigmalion_mal.setVisibility(View.VISIBLE); // 화면에보임
				show2 = true;
			} else if (show2 == true) {
				pigmalion_mal.setVisibility(View.INVISIBLE);// 화면에 안보임.
				show2 = false;
			}
			break;
		case R.id.store_yejjajang:
			Toast.makeText(MapActivity_4.this, "예짜장면", Toast.LENGTH_SHORT)
					.show();
			if (show3 == false) {
				yejjajang_mal.setVisibility(View.VISIBLE); // 화면에보임
				show3 = true;
			} else if (show3 == true) {
				yejjajang_mal.setVisibility(View.INVISIBLE);// 화면에 안보임.
				show3 = false;
			}
			break;
		case R.id.store_ssagun:
			Toast.makeText(MapActivity_4.this, "싸군", Toast.LENGTH_SHORT).show();
			if (show4 == false) {
				ssagun_mal.setVisibility(View.VISIBLE); // 화면에보임
				show4 = true;
			} else if (show4 == true) {
				ssagun_mal.setVisibility(View.INVISIBLE);// 화면에 안보임.
				show4 = false;
			}
			break;
		case R.id.store_basakbasak:
			Toast.makeText(MapActivity_4.this, "The 바삭바삭", Toast.LENGTH_SHORT)
					.show();
			if (show5 == false) {
				basakbasak_mal.setVisibility(View.VISIBLE); // 화면에보임
				show5 = true;
			} else if (show5 == true) {
				basakbasak_mal.setVisibility(View.INVISIBLE);// 화면에 안보임.
				show5 = false;
			}
			break;
		case R.id.store_amasbin:
			Toast.makeText(MapActivity_4.this, "아마스빈", Toast.LENGTH_SHORT)
					.show();
			if (show6 == false) {
				amasbin_mal.setVisibility(View.VISIBLE); // 화면에보임
				show6 = true;
			} else if (show6 == true) {
				amasbin_mal.setVisibility(View.INVISIBLE);// 화면에 안보임.
				show6 = false;
			}
			break;
		case R.id.store_momoyami:
			Toast.makeText(MapActivity_4.this, "모모야미(33)", Toast.LENGTH_SHORT)
					.show();
			if (show7 == false) {
				momoyami_mal.setVisibility(View.VISIBLE); // 화면에보임
				show7 = true;
			} else if (show7 == true) {
				momoyami_mal.setVisibility(View.INVISIBLE);// 화면에 안보임.
				show7 = false;
			}
			break;
		}
		//말풍선
		switch (v.getId()) {
		case R.id.store_tomato_mal:
			Intent intent1 = new Intent(MapActivity_4.this, StoreActivity.class);
			intent1.putExtra("position", 8);
			startActivity(intent1);
			break;
		case R.id.store_pigmalion_mal:
			Intent intent2 = new Intent(MapActivity_4.this, StoreActivity.class);
			intent2.putExtra("position", 9);
			startActivity(intent2);
			break;
		case R.id.store_yejjajang_mal:
			Intent intent3 = new Intent(MapActivity_4.this, StoreActivity.class);
			intent3.putExtra("position", 6);
			startActivity(intent3);
			break;
		case R.id.store_ssagun_mal:
			Intent intent4 = new Intent(MapActivity_4.this, StoreActivity.class);
			intent4.putExtra("position", 4);
			startActivity(intent4);
			break;
		case R.id.store_basakbasak_mal:	
			Intent intent5 = new Intent(MapActivity_4.this, StoreActivity.class);
			intent5.putExtra("position", 14);
			startActivity(intent5);
			break;
		case R.id.store_amasbin_mal:
			Intent intent6 = new Intent(MapActivity_4.this, StoreActivity.class);
			intent6.putExtra("position", 5);
			startActivity(intent6);
			break;
		case R.id.store_momoyami_mal:	
			Intent intent7 = new Intent(MapActivity_4.this, StoreActivity.class);
			intent7.putExtra("position", 1);
			startActivity(intent7);
			break;
		}

	}

	@Override
	public boolean onLongClick(View v) {
		selectId = v.getId();//id값을 얻어와야 한다. (왼쪽 확인버튼과 관련)
		switch (v.getId()) {
		case R.id.store_tomato:i = 0;break;
		case R.id.store_pigmalion:i = 1;break;
		case R.id.store_yejjajang:i = 2;break;
		case R.id.store_ssagun:i = 3;break;
		case R.id.store_basakbasak:i = 4;break;
		case R.id.store_amasbin:i = 5;break;
		case R.id.store_momoyami:i = 6;break;
		}
		mCustomDialog = new CustomDialog(MapActivity_4.this, store_name[i]
				+ "\n" + "도장을 찍으시겠습니까?", " ", leftClickListener,
				rightClickListener);
		mCustomDialog.show();
		// 다음 이벤트 계속 진행 false, 이벤트 완료 true
		return false;
	}

}