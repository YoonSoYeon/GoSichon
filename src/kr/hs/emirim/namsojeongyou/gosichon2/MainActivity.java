package kr.hs.emirim.namsojeongyou.gosichon2;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity implements OnClickListener {
	CheckBox checkBox, cancle;

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		init();

		startActivityForResult(new Intent(MainActivity.this,
				SplashActivith.class), 0);
		CheckBox checkbox = (CheckBox) findViewById(R.id.checkbox);
		CheckBox cancle = (CheckBox) findViewById(R.id.cancle);
		checkbox.setOnClickListener(this);
		cancle.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (((CheckBox) findViewById(R.id.checkbox)).isChecked() == true) {
			showMainScreen();
			PreferenceManager.getDefaultSharedPreferences(MainActivity.this)
					.edit().putBoolean("cheked", true).commit();
			return;
		} else if (((CheckBox) findViewById(R.id.cancle)).isChecked() == true) {
			showMainScreen();

		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Boolean ischeked = PreferenceManager.getDefaultSharedPreferences(this)
				.getBoolean("cheked", false);
		if (ischeked) {
			showMainScreen();
		} else {
			showOverlayScreen();
		}
	}

	protected void init() {
		TabHost tabHost = getTabHost();

		// Tab for Map
		TabSpec map = tabHost.newTabSpec("Map");
		// setting Title and Icon for the Tab
		map.setIndicator("Map",
				getResources().getDrawable(R.drawable.icon_map_tab));
		Intent mapIntent = new Intent(this, MapActivity.class);
		map.setContent(mapIntent);

		// Tab for List
		TabSpec list = tabHost.newTabSpec("List");
		list.setIndicator("List",
				getResources().getDrawable(R.drawable.icon_list_tab));
		Intent listIntent = new Intent(this, MyListActivity.class);
		list.setContent(listIntent);

		// Tab for Stamp
		TabSpec stamp = tabHost.newTabSpec("Stamp");
		stamp.setIndicator("Stamp",
				getResources().getDrawable(R.drawable.icon_stamp_tab));
		Intent StampIntent = new Intent(this, StampActivity.class);
		stamp.setContent(StampIntent);

		// Tab for Search
		TabSpec search = tabHost.newTabSpec("Search");
		// setting Title and Icon for the Tab
		search.setIndicator("Search",
				getResources().getDrawable(R.drawable.icon_search_tab));
		Intent SearchIntent = new Intent(this, SearchActivity.class);
		search.setContent(SearchIntent);

		// Adding all TabSpec to TabHost
		tabHost.addTab(map); // Adding Map tab
		tabHost.addTab(list); // Adding List tab
		tabHost.addTab(stamp); // Adding Stamp tab
		tabHost.addTab(search); // Adding Search tab

		// Tab for map color
		tabHost.getTabWidget().getChildAt(0)
				.setBackgroundColor(Color.parseColor("#f5a038"));
		// Tab for list color
		tabHost.getTabWidget().getChildAt(1)
				.setBackgroundColor(Color.parseColor("#87b940"));
		// Tab for stamp color
		tabHost.getTabWidget().getChildAt(2)
				.setBackgroundColor(Color.parseColor("#ffcd33"));
		// Tab for search color
		tabHost.getTabWidget().getChildAt(3)
				.setBackgroundColor(Color.parseColor("#f16567"));

	}

	protected void showOverlayScreen() {
		View overlay = findViewById(R.id.layout_overlay);
		View main = findViewById(android.R.id.tabhost);

		overlay.setVisibility(View.VISIBLE);
		main.setVisibility(View.GONE);
	}

	protected void showMainScreen() {
		View overlay = findViewById(R.id.layout_overlay);
		View main = findViewById(android.R.id.tabhost);

		overlay.setVisibility(View.GONE);
		main.setVisibility(View.VISIBLE);
	}
}