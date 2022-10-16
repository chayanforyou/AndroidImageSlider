package io.github.chayanforyou.slider.demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import io.github.chayanforyou.slider.SliderLayout

/**
 * Created by Chayan on 10/14/2022.
 */
class TransformerAdapter : BaseAdapter() {

    override fun getCount(): Int {
        return SliderLayout.Transformer.values().size
    }

    override fun getItem(position: Int): Any {
        return SliderLayout.Transformer.values()[position].toString()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(parent?.context).inflate(R.layout.item, parent, false)
        val tv = view?.findViewById(R.id.list_item_text) as TextView
        tv.text = getItem(position).toString()
        return view
    }
}