package com.example.suffle.ui.Home.location

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.suffle.R
import com.example.suffle.data.SubwayData
import kotlinx.android.synthetic.main.activity_location.*
import kotlinx.android.synthetic.main.fragment_subway.*

class SubwayFragment : Fragment() {

    companion object {
        const val KEY = "key"
        fun newInstance(data: String) = SubwayFragment().apply {
            arguments = Bundle().apply {
                putString(KEY, data)
            }
        }
    }

    val receiveData by lazy { requireArguments().getString(KEY) }

    val subwayData = arrayListOf(
        SubwayData("6", "화랑대"),
        SubwayData("6", "태릉입구"),
        SubwayData("4", "노원"),
        SubwayData("1", "석계"),
        SubwayData("6", "중계"),
        SubwayData("4", "수유"),
        SubwayData("6", "하계"),
        SubwayData("6", "월곡"),
        SubwayData("6", "안암"),
        SubwayData("6", "돌곶이"),
        SubwayData("6", "봉화산"),
        SubwayData("7", "공릉")

    )

    val subwayData1 = arrayListOf(
        SubwayData("1", "석계"),
        SubwayData("1", "석계"),
        SubwayData("1", "석계"),
        SubwayData("1", "석계"),
        SubwayData("1", "석계"),
        SubwayData("1", "석계"),
        SubwayData("1", "석계"),
        SubwayData("1", "석계")
    )

    val subwayData2 = arrayListOf(
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구")
    )

    val subwayData4 = arrayListOf(
        SubwayData("4", "서울역")
    )


    private lateinit var locationAdapter: LocationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_subway, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        locationAdapter = LocationAdapter(view.context,
            object : LocationViewHolder.onClickListener {
                override fun onClickItem(position: Int) {

                }
            })

        frag_subway_rv.adapter = locationAdapter
        frag_subway_rv.layoutManager = GridLayoutManager(context, 4)

        when(receiveData){
            "my"->{ locationAdapter.datas = subwayData; locationAdapter.notifyDataSetChanged()}
            "hot" -> { locationAdapter.datas = subwayData1; locationAdapter.notifyDataSetChanged()}
            "1"->{ locationAdapter.datas = subwayData2; locationAdapter.notifyDataSetChanged()}
            "2"->{ locationAdapter.datas = subwayData4; locationAdapter.notifyDataSetChanged()}
            "3"->{ locationAdapter.datas = subwayData1; locationAdapter.notifyDataSetChanged()}
            else ->{ locationAdapter.datas = subwayData; locationAdapter.notifyDataSetChanged()}
        }

//        locationAdapter.datas = subwayData
        locationAdapter.notifyDataSetChanged()

    }

}