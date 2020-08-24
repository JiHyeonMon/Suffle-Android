package com.example.suffle.ui.Feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.fragment.app.Fragment
import com.example.suffle.R
import kotlinx.android.synthetic.main.fragment_feed.*


class FeedFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myseek = view.findViewById(R.id.seekBar) as SeekBar
        seekBar.max = 5


        myseek.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onProgressChanged(
                seekBar: SeekBar,
                progress: Int,
                fromUser: Boolean
            ) {
                if (fromUser) {
                    if (progress >= 0 && progress <= myseek.max) {
                        val progressString = (progress).toString()
                        seekbar_txt.text = progressString // the TextView Reference
                        seekBar.secondaryProgress = progress
                    }
                }
            }
        })
    }


}