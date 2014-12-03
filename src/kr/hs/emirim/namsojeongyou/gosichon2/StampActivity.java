package kr.hs.emirim.namsojeongyou.gosichon2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ToggleButton;

public class StampActivity extends Activity {

	final static String TAG = "어서오세요 고시촌!::StampActivity";

	@Override
	protected void onResume() {
		boolean soondae = getPreferences("soondae");// 개경순대국
		boolean momoami = getPreferences("momoami");// 모모야미
		boolean back = getPreferences("back");// 백가집
		boolean bonggusu = getPreferences("bonggusu");// 봉구스밥버거
		boolean ssagun = getPreferences("ssagun");// 싸군
		boolean amasbin = getPreferences("amasbin");// 아마스빈
		boolean yejjajang = getPreferences("yejjajang");// 예짜장
		boolean chamjjajang = getPreferences("chamjjajang");// 참짜장
		boolean tomato = getPreferences("tomato");// 토마토김밥
		boolean pigmalion = getPreferences("pigmalion");// 피그말리온
		boolean alchon = getPreferences("alchon");// 알촌
		boolean babaffle = getPreferences("babaffle");// babaffle
		boolean bubblytea = getPreferences("bubblytea");// bubblytea
		boolean cafelavingne = getPreferences("cafelavingne");// cafelavingne
		boolean thebasak = getPreferences("thebasak");// the 바삭바삭
		boolean thebcup = getPreferences("thebcup");// the b컵닭

		// 스마일 토글버튼 (방문했으면 웃고 안했으면 찡그림)

		// 개경순대국
		final ToggleButton stamp_soondae = (ToggleButton) findViewById(R.id.stamp_soondae);
		if (soondae == true) {
			stamp_soondae.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit));
		} else if (soondae == false) {
			stamp_soondae.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit_no));
		}

		// 모모야미
		final ToggleButton stamp_momoami = (ToggleButton) findViewById(R.id.stamp_momoami);
		if (momoami == true) {
			stamp_momoami.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit));
		} else if (momoami == false) {
			stamp_momoami.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit_no));
		}

		// 백가집
		final ToggleButton stamp_back = (ToggleButton) findViewById(R.id.stamp_back);
		if (back == true) {
			stamp_back.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit));
		} else if (back == false) {
			stamp_back.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit_no));
		}

		// 봉구스 밥버거
		final ToggleButton stamp_bonggusu = (ToggleButton) findViewById(R.id.stamp_bonggusu);
		if (bonggusu == true) {
			stamp_bonggusu.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit));
		} else if (bonggusu == false) {
			stamp_bonggusu.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit_no));
		}

		// 싸군
		final ToggleButton stamp_ssagun = (ToggleButton) findViewById(R.id.stamp_ssagun);
		if (ssagun == true) {
			stamp_ssagun.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit));
		} else if (ssagun == false) {
			stamp_ssagun.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit_no));
		}

		// 아마스빈
		final ToggleButton stamp_amasbin = (ToggleButton) findViewById(R.id.stamp_amasbin);
		if (amasbin == true) {
			stamp_amasbin.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit));
		} else if (amasbin == false) {
			stamp_amasbin.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit_no));
		}

		// 예짜장면
		final ToggleButton stamp_yejjajang = (ToggleButton) findViewById(R.id.stamp_yejjajang);
		if (yejjajang == true) {
			stamp_yejjajang.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit));
		} else if (yejjajang == false) {
			stamp_yejjajang.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit_no));
		}

		// 참짜장
		final ToggleButton stamp_chamjjajang = (ToggleButton) findViewById(R.id.stamp_chamjjajang);
		if (chamjjajang == true) {
			stamp_chamjjajang.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit));
		} else if (chamjjajang == false) {
			stamp_chamjjajang.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit_no));
		}

		// 토마토김밥
		final ToggleButton stamp_tomato = (ToggleButton) findViewById(R.id.stamp_tomato);
		if (tomato == true) {
			stamp_tomato.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit));
		} else if (tomato == false) {
			stamp_tomato.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit_no));
		}

		// 피그말리온
		final ToggleButton stamp_pigmalion = (ToggleButton) findViewById(R.id.stamp_pigmalion);
		if (pigmalion == true) {
			stamp_pigmalion.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit));
		} else if (pigmalion == false) {
			stamp_pigmalion.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit_no));
		}

		// Alchon (알촌)
		final ToggleButton stamp_alchon = (ToggleButton) findViewById(R.id.stamp_alchon);
		if (alchon == true) {
			stamp_alchon.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit));
		} else if (alchon == false) {
			stamp_alchon.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit_no));
		}

		// Babaffle
		final ToggleButton stamp_babaffle = (ToggleButton) findViewById(R.id.stamp_babaffle);
		if (babaffle == true) {
			stamp_babaffle.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit));
		} else if (babaffle == false) {
			stamp_babaffle.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit_no));
		}

		// Bubbly tea
		final ToggleButton stamp_bubblytea = (ToggleButton) findViewById(R.id.stamp_bubblytea);
		if (bubblytea == true) {
			stamp_bubblytea.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit));
		} else if (bubblytea == false) {
			stamp_bubblytea.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit_no));
		}

		// cafe' Lavingne
		final ToggleButton stamp_cafelavingne = (ToggleButton) findViewById(R.id.stamp_cafelavingne);
		if (cafelavingne == true) {
			stamp_cafelavingne.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.toggle_visit));
		} else if (soondae == false) {
			stamp_cafelavingne.setBackgroundDrawable(getResources()
					.getDrawable(R.drawable.toggle_visit_no));
		}

		// The 바삭바삭
		final ToggleButton stamp_thebasak = (ToggleButton) findViewById(R.id.stamp_thebasak);
		if (thebasak == true) {
			stamp_thebasak.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit));
		} else if (thebasak == false) {
			stamp_thebasak.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit_no));
		}

		// The B컵닭
		final ToggleButton stamp_thebcup = (ToggleButton) findViewById(R.id.stamp_thebcup);
		if (thebcup == true) {
			stamp_thebcup.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit));
		} else if (thebcup == false) {
			stamp_thebcup.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.toggle_visit_no));
		}
		super.onResume();
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stamp);

	}// onCreate

	// 값 불러오기
	private boolean getPreferences(String key) {
		SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
		return pref.getBoolean(key, false);
	}
}