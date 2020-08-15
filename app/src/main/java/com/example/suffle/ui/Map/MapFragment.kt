package com.example.suffle.ui.Map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.suffle.R
import com.example.suffle.data.PersonListData
import com.example.suffle.data.PlaceData
import kotlinx.android.synthetic.main.bottom_sheet_behavior.*
import kotlinx.android.synthetic.main.fragment_map_content.*
import net.daum.mf.map.api.MapView


class MapFragment : Fragment() {

    val placeDatas = mutableListOf<PlaceData>()
    lateinit var mapPlaceAdapter: MapPlaceAdapter
    val personDatas = mutableListOf<PersonListData>()
    lateinit var mapPersonAdapter: MapPersonAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //지도 띄우기
//        val mapView = MapView(activity)
//        val mapViewContainer = map_view as ViewGroup
//        mapViewContainer.addView(mapView)

        mapPlaceAdapter = MapPlaceAdapter(view.context,
            object : MapPlaceViewHolder.onClickListener {
                override fun onClickItem(position: Int) {
                    Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
                }
            })

        mapPersonAdapter = MapPersonAdapter(view.context,
        object : MapPersonViewHolder.onClickListener{
            override fun onClickItem(position: Int) {
                Toast.makeText(context, personDatas[position].txt_personName, Toast.LENGTH_SHORT).show()
            }

        })

        bottom_sheet_rv_place.adapter = mapPlaceAdapter
        bottom_sheet_rv_place.setLayoutManager(LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));

        loadDatas1()
        loadDatas2()
    }

    private fun loadDatas1(){
        personDatas.apply {
            add(
                PersonListData(
                    img_person = "R.drawable.kakao_circle1",
                    txt_personName = "홍길동"
                )
            )
            add(
                PersonListData(
                    img_person = "R.drawable.kakao_circle2",
                    txt_personName = "홍길동"
                )
            )
            add(
                PersonListData(
                    img_person = "R.drawable.kakao_circle3",
                    txt_personName = "홍길동"
                )
            )
            add(
                PersonListData(
                    img_person = "R.drawable.kakao_circle4",
                    txt_personName = "홍길동"
                )
            )
            add(
                PersonListData(
                    img_person = "R.drawable.kakao_circle5",
                    txt_personName = "홍길동"
                )
            )
        }

    }

    private fun loadDatas2(){

        placeDatas.apply {
            add(
                PlaceData(
                    txt_place = "라라브레드",
                    img_bookmark = false,
                    txt_distance = "1.5km",
                    txt_thumbUp = "김주은외 4,345",
                    txt_thumbDown = "55"
                )
            )
            add(
                PlaceData(
                    txt_place = "라라브레드",
                    img_bookmark = false,
                    txt_distance = "1.5km",
                    txt_thumbUp = "김주은외 4,345",
                    txt_thumbDown = "55"
                )
            )
            add(
                PlaceData(
                    txt_place = "라라브레드",
                    img_bookmark = false,
                    txt_distance = "1.5km",
                    txt_thumbUp = "김주은외 4,345",
                    txt_thumbDown = "55"
                )
            )
            add(
                PlaceData(
                    txt_place = "라라브레드",
                    img_bookmark = false,
                    txt_distance = "1.5km",
                    txt_thumbUp = "김주은외 4,345",
                    txt_thumbDown = "55"
                )
            )
        }

        mapPlaceAdapter.datas = placeDatas
        mapPlaceAdapter.notifyDataSetChanged()

    }

}