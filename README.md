# Android Image Slider

Forked from https://github.com/daimajia/AndroidImageSlider which was getting very old. I needed to get a project working that had used this a while back but was now incompatible with modern build tools and android libs.

---

This is an amazing image slider for the Android platform. I decided to open source this because there is really not an attractive, convenient slider widget in Android.
 
You can easily load images from an internet URL, drawable, or file. And there are many kinds of amazing animations you can choose. 😀
 
## Demo
 
![](https://raw.githubusercontent.com/chayanforyou/AndroidImageSlider/master/demo.gif)

## Setup

```groovy
dependencies {
    implementation 'io.github.chayanforyou:slider:1.0.0'
}
```

## Usage

- Add the Slider to your **layout**:
 
```xml
<io.github.chayanforyou.slider.SliderLayout
    android:id="@+id/slider"
    android:layout_width="match_parent"
    android:layout_height="200dp"
    app:auto_cycle="true"
    app:indicator_visibility="visible"
    app:pager_animation="Accordion"
    app:pager_animation_span="1100" />
```

- If you want to use **custom indicator**:
 
```xml
<io.github.chayanforyou.slider.indicators.PagerIndicator
    android:id="@+id/custom_indicator"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_alignParentBottom="true"
    android:layout_centerHorizontal="true"
    android:layout_marginBottom="20dp"
    android:gravity="center"
    app:selected_color="#0095BF"
    app:selected_drawable="@drawable/bird"
    app:selected_height="6dp"
    app:selected_padding_left="5dp"
    app:selected_padding_right="5dp"
    app:selected_width="6dp"
    app:shape="oval"
    app:unselected_color="#55333333"
    app:unselected_height="6dp"
    app:unselected_padding_left="5dp"
    app:unselected_padding_right="5dp"
    app:unselected_width="6dp" />
```

- You can change indicators

```
app:selected_drawable="@drawable/selected_dot"
app:unselected_drawable="@drawable/unselected_dot"
```

- Add Slider to your **activity**

```kotlin

//val urlMaps = HashMap<String, String>()
//urlMaps["Hannibal"] = "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg"
//urlMaps["Big Bang Theory"] = "http://tvfiles.alphacoders.com/100/hdclearart-10.png"
//urlMaps["House of Cards"] = "http://cdn3.nflximg.net/images/3093/2043093.jpg"
//urlMaps["Game of Thrones"] = "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg"

val fileMaps: HashMap<String, Int> = HashMap()
fileMaps["Hannibal"] = R.drawable.hannibal
fileMaps["Big Bang Theory"] = R.drawable.bigbang
fileMaps["House of Cards"] = R.drawable.house
fileMaps["Game of Thrones"] = R.drawable.game_of_thrones

for (name in fileMaps.keys) {
    val sliderView = TextSliderView(this)

    // initialize a SliderLayout
    sliderView.description(name)
        .image(fileMaps[name]!!)
        .setScaleType(BaseSliderView.ScaleType.Fit)

    // add SliderView to the SliderLayout
    mDemoSlider.addSlider(sliderView)
}
mDemoSlider.setDuration(4000)
mDemoSlider.setCustomAnimation(DescriptionAnimation())
bmDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion)
mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
```

- You can use click listener

```kotlin
sliderView.setOnSliderClickListener(object : BaseSliderView.OnSliderClickListener {
    override fun onSliderClick(slider: BaseSliderView?) {
        // You can listen here
    }
})
```

- You can add stop and start auto sliding again

```kotlin
mDemoSlider.startAutoCycle(4000, 4000, true)
mDemoSlider.startAutoCycle()
mDemoSlider.stopAutoCycle()
```

[Code example](https://github.com/chayanforyou/AndroidImageSlider/blob/master/demo/src/main/java/io/github/chayanforyou/slider/demo/MainActivity.kt)

[Layout example](https://github.com/chayanforyou/AndroidImageSlider/blob/master/demo/src/main/res/layout/activity_main.xml)
 
====
 
## Advanced usage

Please visit [Wiki](https://github.com/daimajia/AndroidImageSlider/wiki)
 
## Thanks

- [Picasso](https://github.com/square/picasso)
- [ViewPagerTransforms](https://github.com/ToxicBakery/ViewPagerTransforms)

