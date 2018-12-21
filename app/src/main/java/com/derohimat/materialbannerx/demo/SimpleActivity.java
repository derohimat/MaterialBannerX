package com.derohimat.materialbannerx.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.derohimat.materialbannerx.MaterialBannerX;
import com.derohimat.materialbannerx.holder.ViewHolderCreator;
import com.derohimat.materialbannerx.simple.SimpleBannerData;
import com.derohimat.materialbannerx.simple.SimpleHolder;
import com.derohimat.materialbannerx.view.indicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Jack Fu <rtugeek@gmail.com>
 * @date 2018/06/08
 */
public class SimpleActivity extends AppCompatActivity {

    private static int[] images = {R.drawable.home_1,
            R.drawable.home_2,
            R.drawable.home_3,
            R.drawable.home_4,
            R.drawable.home_5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        //init data
        List<SimpleBannerData> simpleBannerData = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            SimpleBannerData data = new SimpleBannerData();
            data.setTitle("Country road " + (i + 1));
            data.setResId(images[i]);
            simpleBannerData.add(data);
        }

        MaterialBannerX materialBannerX = findViewById(R.id.material_banner);
        materialBannerX.setPages(new ViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new SimpleHolder();
            }
        }, simpleBannerData);
        //set indicator
        materialBannerX.setIndicator(new CirclePageIndicator(this));


    }

    public void advanced(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void advanced2(View view) {
        startActivity(new Intent(this, TestActivity.class));
    }
}
