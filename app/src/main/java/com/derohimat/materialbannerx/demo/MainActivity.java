package com.derohimat.materialbannerx.demo;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.derohimat.materialbannerx.IndicatorGravity;
import com.derohimat.materialbannerx.MaterialBannerX;
import com.derohimat.materialbannerx.simple.SimpleBannerData;
import com.derohimat.materialbannerx.simple.SimpleViewHolderCreator;
import com.derohimat.materialbannerx.view.indicator.CirclePageIndicator;
import com.derohimat.materialbannerx.view.indicator.IconPageIndicator;
import com.derohimat.materialbannerx.view.indicator.LinePageIndicator;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

/**
 * @author Jack Fu <rtugeek@gmail.com>
 * @date 2018/06/08
 */
public class MainActivity extends AppCompatActivity {
    private static int[] images = {R.drawable.home_1,
            R.drawable.home_2,
            R.drawable.home_3,
            R.drawable.home_4,
            R.drawable.home_5};
    List<SimpleBannerData> list = new ArrayList<>();
    List<Integer> icons = new ArrayList<>();
    int index = 0;
    int gravity = 0;
    private int[] iconIds = new int[]{android.R.drawable.ic_menu_camera,
            android.R.drawable.ic_menu_gallery,
            android.R.drawable.ic_menu_call,
            android.R.drawable.ic_menu_close_clear_cancel,
            android.R.drawable.ic_dialog_map};
    private MaterialBannerX<SimpleBannerData> materialBannerX;
    private TextView textView;
    private CirclePageIndicator circlePageIndicator;
    private LinePageIndicator linePageIndicator;
    private IconPageIndicator iconPageIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        materialBannerX = findViewById(R.id.material_banner);
        textView = findViewById(R.id.hometown);

        initIndicator();
        initData();

        materialBannerX.setPages(new SimpleViewHolderCreator(), list)
                .setIndicator(circlePageIndicator);

        materialBannerX.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onPageSelected(int position) {
                textView.setText("My hometown: page " + ++position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //iconPageIndicator request these icons
        materialBannerX.getAdapter().setIcons(icons);

        materialBannerX.setOnItemClickListener(new MaterialBannerX.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, "click:" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initIndicator() {
        circlePageIndicator = new CirclePageIndicator(this);
        circlePageIndicator.setStrokeColor(Color.WHITE);
        circlePageIndicator.setFillColor(Color.WHITE);
        circlePageIndicator.setRadius(MaterialBannerX.dip2Pix(this, 3));
        circlePageIndicator.setBetween(20);

        linePageIndicator = new LinePageIndicator(this);
        linePageIndicator.setUnselectedColor(Color.WHITE);
        linePageIndicator.setSelectedColor(Color.YELLOW);

        iconPageIndicator = new IconPageIndicator(this);
    }

    private void initData() {
        for (int i = 0; i < images.length; i++) {
            SimpleBannerData simpleBannerData = new SimpleBannerData();
            simpleBannerData.setTitle("Country road " + (i + 1));
            simpleBannerData.setResId(images[i]);
            list.add(simpleBannerData);
            icons.add(iconIds[i]);
        }
    }

    public void changeInside(View view) {
        materialBannerX.setIndicatorInside(!materialBannerX.isIndicatorInside());
    }

    public void changeType(View view) {
        switch (index % 3) {
            case 2:
                Toast.makeText(this, "set CirclePageIndicator", Toast.LENGTH_SHORT).show();
                materialBannerX.setIndicator(circlePageIndicator);
                break;
            case 1:
                Toast.makeText(this, "set LinePageIndicator", Toast.LENGTH_SHORT).show();
                materialBannerX.setIndicator(linePageIndicator);
                break;
            default:
                Toast.makeText(this, "set IconPageIndicator", Toast.LENGTH_SHORT).show();
                materialBannerX.setIndicator(iconPageIndicator);
                break;

        }
        index++;
    }

    public void changeGravity(View view) {
        IndicatorGravity indicatorGravity = IndicatorGravity.valueOf(gravity);
        Toast.makeText(this, "gravity:" + indicatorGravity, Toast.LENGTH_SHORT).show();
        materialBannerX.setIndicatorGravity(indicatorGravity);
        gravity++;
    }

    public void changeMatch(View view) {
        materialBannerX.setMatch(!materialBannerX.isMatch());
    }

    public void changeTransformer(View view) {
        materialBannerX.setTransformer(new DepthPageTransformer());
    }


    public void turning(View view) {
        if (materialBannerX.isTurning()) {
            materialBannerX.stopTurning();
            Toast.makeText(this, "stop turning", Toast.LENGTH_SHORT).show();
        } else {
            materialBannerX.startTurning(3000);
            Toast.makeText(this, "start turning", Toast.LENGTH_SHORT).show();
        }

    }

}
