package kr.hs.emirim.namsojeongyou.gosichon2;

import android.os.Bundle;
import android.app.Activity;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SearchResultActivity extends Activity implements
		OnItemClickListener {
	ArrayList<Integer> listindex = new ArrayList<Integer>();
	String searchword, searchword1, searchword2;

	String soondaesearch = "아침, 점심, 저녁, 한식,포장";
	String momoamisearch = "점심, 저녁, 일식,";
	String backsearch = "아침, 점심, 저녁, 한식,";
	String bonggusussearch = "아침, 점심, 저녁, 한식,포장,배달";
	String ssagunsearch = "점심, 저녁, 양식,";
	String amasbinsearch = "아침, 점심, 저녁, 디저트, 포장";
	String yajjajangsearch = "아침, 점심, 저녁, 중식, 포장";
	String chamjjajangsearch = "아침, 점심, 저녁, 중식";
	String tomatosearch = "아침, 점심, 저녁, 한식, 포장";
	String pigsearch = "아침, 점심, 저녁, 디저트, 포장";
	String alchonsearch = "아침, 점심, 저녁, 한식, 포장";
	String babafflesearch = "점심, 저녁, 디저트, 포장";
	String bubblyteasearch = "점심, 저녁, 디저트, 포장";
	String cafelavingnesearch = "아침, 점심, 저녁, 디저트, 포장";
	String basaksearch = "점심, 저녁, 양식, 포장";
	String bcup = "점심, 저녁, 한식, 배달, 포장";

	String storesearch[] = { soondaesearch, momoamisearch, backsearch,
			bonggusussearch, ssagunsearch, amasbinsearch, yajjajangsearch,
			chamjjajangsearch, tomatosearch, pigsearch, alchonsearch,
			babafflesearch, bubblyteasearch, cafelavingnesearch, basaksearch,
			bcup };

	// 개경순대국
	String soondae[] = { "개경순대국", "순대국, 해장국 등", "12:00 ~ 24:00", "40",
			"02-887-7545", " ", "불가", "가능", "밑반찬 셀프, 24시 영업",
			String.valueOf(R.drawable.list_korean) };
	// 모모야미
	String momoami[] = { "모모야미(33)", "라멘, 돈부리 등",
			"11:00 ~ 21:00(break time : 15:00 ~ 17:00)", "26", "02-882-9267",
			"서울특별시 관악구 신림동 1556-1", "불가", "불가", "냉모밀(여름계절특선), break time 유의",
			String.valueOf(R.drawable.list_japan) };
	// 백가집
	String back[] = { "백가집", "찌개, 제육덮밥 등", "9:30 ~ 21:00", "26", "02-855-5486",
			" ", "불가(백가집 근처만 가능)", "불가", "맛 조절 가능(짜게/싱겁게)",
			String.valueOf(R.drawable.list_korean) };
	// 봉구스 밥버거
	String bonggusu[] = { "봉구스 밥버거", "밥버거",
			"(월~토)9:00 ~ 22:00 (일)10:00 ~ 22:00", "12", "서울특별시 관악구 신림동 246-29",
			"02-877-2461", "단체주문시 가능(약25개 이상)", "가능", " ",
			String.valueOf(R.drawable.list_korean) };
	// 싸군
	String ssagun[] = { "싸군", "돈까스(뷔페)", "11:30 ~ 22:00", "64", "02-887-2686",
			" ", "불가", "불가", "뷔페", String.valueOf(R.drawable.list_american) };
	// 아마스빈
	String amasbin[] = { "아마스빈", "버블티, 커피, 브라우니 등", "9:00 ~ 23:00", "19",
			"070-7808-7044", "서울특별시 관악구 신림동 1532-20", "불가", "가능",
			"와이파이 제공, 방문쿠폰/주문시 음료1잔 당 도장1개 10개 모을시 음료 한잔 무료",
			String.valueOf(R.drawable.list_dessert) };
	// 예짜장면
	String yejjajang[] = { "예 짜장면", "짜장면, 짬뽕 등", "10:00 ~ 21:30", "32",
			"02-882-9997", " ", "불가", "가능",
			"특선 1인 메뉴로 적당한 가격에 많은 종류의 음식을 먹을 수 있음.",
			String.valueOf(R.drawable.list_china) };
	// 참짜장
	String chamjjajang[] = { "참짜장", "짜장면, 짬뽕 등", "10:00 ~ 20:00", "20",
			"02-871-3097", " ", "불가", "불가", "불규칙한 영업시간",
			String.valueOf(R.drawable.list_china) };
	// 토마토김밥
	String tomato[] = { "토마토 김밥", "김밥, 주먹밥, 라면 등의 분식 류", "6:00 ~ 23:00", "31",
			"02-877-0091", " ", "불가", "가능", " ",
			String.valueOf(R.drawable.list_korean) };
	// 피그말리온
	String pigmalion[] = { "피그말리온", "커피, 다과 등", "8:00 ~ 22:00", "27", " ", " ",
			"불가", "가능", "실외 6좌석 흡연가능", String.valueOf(R.drawable.list_dessert) };
	// Alchon (알촌)
	String alchon[] = { "Alchon(알촌)", "알밥", "10:00 ~ 22:00", "30",
			"서울시 관악구 대학동 1519-19", "(제휴문의)1661-1907", "불가", "가능",
			"반찬, 국 등은 셀프. 맛 선택 가능(순함/매움)",
			String.valueOf(R.drawable.list_korean) };
	// Babaffle
	String babaffle[] = { "Babaffle", "와플", "12:00 ~ 23:45", "없음",
			"(가맹문의)010-2356-0831", " ", "불가", "가능",
			"입맛에 맞는 추가 주문(아이스크림500원 추가), 시럽 선택 가능",
			String.valueOf(R.drawable.list_dessert) };
	// Bubbly tea
	String bubblytea[] = { "Bubbly tea", "버블티, 커피", "11:00 ~ 23:00", "21",
			"010-8033-8111", "  ", "불가", "가능", "오늘의 음료 세일",
			String.valueOf(R.drawable.list_dessert) };
	// cafe' Lavingne
	String cafelavingne[] = { "cafe' Lavingne", "커피, 치즈케익 등", "7:00 ~ 21:00",
			"16", "070-4127-0506", " ", "불가", "가능", "오늘의 음료 세일, 와이파이 제공",
			String.valueOf(R.drawable.list_dessert) };
	// The 바삭바삭
	String thebasak[] = { "The 바삭바삭", "돈까스, 덮밥",
			"11:00 ~ 21:30 (break time : 15:30 ~ 16:30)", "24",
			"서울시 관악구 대학동 1533-16", "(가맹문의)010-2356-0831", "불가", "가능",
			"break time 에 유의.", String.valueOf(R.drawable.list_american) };
	// The B컵닭
	String thebcup[] = { "The B컵닭", "닭강정", "11:00 ~ 2:00", "6",
			"서울시 관악구 신림동 1536-2", "02-875-0930", "(5만원 이상 주문시)가능", "가능",
			"맛 선택 가능(단맛/매운맛)", String.valueOf(R.drawable.list_korean) };
	String stores[][] = { soondae, momoami, back, bonggusu, ssagun, amasbin,
			yejjajang, chamjjajang, tomato, pigmalion, alchon, babaffle,
			bubblytea, cafelavingne, thebasak, thebcup };
	// 리스트뷰 선언
	private ListView listview;

	// 데이터를 연결할 Adapter
	DataAdapter adapter;

	// 데이터를 담을 자료구조
	ArrayList<CData> alist;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_list);
		
		// 선언한 리스트뷰에 사용할 리스뷰연결
		listview = (ListView) findViewById(R.id.list);
		listview.setOnItemClickListener(this);

//		if(searchword == null){
//			onResume();
//				}
//				if(searchword1 == null){
//					onResume();
//				}
//				if(searchword2 == null){
//				onResume();
//				}
//				
			

	}
	@Override
	protected void onResume() {
		Intent intent1 = getIntent();
		// getIntExtra("받는변수명", 기본값)
		String searchword = intent1.getStringExtra("searchword");
		String searchword1 = intent1.getStringExtra("searchword1");
		String searchword2 = intent1.getStringExtra("searchword2");

		
		listindex = new ArrayList<Integer>();
		
		for (int j = 0; j < storesearch.length; j++) {
			if ((searchword == null || storesearch[j].contains(searchword)) 
					&& (searchword1 == null || storesearch[j].contains(searchword1))
					&& (searchword2 == null ||storesearch[j].contains(searchword2))){// && 로 3개
			
				listindex.add(j);
			}
				

		}
		if (listindex.size() == 0) {
			Toast.makeText(this, "검색결과가 없습니다.", Toast.LENGTH_LONG).show();
			finish();
		}

		// 객체를 생성합니다
		alist = new ArrayList<CData>();

		// 데이터를 받기위해 데이터어댑터 객체 선언
		adapter = new DataAdapter(this, alist);

		// 리스트뷰에 어댑터 연결
		listview.setAdapter(adapter);

		// ArrayAdapter를 통해서 ArrayList에 자료 저장
		// 하나의 String값을 저장하던 것을 CData클래스의 객체를 저장하던것으로 변경
		// CData 객체는 생성자에 리스트 표시 텍스트뷰1의 내용과 텍스트뷰2의 내용 그리고 사진이미지값을 어댑터에 연결

		// CData클래스를 만들때의 순서대로 해당 인수값을 입력
		// 한줄 한줄이 리스트뷰에 뿌려질 한줄 한줄이라고 생각하면 됩니다.
		for (int j = 0; j < listindex.size(); j++) {
			adapter.add(new CData(getApplicationContext(), stores[listindex
					.get(j)][0], stores[listindex.get(j)][1], Integer
					.parseInt(stores[listindex.get(j)][9])));
		}
		super.onResume();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		Intent intent;
		intent = new Intent(SearchResultActivity.this, StoreActivity.class);
		intent.putExtra("position", listindex.get(position));// position 값을 전달.
		startActivity(intent);

	}// onItemClick

	private class DataAdapter extends ArrayAdapter<CData> {
		// 레이아웃 XML을 읽어들이기 위한 객체
		private LayoutInflater mInflater;

		public DataAdapter(Context context, ArrayList<CData> object) {

			// 상위 클래스의 초기화 과정
			// context, 0, 자료구조
			super(context, 0, object);
			mInflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		}

		// 보여지는 스타일을 자신이 만든 xml로 보이기 위한 구문
		@Override
		public View getView(int position, View v, ViewGroup parent) {
			View view = null;

			// 현재 리스트의 하나의 항목에 보일 컨트롤 얻기

			if (v == null) {

				// XML 레이아웃을 직접 읽어서 리스트뷰에 넣음
				view = mInflater.inflate(R.layout.custom_listview, null);
			} else {

				view = v;
			}

			// 자료를 받는다.
			final CData data = this.getItem(position);

			if (data != null) {
				// 화면 출력
				TextView tv = (TextView) view.findViewById(R.id.store_name);
				TextView tv2 = (TextView) view.findViewById(R.id.store_menu);
				// 텍스트뷰1에 getLabel()을 출력 즉 첫번째 인수값
				tv.setText(data.getLabel());
				// 텍스트뷰2에 getData()을 출력 즉 두번째 인수값
				tv2.setText(data.getData());

				ImageView iv = (ImageView) view.findViewById(R.id.list_image);

				// 이미지뷰에 뿌려질 해당 이미지값을 연결 즉 세번째 인수값
				iv.setImageResource(data.getData2());
			}
			return view;
		}
	}// DataAdapter

	// CData안에 받은 값을 직접 할당
	class CData {
		private String m_szLabel;
		private String m_szData;
		private int m_szData2;

		public CData(Context context, String p_szLabel, String p_szDataFile,
				int p_szData2) {
			m_szLabel = p_szLabel;
			m_szData = p_szDataFile;
			m_szData2 = p_szData2;
		}

		public String getLabel() {
			return m_szLabel;
		}

		public String getData() {
			return m_szData;
		}

		public int getData2() {
			return m_szData2;
		}
	}// CData

}