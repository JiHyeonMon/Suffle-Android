package com.example.suffle.ui.Home.search.search2.resultImage

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.suffle.R
import com.example.suffle.data.MainRecommandData
import kotlinx.android.synthetic.main.fragment_search_result_image.*

class SearchResultImageFragment : Fragment() {

    lateinit var searchResultImageAdapter: SearchResultImageAdapter
    val recommandDatas = mutableListOf<MainRecommandData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_result_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchResultImageAdapter = SearchResultImageAdapter(view.context)

        frag_search_result_img_rv.adapter = searchResultImageAdapter
        val layout = GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
        frag_search_result_img_rv.layoutManager = layout
        layout.isAutoMeasureEnabled
        frag_search_result_img_rv.isNestedScrollingEnabled

        loadDatas()

        frag_search_result_img_rv.setOnClickListener {
            Toast.makeText(context, "frag_search_rv", Toast.LENGTH_SHORT).show()
        }

    }

    private fun loadDatas() {
        recommandDatas.apply {
            add(
                MainRecommandData(
                    img_food = "https://www.news-paper.co.kr/news/photo/201812/31163_22110_3241.jpg",
                    img_person = "https://pbs.twimg.com/profile_images/703183198994300929/rOKqCVxP_400x400.jpg",
                    txt_personName = "김주은",
                    txt_storeName = "라라브레드 본점"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTzpVcohQXEOWD0G-dDY21o0i_NVkEQg-eeFw&usqp=CAU",
                    img_person = "https://t1.daumcdn.net/cfile/tistory/264B673A5657B83318",
                    txt_personName = "김지현",
                    txt_storeName = "고추바사삭 대존맛"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://t1.daumcdn.net/cfile/tistory/9966E24F5C1F47CA12",
                    img_person = "https://pbs.twimg.com/profile_images/703183198994300929/rOKqCVxP_400x400.jpg",
                    txt_personName = "장윤주",
                    txt_storeName = "윤주집 밥집 대존맛탱구리"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://www.news-paper.co.kr/news/photo/201812/31163_22110_3241.jpg",
                    img_person = "https://pbs.twimg.com/profile_images/703183198994300929/rOKqCVxP_400x400.jpg",
                    txt_personName = "김주은",
                    txt_storeName = "라라브레드 본점"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTzpVcohQXEOWD0G-dDY21o0i_NVkEQg-eeFw&usqp=CAU",
                    img_person = "https://t1.daumcdn.net/cfile/tistory/264B673A5657B83318",
                    txt_personName = "김지현",
                    txt_storeName = "고추바사삭 대존맛"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://t1.daumcdn.net/cfile/tistory/9966E24F5C1F47CA12",
                    img_person = "https://pbs.twimg.com/profile_images/703183198994300929/rOKqCVxP_400x400.jpg",
                    txt_personName = "장윤주",
                    txt_storeName = "윤주집 밥집 대존맛탱구리"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://www.news-paper.co.kr/news/photo/201812/31163_22110_3241.jpg",
                    img_person = "https://pbs.twimg.com/profile_images/703183198994300929/rOKqCVxP_400x400.jpg",
                    txt_personName = "김주은",
                    txt_storeName = "라라브레드 본점"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTzpVcohQXEOWD0G-dDY21o0i_NVkEQg-eeFw&usqp=CAU",
                    img_person = "https://t1.daumcdn.net/cfile/tistory/264B673A5657B83318",
                    txt_personName = "김지현",
                    txt_storeName = "고추바사삭 대존맛"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://t1.daumcdn.net/cfile/tistory/9966E24F5C1F47CA12",
                    img_person = "https://pbs.twimg.com/profile_images/703183198994300929/rOKqCVxP_400x400.jpg",
                    txt_personName = "장윤주",
                    txt_storeName = "윤주집 밥집 대존맛탱구리"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://www.news-paper.co.kr/news/photo/201812/31163_22110_3241.jpg",
                    img_person = "https://pbs.twimg.com/profile_images/703183198994300929/rOKqCVxP_400x400.jpg",
                    txt_personName = "김주은",
                    txt_storeName = "라라브레드 본점"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTzpVcohQXEOWD0G-dDY21o0i_NVkEQg-eeFw&usqp=CAU",
                    img_person = "https://t1.daumcdn.net/cfile/tistory/264B673A5657B83318",
                    txt_personName = "김지현",
                    txt_storeName = "고추바사삭 대존맛"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://t1.daumcdn.net/cfile/tistory/9966E24F5C1F47CA12",
                    img_person = "https://pbs.twimg.com/profile_images/703183198994300929/rOKqCVxP_400x400.jpg",
                    txt_personName = "장윤주",
                    txt_storeName = "윤주집 밥집 대존맛탱구리"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://www.news-paper.co.kr/news/photo/201812/31163_22110_3241.jpg",
                    img_person = "https://pbs.twimg.com/profile_images/703183198994300929/rOKqCVxP_400x400.jpg",
                    txt_personName = "김주은",
                    txt_storeName = "라라브레드 본점"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTzpVcohQXEOWD0G-dDY21o0i_NVkEQg-eeFw&usqp=CAU",
                    img_person = "https://t1.daumcdn.net/cfile/tistory/264B673A5657B83318",
                    txt_personName = "김지현",
                    txt_storeName = "고추바사삭 대존맛"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://t1.daumcdn.net/cfile/tistory/9966E24F5C1F47CA12",
                    img_person = "https://pbs.twimg.com/profile_images/703183198994300929/rOKqCVxP_400x400.jpg",
                    txt_personName = "장윤주",
                    txt_storeName = "윤주집 밥집 대존맛탱구리"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://www.news-paper.co.kr/news/photo/201812/31163_22110_3241.jpg",
                    img_person = "https://pbs.twimg.com/profile_images/703183198994300929/rOKqCVxP_400x400.jpg",
                    txt_personName = "김주은",
                    txt_storeName = "라라브레드 본점"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTzpVcohQXEOWD0G-dDY21o0i_NVkEQg-eeFw&usqp=CAU",
                    img_person = "https://t1.daumcdn.net/cfile/tistory/264B673A5657B83318",
                    txt_personName = "김지현",
                    txt_storeName = "고추바사삭 대존맛"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://t1.daumcdn.net/cfile/tistory/9966E24F5C1F47CA12",
                    img_person = "https://pbs.twimg.com/profile_images/703183198994300929/rOKqCVxP_400x400.jpg",
                    txt_personName = "장윤주",
                    txt_storeName = "윤주집 밥집 대존맛탱구리"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://www.news-paper.co.kr/news/photo/201812/31163_22110_3241.jpg",
                    img_person = "https://pbs.twimg.com/profile_images/703183198994300929/rOKqCVxP_400x400.jpg",
                    txt_personName = "김주은",
                    txt_storeName = "라라브레드 본점"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTzpVcohQXEOWD0G-dDY21o0i_NVkEQg-eeFw&usqp=CAU",
                    img_person = "https://t1.daumcdn.net/cfile/tistory/264B673A5657B83318",
                    txt_personName = "김지현",
                    txt_storeName = "고추바사삭 대존맛"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://t1.daumcdn.net/cfile/tistory/9966E24F5C1F47CA12",
                    img_person = "https://pbs.twimg.com/profile_images/703183198994300929/rOKqCVxP_400x400.jpg",
                    txt_personName = "장윤주",
                    txt_storeName = "윤주집 밥집 대존맛탱구리"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://www.news-paper.co.kr/news/photo/201812/31163_22110_3241.jpg",
                    img_person = "https://pbs.twimg.com/profile_images/703183198994300929/rOKqCVxP_400x400.jpg",
                    txt_personName = "김주은",
                    txt_storeName = "라라브레드 본점"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTzpVcohQXEOWD0G-dDY21o0i_NVkEQg-eeFw&usqp=CAU",
                    img_person = "https://t1.daumcdn.net/cfile/tistory/264B673A5657B83318",
                    txt_personName = "김지현",
                    txt_storeName = "고추바사삭 대존맛"
                )
            )
            add(
                MainRecommandData(
                    img_food = "https://t1.daumcdn.net/cfile/tistory/9966E24F5C1F47CA12",
                    img_person = "https://pbs.twimg.com/profile_images/703183198994300929/rOKqCVxP_400x400.jpg",
                    txt_personName = "장윤주",
                    txt_storeName = "윤주집 밥집 대존맛탱구리"
                )
            )
        }

        searchResultImageAdapter.datas = recommandDatas
        searchResultImageAdapter.notifyDataSetChanged()
    }
}