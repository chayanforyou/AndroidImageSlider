package io.github.chayanforyou.slider.demo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import io.github.chayanforyou.slider.SliderLayout
import io.github.chayanforyou.slider.animations.DescriptionAnimation
import io.github.chayanforyou.slider.demo.databinding.ActivityMainBinding
import io.github.chayanforyou.slider.slidertypes.BaseSliderView
import io.github.chayanforyou.slider.slidertypes.TextSliderView
import io.github.chayanforyou.slider.tricks.ViewPagerEx

class MainActivity : AppCompatActivity(), BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

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
                .setOnSliderClickListener(this)

            // add your extra information
            val bundle = bundleOf("name" to name)
            sliderView.bundle(bundle)

            // add SliderView to the SliderLayout
            binding.slider.addSlider(sliderView)
        }
        binding.slider.setDuration(4000)
        binding.slider.setCustomAnimation(DescriptionAnimation())
        binding.slider.setPresetTransformer(SliderLayout.Transformer.Accordion)
        binding.slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
        binding.slider.addOnPageChangeListener(this)

        // preset transformers and their names
        binding.transformers.adapter = TransformerAdapter()
        binding.transformers.onItemClickListener = AdapterView.OnItemClickListener { _, view, _, _ ->
            binding.slider.setPresetTransformer((view as TextView).text.toString())
            Toast.makeText(this@MainActivity, view.text.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        binding.slider.stopAutoCycle()
        super.onDestroy()
    }

    override fun onSliderClick(slider: BaseSliderView?) {
        Toast.makeText(this@MainActivity, slider?.bundle?.getString("name"), Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_custom_indicator -> {
                binding.slider.setCustomIndicator(binding.customIndicator)
            }
            R.id.action_custom_child_animation -> {
                binding.slider.setCustomAnimation(ChildAnimationExample())
            }
            R.id.action_restore_default -> {
                binding.slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
                binding.slider.setCustomAnimation(DescriptionAnimation())
            }
            R.id.action_github -> {
                val browserIntent =
                    Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/chayanforyou/AndroidImageSlider"))
                startActivity(browserIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

    override fun onPageSelected(position: Int) {
        Log.d("SliderDemo", "Page Changed: $position")
    }

    override fun onPageScrollStateChanged(state: Int) {}
}