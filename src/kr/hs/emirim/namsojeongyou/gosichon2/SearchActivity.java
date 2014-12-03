//검색화면
package kr.hs.emirim.namsojeongyou.gosichon2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.test.MoreAsserts;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ToggleButton;

public class SearchActivity extends Activity {
	Button button_search;
	String searchword;
	String searchword1;
	String searchword2;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);

		// 아침 토글버튼
		final ToggleButton afternoon = (ToggleButton) findViewById(R.id.afternoon);
		final ToggleButton morning = (ToggleButton) findViewById(R.id.morning);
		final ToggleButton evening = (ToggleButton) findViewById(R.id.evening);
		morning.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (morning.isChecked() == true) {
					toogleMorning(true);

					afternoon.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.time_afternoon));
					afternoon.setChecked(false);
					evening.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.time_evening));
					evening.setChecked(false);
				} else {
					toogleMorning(false);
				}

			}
		});

		// 점심 토글버튼

		afternoon.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (afternoon.isChecked() == true) {
					afternoon.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.time_afternoon_s));

					morning.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.time_morning));
					morning.setChecked(false);
					evening.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.time_evening));
					evening.setChecked(false);
				} else {
					afternoon.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.time_afternoon));
					afternoon.setChecked(false);
				}
			}
		});
		// 저녁토글버튼

		evening.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (evening.isChecked() == true) {
					evening.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.time_evening_s));
					// evening.setChecked(false);
					morning.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.time_morning));
					morning.setChecked(false);
					afternoon.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.time_afternoon));
					afternoon.setChecked(false);
				} else {
					evening.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.time_evening));
					evening.setChecked(false);
				}
			}
		});

		// 음식종류
		final ToggleButton koreafood = (ToggleButton) findViewById(R.id.korea);
		final ToggleButton chinafood = (ToggleButton) findViewById(R.id.china);
		final ToggleButton japanfood = (ToggleButton) findViewById(R.id.japan);
		final ToggleButton amaricafood = (ToggleButton) findViewById(R.id.amarica);
		final ToggleButton dessert = (ToggleButton) findViewById(R.id.desert);
		
		// 한식
		koreafood.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (koreafood.isChecked() == true) {
					koreafood.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.food_korea_s));
					chinafood.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.food_china));
					chinafood.setChecked(false);
					japanfood.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.food_japan));
					japanfood.setChecked(false);
					amaricafood.setBackgroundDrawable(getResources()
							.getDrawable(R.drawable.food_america));
					amaricafood.setChecked(false);
					dessert.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.food_dessert));
					dessert.setChecked(false);
				} else {
					koreafood.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.food_korea));
					koreafood.setChecked(false);
				}
			}
		});

		// 중식
		chinafood.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (chinafood.isChecked()) {
					koreafood.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.food_korea));
					koreafood.setChecked(false);
					chinafood.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.food_china_s));

					japanfood.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.food_japan));
					japanfood.setChecked(false);
					amaricafood.setBackgroundDrawable(getResources()
							.getDrawable(R.drawable.food_america));
					amaricafood.setChecked(false);
					dessert.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.food_dessert));
					dessert.setChecked(false);

				} else {
					chinafood.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.food_china));
					chinafood.setChecked(false);
				}
			}
		});

		// 일식
		japanfood.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (japanfood.isChecked()) {
					koreafood.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.food_korea));
					koreafood.setChecked(false);
					chinafood.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.food_china));
					chinafood.setChecked(false);
					japanfood.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.food_japan_s));

					amaricafood.setBackgroundDrawable(getResources()
							.getDrawable(R.drawable.food_america));
					amaricafood.setChecked(false);
					dessert.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.food_dessert));
					dessert.setChecked(false);
				} else {
					japanfood.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.food_japan));
					japanfood.setChecked(false);
				}
			}
		});
		// 양식

		amaricafood.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (amaricafood.isChecked()) {
					koreafood.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.food_korea));
					koreafood.setChecked(false);
					chinafood.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.food_china));
					chinafood.setChecked(false);
					japanfood.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.food_japan));
					japanfood.setChecked(false);
					amaricafood.setBackgroundDrawable(getResources()
							.getDrawable(R.drawable.food_america_s));
					dessert.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.food_dessert));
					dessert.setChecked(false);

				} else {
					amaricafood.setBackgroundDrawable(getResources()
							.getDrawable(R.drawable.food_america));
					amaricafood.setChecked(false);
				}
			}
		});

		// 후식

		dessert.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (dessert.isChecked()) {
					koreafood.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.food_korea));
					koreafood.setChecked(false);
					chinafood.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.food_china));
					chinafood.setChecked(false);
					japanfood.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.food_japan));
					japanfood.setChecked(false);
					amaricafood.setBackgroundDrawable(getResources()
							.getDrawable(R.drawable.food_america));
					amaricafood.setChecked(false);
					dessert.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.food_dessert_s));

				} else {
					dessert.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.food_dessert));
					dessert.setChecked(false);
				}
			}
		});

		// 포장

		final ToggleButton deliver = (ToggleButton) findViewById(R.id.deliver);
		final ToggleButton pack = (ToggleButton) findViewById(R.id.pack);
		pack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (pack.isChecked() == true) {
					pack.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.pack_s));
					deliver.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.deliver));
					deliver.setChecked(false);

				} else {
					pack.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.pack));
					pack.setChecked(false);
				}
			}
		});
		// 배달

		deliver.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (deliver.isChecked() == true) {
					deliver.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.deliver_s));
					pack.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.pack));
					pack.setChecked(false);

				} else {
					deliver.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.deliver));
					deliver.setChecked(false);
				}
			}
		});

		// 검색결과 버튼
		button_search = (Button) findViewById(R.id.button_search);
		button_search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SearchActivity.this,
						SearchResultActivity.class);
				searchword = null;
				searchword1 = null;
				searchword2 = null;
				if (morning.isChecked() == true) {
					searchword = "아침";
				} else if (afternoon.isChecked() == true) {
					searchword = "점심";
				} else if (evening.isChecked() == true) {
					searchword = "저녁";
				}
				if (koreafood.isChecked() == true) {
					searchword1 = "한식";
				} else if (chinafood.isChecked() == true) {
					searchword1 = "중식";
				} else if (japanfood.isChecked() == true) {
					searchword1 = "일식";
				} else if (amaricafood.isChecked() == true) {
					searchword1 = "양식";
				} else if (dessert.isChecked() == true) {
					searchword1 = "디저트";
				}
				if (pack.isChecked() == true) {
					searchword2 = "포장";
				} else if (deliver.isChecked() == true) {
					searchword2 = "배달";
				}

				intent.putExtra("searchword", searchword);
				intent.putExtra("searchword1", searchword1);
				intent.putExtra("searchword2", searchword2);
				startActivityForResult(intent, 0);
			}
		});

	}// onCreate

	protected void toogleMorning(boolean check) {
		final ToggleButton morning = (ToggleButton) findViewById(R.id.morning);
		morning.setBackgroundDrawable(getResources().getDrawable(
				check ? R.drawable.time_morning_s : R.drawable.time_morning));
		morning.setChecked(check);
	}

	protected void toogleafternoon(boolean check) {
		final ToggleButton afternoon = (ToggleButton) findViewById(R.id.afternoon);
		afternoon.setBackgroundDrawable(getResources().getDrawable(
						check ? R.drawable.time_afternoon_s: R.drawable.time_afternoon));
		afternoon.setChecked(check);
	}
	
	protected void toogleevening(boolean check) {
		final ToggleButton evening = (ToggleButton) findViewById(R.id.evening);
		evening.setBackgroundDrawable(getResources().getDrawable(
						check ? R.drawable.time_evening_s: R.drawable.time_evening));
		evening.setChecked(check);
	}
	
	protected void tooglekorea(boolean check) {
		final ToggleButton korea = (ToggleButton) findViewById(R.id.korea);
		korea.setBackgroundDrawable(getResources().getDrawable(
						check ? R.drawable.food_korea_s: R.drawable.food_korea));
		korea.setChecked(check);
	}
	
	protected void tooglechina(boolean check) {
		final ToggleButton china = (ToggleButton) findViewById(R.id.china);
		china.setBackgroundDrawable(getResources().getDrawable(
						check ? R.drawable.food_china_s: R.drawable.food_china));
		china.setChecked(check);
	}
	protected void tooglejapan(boolean check) {
		final ToggleButton japan = (ToggleButton) findViewById(R.id.japan);
		japan.setBackgroundDrawable(getResources().getDrawable(
						check ? R.drawable.food_japan_s: R.drawable.food_japan));
		japan.setChecked(check);
	}
	protected void toogleamarica(boolean check) {
		final ToggleButton amarica = (ToggleButton) findViewById(R.id.amarica);
		amarica.setBackgroundDrawable(getResources().getDrawable(
						check ? R.drawable.food_america_s: R.drawable.food_america));
		amarica.setChecked(check);
	}
	protected void toogledesert(boolean check) {
		final ToggleButton desert = (ToggleButton) findViewById(R.id.desert);
		desert.setBackgroundDrawable(getResources().getDrawable(
						check ? R.drawable.food_dessert_s: R.drawable.food_dessert));
		desert.setChecked(check);
	}
	protected void tooglepack(boolean check) {
		final ToggleButton pack = (ToggleButton) findViewById(R.id.pack);
		pack.setBackgroundDrawable(getResources().getDrawable(
						check ? R.drawable.pack_s: R.drawable.pack));
		pack.setChecked(check);
	}
	
	protected void toogledelivery(boolean check) {
		final ToggleButton deliver = (ToggleButton) findViewById(R.id.deliver);
		deliver.setBackgroundDrawable(getResources().getDrawable(
						check ? R.drawable.deliver_s: R.drawable.deliver));
		deliver.setChecked(check);
	}
	

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode != 0) {
			return;
		}

		toogleMorning(false);
		toogleafternoon(false);
		toogleevening(false);
		tooglekorea(false);
		tooglechina(false);
		tooglejapan(false);
		toogleamarica(false);
		toogledesert(false);
		tooglepack(false);
		toogledelivery(false);
		
	}

}