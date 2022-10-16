package io.github.chayanforyou.slider.slidertypes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import io.github.chayanforyou.slider.R;


/**
 * This is a slider with a description TextView.
 */
public class TextSliderView extends BaseSliderView {
    public TextSliderView(Context context) {
        super(context);
    }

    @Override
    public View getView() {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.render_type_text, (ViewGroup) null);
        ImageView target = (ImageView) v.findViewById(R.id.slider_image);
        TextView description = (TextView) v.findViewById(R.id.description);
        description.setText(getDescription());
        bindEventAndShow(v, target);
        return v;
    }
}
