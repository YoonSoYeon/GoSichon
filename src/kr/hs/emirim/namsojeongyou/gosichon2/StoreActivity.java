package kr.hs.emirim.namsojeongyou.gosichon2;

import android.app.Activity;
import android.app.Notification.Action;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class StoreActivity extends Activity implements OnClickListener {
	// 순서 : 가게이름, 메뉴, 영업시간, 좌석수, 전화번호, 주소, 배달여부, 포장여부, 기타, 가격대
	TextView storename, menu, time, seat, tel, address, delivery, takeout, etc, price;
	ImageView storeimage;
	ImageButton one, two, three, four, five, six, seven;
	String soondaesearch[] = { "아침, 점심, 저녁, 한식,포장" };
	String momoamisearch[] = { "점심, 저녁, 일식," };
	String backsearch[] = { "아침, 점심, 저녁, 한식," };
	String bonggusussearch[] = { "아침, 점심, 저녁, 한식, 배달" };
	String ssagunsearch[] = { "점심, 저녁, 양식," };
	String amasbinsearch[] = {"아침, 점심, 저녁, 디저트, 포장"};
	String yajjajangsearch[] = {"아침, 점심, 저녁, 중식, 포장"};
	String chamjjajangsearch[] = {"아침, 점심, 저녁, 중식"};
	String tomatosearch[] = {"아침, 점심, 저녁, 한식, 포장"};
	String pigsearch[] = {"아침, 점심, 저녁, 디저트, 포장"};
	String alchonsearch[] = {"아침, 점심, 저녁, 한식, 포장"};
	String babafflesearch[] = {"점심, 저녁, 디저트, 포장"};
	String bubblyteasearch[] = {"점심, 저녁, 디저트, 포장"};
	String cafelavingnesearch[] = {"아침, 점심, 저녁, 디저트, 포장"};
	String basaksearch[] = {"점심, 저녁, 양식, 포장"};
	String bcup[] = {"점심, 저녁, 한식, 배달, 포장"};
	
	String storesearch[][] = {soondaesearch, momoamisearch, backsearch, bonggusussearch, ssagunsearch, amasbinsearch, yajjajangsearch,
			chamjjajangsearch, tomatosearch, pigsearch, alchonsearch, babafflesearch, bubblyteasearch, cafelavingnesearch, basaksearch, bcup};
	// 계경순대국
	String soondae[] = { "계경순대국", "순대국, 해장국 등", "12:00 ~ 24:00", "40",
			"02-887-7545", "서울 관악구 호암로22길 49", "불가", "가능", "밑반찬 셀프, 24시 영업","(국밥)5,000원 ~ 9,000원/(감자탕)17,000 원 ~ 27,000원" };
	// 모모야미
	String momoami[] = { "모모야미(33)", "라멘, 돈부리 등",
			"11:00 ~ 21:00(break time : 15:00 ~ 17:00)", "26", "02-882-9267",
			"서울 관악구 호암로22 가길", "불가", "불가", "냉모밀(여름계절특선), break time 유의","(음식)4,500원 ~ 6,000원/(사이드)1,000원 ~ 5,400원" };
	// 백가집
	String back[] = { "백가집", "찌개, 제육덮밥 등", "9:30 ~ 21:00", "26", "02-855-5486",
			".", "불가(백가집 근처만 가능)", "불가", "맛 조절 가능(짜게/싱겁게)","3,000원 ~ 4,000원" };
	// 봉구스 밥버거
	String bonggusu[] = { "봉구스 밥버거", "밥버거",
			"(월~토)9:00 ~ 22:00 (일)10:00 ~ 22:00", "12", 
			"02-877-2461","서울 관악구 대학길 41", "단체주문시 가능(약25개 이상)", "가능", "25개이상 주문시 배달 가능.","1,500원 ~ 3,000원" };
	// 싸군
	String ssagun[] = { "싸군", "돈까스(뷔페)", "11:30 ~ 22:00", "64", "02-887-2686",
			".", "불가", "불가", "뷔페","(성인)5,900원 / (초등생)4,900원 / (유아)2,900원 / (음료)1,000원 ~ 3,000원" };
	// 아마스빈
	String amasbin[] = { "아마스빈", "버블티, 커피, 브라우니 등", "9:00 ~ 23:00", "19",
			"070-7808-7044", "서울 관악구 호암로22길 21", "불가", "가능",
			"와이파이 제공. 방문쿠폰/음료 주문시 음료1잔 당 도장1개찍어줌. 10개 모을시 음료 한잔 무료","(음료)1,800원 ~ 4,500원 / (디저트)1,500원 ~ 7,800원" };
	// 예짜장면
	String yejjajang[] = { "예 짜장면", "짜장면, 짬뽕 등", "10:00 ~ 21:30", "32",
			"02-882-9997", "서울 관악구 신림로21길 40", "불가", "가능",
			"특선 1인 메뉴로 적당한 가격에 많은 종류의 음식을 먹을 수 있음.","3,500원 ~ 5,000원" };
	// 참짜장기계우동
	String chamjjajang[] = { "참짜장 기계우동", "짜장면, 짬뽕, 우동 등", "10:00 ~ 20:00", "20",
			"02-871-3097", "서울 관악구 호암로24길 11", "불가", "불가", "불규칙한 영업시간에 주의","3,000원 ~ 4,500원"};
	// 토마토김밥
	String tomato[] = { "토마토 김밥", "김밥, 주먹밥, 라면 등의 분식 류", "6:00 ~ 23:00",
			"31", "02-877-0091", "서울 관악구 호암로22길 51", "불가", "가능", "-","2,000원 ~ 6,000원" };
	// 피그말리온
	String pigmalion[] = { "피그말리온", "커피, 다과 등", "8:00 ~ 22:00", "27", "02-887-2270", "서울 관악구 호암로22길 41",
			"불가", "가능", "실외 6좌석 흡연가능","1,000원 ~ 3,500원" };
	// Alchon (알촌)
	String alchon[] = { "Alchon(알촌)", "알밥", "10:00 ~ 22:00", "30",
			"(제휴문의)1661-1907","서울 관악구 호암로24길 55",  "불가", "가능",
			"반찬, 국 등은 셀프. 맛 선택 가능(순함/매움)","3,500원 ~ 4,500원" };
	// Babaffle
	String babaffle[] = { "Babaffle", "와플", "12:00 ~ 23:45", "없음",
			"(가맹문의)010-2356-0831", "-", "불가", "가능",
			"입맛에 맞는 추가 주문(아이스크림500원 추가), 시럽 선택 가능","1,000원 ~ 3,000원" };
	// Bubbly tea
	String bubblytea[] = { "Bubbly tea", "버블티, 커피", "11:00 ~ 23:00", "21",
			"070-7560-1208", "서울 관악구 신림로17길 42", "불가", "가능", "오늘의 음료 세일","1,400원 ~ 5,000원" };
	// cafe' Lavingne
	String cafelavingne[] = { "cafe' Lavingne(라빈느)", "커피, 치즈케익 등", "7:00 ~ 21:00",
			"16", "070-4127-0506", "서울 관악구 신림로17길 57", "불가", "가능", "오늘의 음료 세일, 와이파이 제공","(음료)1,000원 ~ 3,000원/(디저트)1,000원 ~ 4,000원" };
	// The 바삭바삭
	String thebasak[] = { "The 바삭바삭", "돈까스, 덮밥",
			"11:00 ~ 21:30 (break time : 15:30 ~ 16:30)", "24",
			 "070-6062-7647", "서울 관악구 호암로22길 25","불가", "가능",
			"break time 에 유의." ,"4,000원 ~ 6,000원"};
	// The B컵닭
	String thebcup[] = { "The B컵닭", "닭강정", "11:00 ~ 2:00", "6",
			"02-875-0930","서울 관악구 신림로17길 32",  "(5만원 이상 주문시)가능", "가능",
			"맛 선택 가능(단맛/매운맛)","1,000원 ~ 8,000원" };

	// 개경순대국
	int soondae1[] = { R.drawable.soondae_a, R.drawable.soondae_b,
			R.drawable.soondae_c, R.drawable.soondae_d, R.drawable.soondae_e,
			R.drawable.soondae_f, R.drawable.soondae_g };
	// 모모야미
	int momoami1[] = { R.drawable.momoami_a, R.drawable.momoami_b,
			R.drawable.momoami_c, R.drawable.momoami_d, R.drawable.momoami_e,
			R.drawable.momoami_f, R.drawable.momoami_g };
	// 백가집
	int back1[] = { R.drawable.bakga_a, R.drawable.bakga_b, R.drawable.bakga_c,
			R.drawable.bakga_d, R.drawable.bakga_e, R.drawable.bakga_f,
			R.drawable.bakga_g };
	// 봉구스 밥버거
	int bonggusu1[] = { R.drawable.bongguse_a, R.drawable.bongguse_b,
			R.drawable.bongguse_c, R.drawable.bongguse_d,
			R.drawable.bongguse_e, R.drawable.bongguse_f, R.drawable.bongguse_g };
	// 싸군
	int ssagun1[] = { R.drawable.ssagun_a, R.drawable.ssagun_b,
			R.drawable.ssagun_c, R.drawable.ssagun_d, R.drawable.ssagun_e,
			R.drawable.ssagun_f, R.drawable.ssagun_g };
	// 아마스빈
	int amasbin1[] = { R.drawable.anasbing_a, R.drawable.anasbingimage_b,
			R.drawable.anasbingimage_c, R.drawable.anasbingimage_d,
			R.drawable.anasbingimage_e, R.drawable.anasbingimage_f,
			R.drawable.anasbingimage_g };
	// 예짜장면
	int yejjajang1[] = { R.drawable.yae_a, R.drawable.yae_b, R.drawable.yae_c,
			R.drawable.yae_d, R.drawable.yae_e, R.drawable.yae_f,
			R.drawable.yae_g };
	// 참짜장
	int chamjjajang1[] = { R.drawable.chan_a, R.drawable.chan_b,
			R.drawable.chan_c, R.drawable.chan_d, R.drawable.chan_e,
			R.drawable.chan_f, R.drawable.chan_g };
	// 토마토김밥
	int tomato1[] = { R.drawable.tomato_a, R.drawable.tomato_b,
			R.drawable.tomato_c, R.drawable.tomato_d, R.drawable.tomato_e,
			R.drawable.tomato_f, R.drawable.tomato_g };
	// 피그말리온
	int pigmalion1[] = { R.drawable.pig_a, R.drawable.pig_b, R.drawable.pig_c,
			R.drawable.pig_d, R.drawable.pig_e, R.drawable.pig_f,
			R.drawable.pig_g };
	// Alchon (알촌)
	int alchon1[] = { R.drawable.alchon_a, R.drawable.alchon_b,
			R.drawable.alchon_c, R.drawable.alchon_d, R.drawable.alchon_e,
			R.drawable.alchon_f, R.drawable.alchon_g };
	// Babaffle
	int babaffle1[] = { R.drawable.babaffle_m, R.drawable.babaffle_a,
			R.drawable.babaffle_b, R.drawable.babaffle_c,
			R.drawable.babaffle_d, R.drawable.babaffle_e, R.drawable.babaffle_f };
	// Bubbly tea
	int bubblytea1[] = { R.drawable.bubblytea_a, R.drawable.bubblytea_b,
			R.drawable.bubblytea_c, R.drawable.bubblytea_d,
			R.drawable.bubblytea_e, R.drawable.bubblytea_f,
			R.drawable.bubblytea_g };
	// cafe' Lavingne
	int cafelavingne1[] = { R.drawable.cafelavingne_a,
			R.drawable.cafelavingne_b, R.drawable.cafelavingne_c,
			R.drawable.cafelavingne_d, R.drawable.cafelavingne_e,
			R.drawable.cafelavingne_f, R.drawable.cafelavingne_g };
	// The 바삭바삭
	int thebasak1[] = { R.drawable.basagsag_a, R.drawable.basagsag_b,
			R.drawable.basagsag_c, R.drawable.basagsag_d,
			R.drawable.basagsag_e, R.drawable.basagsag_c, R.drawable.basagsag_b };
	// The B컵닭
	int thebcup1[] = { R.drawable.bcupdang_a, R.drawable.bcupdang_b,
			R.drawable.bcupdang_c, R.drawable.bcupdang_d,
			R.drawable.bcupdang_e, R.drawable.bcupdang_f,R.drawable.bcupdang_f };

	String stores[][] = { soondae, momoami, back, bonggusu, ssagun, amasbin,
			yejjajang, chamjjajang, tomato, pigmalion, alchon, babaffle,
			bubblytea, cafelavingne, thebasak, thebcup };
	int stores1[][] = { soondae1, momoami1, back1, bonggusu1, ssagun1,
			amasbin1, yejjajang1, chamjjajang1, tomato1, pigmalion1, alchon1,
			babaffle1, bubblytea1, cafelavingne1, thebasak1, thebcup1 };

	int position;
	int position2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);
		Intent intent = getIntent();
		position = intent.getIntExtra("position", 0);

		// 글씨 관련 (text 정보)
		storename = (TextView) findViewById(R.id.store_name);
		menu = (TextView) findViewById(R.id.store_menu);
		time = (TextView) findViewById(R.id.store_time);
		seat = (TextView) findViewById(R.id.store_seat);
		tel = (TextView) findViewById(R.id.store_tel);
		address = (TextView) findViewById(R.id.store_address);
		delivery = (TextView) findViewById(R.id.store_delivery);
		takeout = (TextView) findViewById(R.id.store_takeout);
		etc = (TextView) findViewById(R.id.store_title_etc);
		price = (TextView) findViewById(R.id.store_price);

		// 이미지관련
		storeimage = (ImageView) findViewById(R.id.storeimage);
		one = (ImageButton) findViewById(R.id.one);
		one.setOnClickListener(this);
		two = (ImageButton) findViewById(R.id.two);
		two.setOnClickListener(this);
		three = (ImageButton) findViewById(R.id.three);
		three.setOnClickListener(this);
		four = (ImageButton) findViewById(R.id.four);
		four.setOnClickListener(this);
		five = (ImageButton) findViewById(R.id.five);
		five.setOnClickListener(this);
		six = (ImageButton) findViewById(R.id.six);
		six.setOnClickListener(this);
		seven = (ImageButton) findViewById(R.id.seven);
		seven.setOnClickListener(this);

		storename.setText(stores[position][0]);
		menu.setText(stores[position][1]);
		time.setText(stores[position][2]);
		seat.setText(stores[position][3]);
		tel.setText(stores[position][4]);
		address.setText(stores[position][5]);
		delivery.setText(stores[position][6]);
		takeout.setText(stores[position][7]);
		etc.setText(stores[position][8]);
		price.setText(stores[position][9]);

		storeimage.setImageResource(stores1[position][0]);
		one.setImageResource(stores1[position][0]);
		two.setImageResource(stores1[position][1]);
		three.setImageResource(stores1[position][2]);
		four.setImageResource(stores1[position][3]);
		five.setImageResource(stores1[position][4]);
		six.setImageResource(stores1[position][5]);
		seven.setImageResource(stores1[position][6]);

	}// onCreate

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.store_tel:
			Intent intent7 = new Intent(Intent.ACTION_DIAL);
			intent7.setData(Uri.parse(stores[position][4]));
			startActivity(intent7);
			break;
		case R.id.one:
			Intent intent = new Intent(this, Imagemain.class);
			intent.putExtra("position2", 0);
			intent.putExtra("position", position);
			startActivity(intent);
			break;

		case R.id.two:
			Intent intent1 = new Intent(this, Imagemain.class);
			intent1.putExtra("position2", 1);
			intent1.putExtra("position", position);
			startActivity(intent1);
			break;

		case R.id.three:
			Intent intent2 = new Intent(this, Imagemain.class);
			intent2.putExtra("position2", 2);
			intent2.putExtra("position", position);
			startActivity(intent2);
			break;

		case R.id.four:
			Intent intent3 = new Intent(this, Imagemain.class);
			intent3.putExtra("position2", 3);
			intent3.putExtra("position", position);
			startActivity(intent3);
			break;
		case R.id.five:
			Intent intent4 = new Intent(this, Imagemain.class);
			intent4.putExtra("position2", 4);
			intent4.putExtra("position", position);
			startActivity(intent4);
			finish();
			break;

		case R.id.six:
			Intent intent5 = new Intent(this, Imagemain.class);
			intent5.putExtra("position2", 5);
			intent5.putExtra("position", position);
			startActivity(intent5);
			break;

		case R.id.seven:
			Intent intent6 = new Intent(this, Imagemain.class);
			intent6.putExtra("position2", 6);
			intent6.putExtra("position", position);
			startActivity(intent6);
			break;

		}

	}

}