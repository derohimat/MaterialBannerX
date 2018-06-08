# MaterialBanner

## ScreenShot:
![](https://github.com/rtugeek/MaterialBanner/blob/master/screenshot/GIF.gif)


## Idea from Google Trips:
![](https://github.com/rtugeek/MaterialBanner/blob/master/screenshot/googletrips.jpg)


##[Demo APK](https://github.com/rtugeek/MaterialBanner/releases/download/1.0.0/Demo.apk)

### Attrs
|attr|format|default|
|---|---|---|
|indicatorMargin|dimension|10dp|
|indicatorInside|boolean|true|
|indicatorGravity|flag:left,center,right|left|
|match|boolean|false|


### Gradle:
[![](https://jitpack.io/v/rtugeek/materialbanner.svg)](https://jitpack.io/#rtugeek/materialbanner) [![API](https://img.shields.io/badge/API-8%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=9) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-MaterialBanner-green.svg?style=true)](https://android-arsenal.com/details/1/3118)

Step 1. Add the JitPack repository in your root build.gradle at the end of repositories:
```
  allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```
Step 2. Add the dependency
```
  compile 'com.github.rtugeek:materialbanner:1.0.2'
```

XML
```xml
  <com.freegeek.android.materialbanner.MaterialBanner
      android:id="@+id/material_banner"
      android:layout_width="match_parent"
      app:match="true"
      android:layout_height="200dp"/>
```

```java
  MaterialBanner materialBanner = (MaterialBanner) findViewById(R.id.material_banner);
  materialBanner.setPages(new SimpleViewHolderCreator(), data)
            .setIndicator(circlePageIndicator);
  //set circle indicator
  materialBanner.setIndicator(new CirclePageIndicator(this));
  //indicators:
  //CirclePageIndicator,IconPageIndicator,LinePageIndicator
  //Custom indicator view needs to implement com.freegeek.android.materialbanner.view.indicator.PageIndicator
  
```

[More usage](https://github.com/rtugeek/MaterialBanner/blob/master/app/src/main/java/com/freegeek/android/materialbanner/demo/MainActivity.java)

Listener
```java
  
  materialBanner.setOnItemClickListener(new MaterialBanner.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                
            }
        });
  
  materialBanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                textView.setText("My hometown: page " + ++position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        
        
```

### Customize
1.Create Holder,[See also SimpleHolder](https://github.com/rtugeek/MaterialBanner/blob/master/lib/src/main/java/com/freegeek/android/materialbanner/simple/SimpleHolder.java)[SimpleBannerData](https://github.com/rtugeek/MaterialBanner/blob/master/lib/src/main/java/com/freegeek/android/materialbanner/simple/SimpleBannerData.java)
```java
public class YourHolder implements Holder<YourData> {

    @Override
    public View createView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.simple_banner_item,null);
        //init your view here
        return view;
    }

    @Override
    public void updateUI(Context context, int position, YourData data) {
        //update your view here
    }

}

```
2.Create HolderCreator
```java
public class YourHolderCreator implements ViewHolderCreator{

    @Override
    public YourHolder createHolder() {
        return new YourHolder();
    }

}
```
3.Set your creator
```java
materialBanner.setPages(new YourHolderCreator(), list);
```



**Spread the word**

<a href="https://twitter.com/intent/tweet?text=Check%20out%20the%MaterialBanner%20library%20on%20Github:%20https://github.com/rtugeek/MaterialBanner/" target="_blank" title="share to twitter" style="width:100%"><img src="https://github.com/PhilJay/MPAndroidChart/blob/master/design/twitter_icon.png" title="Share on Twitter" width="35" height=35 />
<a href="https://plus.google.com/share?url=https://github.com/rtugeek/MaterialBanner/" target="_blank" title="share to Google+" style="width:100%"><img src="https://github.com/PhilJay/MPAndroidChart/blob/master/design/googleplus_icon.png" title="Share on Google+" width="35" height=35 />
<a href="https://www.facebook.com/sharer/sharer.php?u=https://github.com/rtugeek/MaterialBanner/" target="_blank" title="share to facebook" style="width:100%"><img src="https://github.com/PhilJay/MPAndroidChart/blob/master/design/facebook_icon.png" title="Share on Facebook" width="35" height=35 />

## Thanks to:
[Android-ConvenientBanner](https://github.com/saiwu-bigkoo/Android-ConvenientBanner)	
[ViewPagerIndicator](https://github.com/JakeWharton/ViewPagerIndicator)

## License

            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
                    Version 2, December 2004
   
    Copyright (C) 2004 Jack Fu <rtugeek@gmail.com>
   
    Everyone is permitted to copy and distribute verbatim or modified
    copies of this license document, and changing it is allowed as long
    as the name is changed.
   
            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
    TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
   
     0. You just DO WHAT THE FUCK YOU WANT TO.
