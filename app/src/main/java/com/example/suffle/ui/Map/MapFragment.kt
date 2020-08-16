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
    val personDatas = mutableListOf<PersonListData>()

    lateinit var mapPlaceAdapter: MapPlaceAdapter
    lateinit var mapPersonAdapter: MapPersonAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_map, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        placeDatas.clear()
        personDatas.clear()
        //지도 띄우기
//        val mapView = MapView(activity)
//        val mapViewContainer = map_view as ViewGroup
//        mapViewContainer.addView(mapView)

        //Adapter Initialization
        mapPersonAdapter = MapPersonAdapter(view.context,
            object : MapPersonViewHolder.onClickListener{
                override fun onClickItem(position: Int) {
                    Toast.makeText(context, personDatas[position].txt_personName, Toast.LENGTH_SHORT).show()
                }

            })
        mapPlaceAdapter = MapPlaceAdapter(view.context,
            object : MapPlaceViewHolder.onClickListener {
                override fun onClickItem(position: Int) {
                    Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
                }
            })

        //Attach adapter to Recyclerview
        bottom_sheet_rv_person.adapter = mapPersonAdapter
        bottom_sheet_rv_person.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        bottom_sheet_rv_place.adapter = mapPlaceAdapter
        bottom_sheet_rv_place.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);

        loadDatas1()
        loadDatas2()
    }

    private fun loadDatas1(){
        personDatas.apply {
            add(
                PersonListData(
                    img_person = "https://blog.kakaocdn.net/dn/bDfAQw/btqD2bD1qbY/KekKgYpWSAZCtsRjQC0kS0/img.jpg",
                    txt_personName = "홍길동"
                )
            )
            add(
                PersonListData(
                    img_person = "https://blog.kakaocdn.net/dn/bDfAQw/btqD2bD1qbY/KekKgYpWSAZCtsRjQC0kS0/img.jpg",
                    txt_personName = "홍길동m"
                )
            )
            add(
                PersonListData(
                    img_person = "https://blog.kakaocdn.net/dn/bDfAQw/btqD2bD1qbY/KekKgYpWSAZCtsRjQC0kS0/img.jpg",
                    txt_personName = "홍길동;"
                )
            )
        }

        mapPersonAdapter.datas = personDatas
        mapPersonAdapter.notifyDataSetChanged()

    }

    private fun loadDatas2(){

        placeDatas.apply {
            add(
                PlaceData(
                    img_place = "https://lh3.googleusercontent.com/proxy/0fSPDWXT8LvpXQsFwlCGm4Amkd3gw-Z-p3v1q-RsrUW1Z1kj7JOpuzOCzbn7Uu_cmqnPTJE1hAXzO2st9vCczfUKqXJiKnhCe1QNHMXT1N0y6C3Nic6_gAazhK2ipj9JsT5DkcSAfYWUIKuKP8riygED8Fzy-N3rHjnTX7Z8ltQJX87A9GPfL6PVW2Ez4_3dZTEZOuq6GRk1Sc50VAtQYqR6h2HpwQv9wJegSKuvmjGYC0Q1tJBQwXo4TjvBqKYkdfOBpx8ZkRZn-5El1i9trdHEF1ne",
                    txt_place = "라라브레드",
                    img_bookmark = false,
                    txt_distance = "1.5km",
                    txt_thumbUp = "김지현외 4,345",
                    txt_thumbDown = "34"
                )
            )
            add(
                PlaceData(
                    img_place = "https://lh3.googleusercontent.com/proxy/0fSPDWXT8LvpXQsFwlCGm4Amkd3gw-Z-p3v1q-RsrUW1Z1kj7JOpuzOCzbn7Uu_cmqnPTJE1hAXzO2st9vCczfUKqXJiKnhCe1QNHMXT1N0y6C3Nic6_gAazhK2ipj9JsT5DkcSAfYWUIKuKP8riygED8Fzy-N3rHjnTX7Z8ltQJX87A9GPfL6PVW2Ez4_3dZTEZOuq6GRk1Sc50VAtQYqR6h2HpwQv9wJegSKuvmjGYC0Q1tJBQwXo4TjvBqKYkdfOBpx8ZkRZn-5El1i9trdHEF1ne",
                    txt_place = "라라브레드",
                    img_bookmark = false,
                    txt_distance = "1.5km",
                    txt_thumbUp = "김주은외 4,345",
                    txt_thumbDown = "55"
                )
            )
            add(
                PlaceData(
                    img_place = "https://lh3.googleusercontent.com/proxy/0fSPDWXT8LvpXQsFwlCGm4Amkd3gw-Z-p3v1q-RsrUW1Z1kj7JOpuzOCzbn7Uu_cmqnPTJE1hAXzO2st9vCczfUKqXJiKnhCe1QNHMXT1N0y6C3Nic6_gAazhK2ipj9JsT5DkcSAfYWUIKuKP8riygED8Fzy-N3rHjnTX7Z8ltQJX87A9GPfL6PVW2Ez4_3dZTEZOuq6GRk1Sc50VAtQYqR6h2HpwQv9wJegSKuvmjGYC0Q1tJBQwXo4TjvBqKYkdfOBpx8ZkRZn-5El1i9trdHEF1ne",
                    txt_place = "라라브레드",
                    img_bookmark = false,
                    txt_distance = "1.5km",
                    txt_thumbUp = "김주은외 4,345",
                    txt_thumbDown = "55"
                )
            )
            add(
                PlaceData(
                    img_place = "https://lh3.googleusercontent.com/proxy/0fSPDWXT8LvpXQsFwlCGm4Amkd3gw-Z-p3v1q-RsrUW1Z1kj7JOpuzOCzbn7Uu_cmqnPTJE1hAXzO2st9vCczfUKqXJiKnhCe1QNHMXT1N0y6C3Nic6_gAazhK2ipj9JsT5DkcSAfYWUIKuKP8riygED8Fzy-N3rHjnTX7Z8ltQJX87A9GPfL6PVW2Ez4_3dZTEZOuq6GRk1Sc50VAtQYqR6h2HpwQv9wJegSKuvmjGYC0Q1tJBQwXo4TjvBqKYkdfOBpx8ZkRZn-5El1i9trdHEF1ne",
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