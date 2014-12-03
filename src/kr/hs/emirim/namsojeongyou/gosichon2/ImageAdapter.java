package kr.hs.emirim.namsojeongyou.gosichon2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageAdapter extends PagerAdapter {
	Context context;
	int position;
	
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
			R.drawable.bcupdang_e, R.drawable.bcupdang_f, R.drawable.bcupdang_f };

	int stores1[][] = { soondae1, momoami1, back1, bonggusu1, ssagun1,
			amasbin1, yejjajang1, chamjjajang1, tomato1, pigmalion1, alchon1,
			babaffle1, bubblytea1, cafelavingne1, thebasak1, thebcup1 };
	
	
	ImageAdapter(Context context, int position) {
		this.context = context;
		this.position=position;
	}
	
	@Override
	public int getCount() {

		return stores1[position].length;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == ((ImageView) object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		
		ImageView imageView = new ImageView(context);
		// int padding =
		// context.getResources().getDimensionPixelSize(R.dimen.padding_medium);
		// imageView.setPadding(padding, padding, padding, padding);
		imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
  
//		for(int i=0; i<stores1[this.position].length; i++){
		imageView.setImageResource(stores1[this.position][position]);
		
//		 }

		((ViewPager) container).addView(imageView, 0);
		return imageView;
	}

	@Override
	public void destroyItem(ViewGroup container, int position2, Object object) {
		((ViewPager) container).removeView((ImageView) object);
	}
}