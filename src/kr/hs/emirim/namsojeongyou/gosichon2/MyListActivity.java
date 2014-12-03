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

public class MyListActivity extends Activity implements OnItemClickListener {

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
		adapter.add(new CData(getApplicationContext(), "계경순대국", "순대국, 해장국 등",
				R.drawable.list_korean));
		adapter.add(new CData(getApplicationContext(), "모모야미(33)", "라멘, 돈부리 등",
				R.drawable.list_japan));
		adapter.add(new CData(getApplicationContext(), "백가집",
				"된장찌개, 김치찌개, 제육덮밥", R.drawable.list_korean));
		adapter.add(new CData(getApplicationContext(), "봉구스 밥버거", "밥버거",
				R.drawable.list_korean));
		adapter.add(new CData(getApplicationContext(), "싸군", "돈까스 무한리필",
				R.drawable.list_american));
		adapter.add(new CData(getApplicationContext(), "아마스빈", "버블티, 커피등",
				R.drawable.list_dessert));
		adapter.add(new CData(getApplicationContext(), "예 짜장면", "짜장면, 짬뽕 등",
				R.drawable.list_china));
		adapter.add(new CData(getApplicationContext(), "참짜장 기계우동", "짜장면, 짬뽕 등",
				R.drawable.list_china));
		adapter.add(new CData(getApplicationContext(), "토마토김밥", "분식류",
				R.drawable.list_korean));
		adapter.add(new CData(getApplicationContext(), "피그말리온", "커피, 다과 등",
				R.drawable.list_dessert));
		adapter.add(new CData(getApplicationContext(), "Alchon", "알밥",
				R.drawable.list_korean));
		adapter.add(new CData(getApplicationContext(), "BaBaffle", "와플",
				R.drawable.list_dessert));
		adapter.add(new CData(getApplicationContext(), "Bubbly tea",
				"버블티, 커피 등", R.drawable.list_dessert));
		adapter.add(new CData(getApplicationContext(), "cafe' Lavingne",
				"버블티, 치즈케익 등", R.drawable.list_dessert));
		adapter.add(new CData(getApplicationContext(), "The 바삭바삭", "돈까스, 덮밥 등",
				R.drawable.list_american));
		adapter.add(new CData(getApplicationContext(), "The B컵닭", "닭강정",
				R.drawable.list_korean));

		listview.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		Intent intent;
		intent = new Intent(MyListActivity.this, StoreActivity.class);
		intent.putExtra("position", position);//position 값을 전달.
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
