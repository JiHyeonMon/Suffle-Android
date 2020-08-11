package com.example.suffle.ui.Map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.suffle.R
import kotlinx.android.synthetic.main.fragment_map.*
import net.daum.mf.map.api.MapView


class MapFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapView = MapView(activity)

        val mapViewContainer = map_view as ViewGroup

        mapViewContainer.addView(mapView)
    }


}