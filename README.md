# MaterialBanner

## ScreenShot:
![](https://github.com/derohimat/MaterialBannerX/blob/master/screenshot/GIF.gif)


### Attrs
|attr|format|default|
|---|---|---|
|indicatorMargin|dimension|10dp|
|indicatorInside|boolean|true|
|indicatorGravity|flag:left,center,right|left|
|match|boolean|false|


### Gradle:

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
  compile 'com.github.derohimat:MaterialBannerX:1.1.0'
```

XML
```xml
  <com.derohimat.materialbannerx.MaterialBannerX
      android:id="@+id/material_banner"
      android:layout_width="match_parent"
      app:match="true"
      android:layout_height="200dp"/>
```

```java
  MaterialBannerX materialBanner = (MaterialBannerX) findViewById(R.id.material_banner);
  materialBanner.setPages(new SimpleViewHolderCreator(), data)
            .setIndicator(circlePageIndicator);
  //set circle indicator
  materialBanner.setIndicator(new CirclePageIndicator(this));
  //indicators:
  //CirclePageIndicator,IconPageIndicator,LinePageIndicator
  //Custom indicator view needs to implement com.derohimat.materialbannerx.view.indicator.PageIndicator
  
```

[More usage](https://github.com/derohimat/MaterialBannerX/blob/master/app/src/main/java/com/freegeek/android/materialbanner/demo/MainActivity.java)

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
1.Create Holder,[See also SimpleHolder](https://github.com/derohimat/MaterialBannerX/blob/master/lib/src/main/java/com/freegeek/android/materialbanner/simple/SimpleHolder.java)[SimpleBannerData](https://github.com/derohimat/MaterialBannerX/blob/master/lib/src/main/java/com/freegeek/android/materialbanner/simple/SimpleBannerData.java)
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

## Thanks to:

the original one before I migrate to AndroidX 
[MaterialBanner](https://github.com/rtugeek/MaterialBanner)

[Android-ConvenientBanner](https://github.com/saiwu-bigkoo/Android-ConvenientBanner)	
[ViewPagerIndicator](https://github.com/JakeWharton/ViewPagerIndicator)

## License

            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
                    Version 4, December 2018
   
    Copyright (C) 2018 Deni Rohimat <rohimatdeni@gmail.com>
   
    Everyone is permitted to copy and distribute verbatim or modified
    copies of this license document, and changing it is allowed as long
    as the name is changed.
   
            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
    TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
   
     0. You just DO WHAT THE FUCK YOU WANT TO.
