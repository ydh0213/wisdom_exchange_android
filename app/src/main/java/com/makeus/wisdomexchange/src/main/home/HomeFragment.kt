package com.makeus.wisdomexchange.src.main.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.makeus.wisdomexchange.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }

    private fun initView(view: View) {
        val sortedBySpinnerList = arrayListOf(
            getString(R.string.kr_sort_by_newest),
            getString(R.string.kr_sort_by_hottest),
            getString(R.string.kr_sort_by_reviews))
        val sortedBySpinnerAdapter = SortedBySpinnerAdapter(context!!,
            R.layout.support_simple_spinner_dropdown_item, sortedBySpinnerList)
        spinner_sorted_by.adapter = sortedBySpinnerAdapter
    }

    class SortedBySpinnerAdapter(context: Context, resource: Int, objects: MutableList<String>) :
        ArrayAdapter<String>(context, resource, objects) {
        override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = super.getDropDownView(position, convertView, parent)
            if (view is TextView)
                view.setTextColor(view.getContext().resources.getColor(R.color.black,
                    dropDownViewTheme))
            return view
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = super.getView(position, convertView, parent)
            if (view is TextView)
                view.setTextColor(view.getContext().resources.getColor(R.color.black,
                    dropDownViewTheme))
            return view
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}