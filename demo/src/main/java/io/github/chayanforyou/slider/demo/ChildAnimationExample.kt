package io.github.chayanforyou.slider.demo

import android.animation.ObjectAnimator
import android.util.Log
import android.view.View
import io.github.chayanforyou.slider.R
import io.github.chayanforyou.slider.animations.BaseAnimationInterface

/**
 * Created by Chayan on 10/14/2022.
 */
class ChildAnimationExample : BaseAnimationInterface {

    override fun onPrepareCurrentItemLeaveScreen(current: View?) {
        current?.let {
            val descriptionLayout = it.findViewById<View>(R.id.description_layout)
            descriptionLayout.visibility = View.INVISIBLE
        }
        Log.e(TAG, "onPrepareCurrentItemLeaveScreen called")
    }

    override fun onPrepareNextItemShowInScreen(next: View?) {
        next?.let {
            val descriptionLayout = it.findViewById<View>(R.id.description_layout)
            descriptionLayout.visibility = View.INVISIBLE
        }
        Log.e(TAG, "onPrepareNextItemShowInScreen called")
    }

    override fun onCurrentItemDisappear(view: View?) {
        Log.e(TAG, "onCurrentItemDisappear called")
    }

    override fun onNextItemAppear(view: View?) {
        view?.let {
            val descriptionLayout = it.findViewById<View>(R.id.description_layout)
            descriptionLayout.visibility = View.VISIBLE
            ObjectAnimator.ofFloat(descriptionLayout, "y", -descriptionLayout.height.toFloat(), 0f)
                .setDuration(500)
                .start()
        }
        Log.e(TAG, "onCurrentItemDisappear called")
    }

    companion object {
        private const val TAG = "ChildAnimationExample"
    }
}