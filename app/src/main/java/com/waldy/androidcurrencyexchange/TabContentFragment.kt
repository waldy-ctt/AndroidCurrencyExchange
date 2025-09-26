package com.waldy.androidcurrencyexchange

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class TabContentFragment: Fragment() {
    companion object {
        private const val ARG_TITLE = "tab_title"
        fun newInstance(title: String): TabContentFragment {
            val fragment = TabContentFragment()
            val args = Bundle()
            args.putString(ARG_TITLE, title)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tab_content_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val contentText = arguments?.getString(ARG_TITLE) ?: "Content Error"

        val textView: TextView = view.findViewById<TextView>(R.id.contentTextView)
        textView.text = contentText
    }
}