package io.github.chayanforyou.slider.animations;

import android.animation.ObjectAnimator;
import android.view.View;

import io.github.chayanforyou.slider.R;
import io.github.chayanforyou.slider.tricks.ViewPagerEx;


/**
 * A demo class to show how to use {@link BaseAnimationInterface}
 * to make  your custom animation in {@link ViewPagerEx.PageTransformer} action.
 */
public class DescriptionAnimation implements BaseAnimationInterface {

    @Override
    public void onPrepareCurrentItemLeaveScreen(View current) {
        View descriptionLayout = current.findViewById(R.id.description_layout);
        if (descriptionLayout != null) {
            descriptionLayout.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * When next item is coming to show, let's hide the description layout.
     *
     * @param next
     */
    @Override
    public void onPrepareNextItemShowInScreen(View next) {
        View descriptionLayout = next.findViewById(R.id.description_layout);
        if (descriptionLayout != null) {
            descriptionLayout.setVisibility(View.INVISIBLE);
        }
    }


    @Override
    public void onCurrentItemDisappear(View view) {

    }

    /**
     * When next item show in ViewPagerEx, let's make an animation to show the
     * description layout.
     *
     * @param view
     */
    @Override
    public void onNextItemAppear(View view) {
        View descriptionLayout = view.findViewById(R.id.description_layout);
        if (descriptionLayout != null) {
            descriptionLayout.setVisibility(View.VISIBLE);

            float layoutY = descriptionLayout.getY();
            ObjectAnimator.ofFloat(descriptionLayout, "y",
                            layoutY + descriptionLayout.getHeight(), layoutY)
                    .setDuration(500)
                    .start();
        }
    }
}
