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

public class MapActivity_1 extends Activity implements OnClickListener, OnLongClickListener {
	// 가게
	ImageView alchon, babaffle;
	// 말풍선
	ImageView alchon_mal, babaffle_mal;
	// Visibility 보여지는지 안보여지는지 보기 위해서 사용하는 변수.
	boolean show1=false, show2=false;
	
	private CustomDialog mCustomDialog;
	int selectId;// id값 얻기 위해서
	
	String store_name[]={"Alchon","Babaffle"};
	int i;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map1);

		SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
		// 가게
		alchon = (ImageView) findViewById(R.id.store_alchon);
		babaffle = (ImageView) findViewById(R.id.store_babaffle);

		// 말풍선
		alchon_mal = (ImageView) findViewById(R.id.store_alchon_mal);
		babaffle_mal = (ImageView) findViewById(R.id.store_babaffle_mal);

		alchon.setOnLongClickListener(this);// 알촌선택
		babaffle.setOnLongClickListener(this);// babaffle선택

	}// onCreate

	// 왼쪽 버튼 (확인)
	private View.OnClickListener leftClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (selectId) { //(Preferences 이용) 
			case R.id.store_alchon:
				savePreferences("alchon", true);
				break;
			case R.id.store_babaffle:
				savePreferences("babaffle", true);
				break;
			}
			Toast.makeText(getApplicationContext(), "도장찍기 완료!",
					Toast.LENGTH_SHORT).show();
			mCustomDialog.dismiss();
//			Intent intent = new Intent(MapActivity_1.this, StampActivity.class);
//			startActivity(intent);	
			
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

	// 값 저장하기 (Preferences 이용)
	private void savePreferences(String key, boolean value) {
		SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
		SharedPreferences.Editor edit = pref.edit();
		edit.putBoolean(key, value);
		edit.commit();
	}

	@Override
	protected void onResume() {//새로고침 같은 코드.
		//가게
		alchon.setOnClickListener(this);
		babaffle.setOnClickListener(this);
		//말풍선
		alchon_mal.setOnClickListener(this);
		babaffle_mal.setOnClickListener(this);
		super.onResume();
	}

	@Override
	public void onClick(View v) {//클릭 되었을 때
		selectId = v.getId();//id값을 얻어와야 한다. (왼쪽 확인버튼과 관련)
		//아이콘관련 switch
		switch (selectId) {
		case R.id.store_babaffle:
			Toast.makeText(MapActivity_1.this, "Babaffle", Toast.LENGTH_SHORT)
					.show();
			if (show1 == false) {//화면에 나타나지 않으면
				babaffle_mal.setVisibility(View.VISIBLE); // babaffle을 화면에 보임
				show1 = true;
			} else if (show1 == true) {
				babaffle_mal.setVisibility(View.INVISIBLE);// 화면에 안보임.
				show1 = false;
			}
			break;
		case R.id.store_alchon:
			Toast.makeText(MapActivity_1.this, "알촌", Toast.LENGTH_SHORT).show();
			if (show2 == false) {
				alchon_mal.setVisibility(View.VISIBLE); // 화면에보임
				show2 = true;
			} else if (show2 == true) {
				alchon_mal.setVisibility(View.INVISIBLE);// 화면에 안보임.
				show2 = false;
			}
			break;
		}
		//말풍선 관련
		switch (v.getId()) {
		case R.id.store_alchon_mal:
			Intent intent1 = new Intent(MapActivity_1.this, StoreActivity.class);
			intent1.putExtra("position", 10);
			startActivity(intent1);
			break;
		case R.id.store_babaffle_mal:
			Intent intent2 = new Intent(MapActivity_1.this, StoreActivity.class);
			intent2.putExtra("position", 11);
			startActivity(intent2);
			break;
		}
	}

	@Override
	public boolean onLongClick(View v) {
		selectId = v.getId();//id값을 얻어와야 한다. (왼쪽 확인버튼과 관련)
		switch (v.getId()) {
		case R.id.store_alchon: i=0;
			break;
		case R.id.store_babaffle: i=1;
			break;
		}
		mCustomDialog = new CustomDialog(MapActivity_1.this, store_name[i]+"\n"+"도장을 찍으시겠습니까?",
				" ", leftClickListener, rightClickListener);
		mCustomDialog.show();
		// 다음 이벤트 계속 진행 false, 이벤트 완료 true
		return false;
	}

}