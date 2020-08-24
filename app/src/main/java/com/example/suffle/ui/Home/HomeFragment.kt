package com.example.suffle.ui.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.suffle.R
import com.example.suffle.data.MainRecommandData
import com.example.suffle.data.PlaceData
import com.example.suffle.ui.Home.Alert.AlertActivity
import kotlinx.android.synthetic.main.bottom_sheet_food.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home_content.*


class HomeFragment : Fragment() {

    var food = false
    var cafe = false
    var drink = false

    val placeDatas = mutableListOf<PlaceData>()
    val recommandDatas = mutableListOf<MainRecommandData>()
    var tmp = 0
    lateinit var placeLinearAdapter: PlaceLinearAdapter
    lateinit var placeGridAdapter: PlaceGridAdapter
    lateinit var recommandAdapter: RecommandAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        frag_home_btn_alert.setOnClickListener {
            val intent = Intent(context, AlertActivity::class.java)
            startActivity(intent)
        }

        placeDatas.clear()

        // initialize as invisible (could also do in xml)
        bottom_sheet_food.visibility = View.INVISIBLE
        bottom_sheet_cafe.visibility = View.INVISIBLE
        bottom_sheet_drink.visibility = View.INVISIBLE

        bottom_sheet_food_txt_kinds1.isSelected = false
        bottom_sheet_food_txt_kinds2.isSelected = false
        bottom_sheet_food_txt_kinds3.isSelected = false
        bottom_sheet_food_txt_kinds4.isSelected = false
        bottom_sheet_food_txt_kinds5.isSelected = false
        bottom_sheet_food_txt_kinds6.isSelected = false
        bottom_sheet_food_txt_kinds7.isSelected = false
        bottom_sheet_food_txt_kinds8.isSelected = false
        bottom_sheet_food_txt_kinds9.isSelected = false
        bottom_sheet_food_txt_kinds10.isSelected = false
        bottom_sheet_food_txt_kinds11.isSelected = false

        bottom_sheet_food_txt_theme1.isSelected = false
        bottom_sheet_food_txt_theme2.isSelected = false
        bottom_sheet_food_txt_theme3.isSelected = false
        bottom_sheet_food_txt_theme4.isSelected = false
        bottom_sheet_food_txt_theme5.isSelected = false
        bottom_sheet_food_txt_theme6.isSelected = false
        bottom_sheet_food_txt_theme7.isSelected = false
        bottom_sheet_food_txt_theme8.isSelected = false
        bottom_sheet_food_txt_theme9.isSelected = false
        bottom_sheet_food_txt_theme10.isSelected = false
        bottom_sheet_food_txt_theme11.isSelected = false
        bottom_sheet_food_txt_theme12.isSelected = false


        //Adapter Initialization
        recommandAdapter = RecommandAdapter(view.context)

        placeLinearAdapter = PlaceLinearAdapter(view.context,
            object : PlaceLinearViewHolder.onClickListener {
                override fun onClickItem(position: Int) {
                    Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
                }
            })

        placeGridAdapter = PlaceGridAdapter(view.context,
            object : PlaceGridViewHolder.onClickListener {
                override fun onClickItem(position: Int) {
                    Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
                }
            })

        //attach adapter
        frag_home_rv_recommand.adapter = recommandAdapter
        frag_home_rv_recommand.layoutManager =
            context?.let { CenterZoomLinearLayoutManager(it, 20f, 7f) }

        frag_home_rv_place.adapter = placeLinearAdapter
        frag_home_rv_place.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        //chage layout
        frag_home_btn_layout.setOnClickListener {
            if (tmp == 0) {
                tmp = 1
                placeDatas.clear()
                frag_home_btn_layout.setImageResource(R.drawable.icon_linear_layout)
                frag_home_rv_place.adapter = placeLinearAdapter
                frag_home_rv_place.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                loadPlaceDatas()
            } else {
                tmp = 0
                placeDatas.clear()
                frag_home_btn_layout.setImageResource(R.drawable.icon_grid_layout)
                frag_home_rv_place.layoutManager =
                    GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
                frag_home_rv_place.adapter = placeGridAdapter
                loadPlaceDatas()
            }

        }

        //filter
        frag_home_btn_filter_all.setOnClickListener {
            frag_home_btn_filter_all_bar.visibility = View.VISIBLE
            frag_home_btn_filter_food_bar.visibility = View.INVISIBLE
            frag_home_btn_filter_cafe_bar.visibility = View.INVISIBLE
            frag_home_btn_filter_drink_bar.visibility = View.INVISIBLE

            if (food) {
                food = false; slideDown(bottom_sheet_food)
            }
            if (cafe) {
                cafe = false; slideDown(bottom_sheet_cafe)
            }
            if (drink) {
                drink = false; slideDown(bottom_sheet_drink)
            }
        }

        frag_home_btn_filter_food.setOnClickListener {
            frag_home_btn_filter_all_bar.visibility = View.INVISIBLE
            frag_home_btn_filter_food_bar.visibility = View.VISIBLE
            frag_home_btn_filter_cafe_bar.visibility = View.INVISIBLE
            frag_home_btn_filter_drink_bar.visibility = View.INVISIBLE

            if (cafe) {
                cafe = false; slideDown(bottom_sheet_cafe)
            }
            if (drink) {
                drink = false; slideDown(bottom_sheet_drink)
            }
            food = if (!food) {
                slideUp(bottom_sheet_food); true
            } else {
                slideDown(bottom_sheet_food); false
            }

        }

        frag_home_btn_filter_cafe.setOnClickListener {
            frag_home_btn_filter_all_bar.visibility = View.INVISIBLE
            frag_home_btn_filter_food_bar.visibility = View.INVISIBLE
            frag_home_btn_filter_cafe_bar.visibility = View.VISIBLE
            frag_home_btn_filter_drink_bar.visibility = View.INVISIBLE

            if (food) {
                food = false; slideDown(bottom_sheet_food)
            }
            if (drink) {
                drink = false; slideDown(bottom_sheet_drink)
            }
            cafe = if (!cafe) {
                slideUp(bottom_sheet_cafe); true
            } else {
                slideDown(bottom_sheet_cafe); false
            }
        }

        frag_home_btn_filter_drink.setOnClickListener {
            frag_home_btn_filter_all_bar.visibility = View.INVISIBLE
            frag_home_btn_filter_food_bar.visibility = View.INVISIBLE
            frag_home_btn_filter_cafe_bar.visibility = View.INVISIBLE
            frag_home_btn_filter_drink_bar.visibility = View.VISIBLE

            if (cafe) {
                cafe = false; slideDown(bottom_sheet_cafe)
            }
            if (food) {
                drink = false; slideDown(bottom_sheet_food)
            }
            drink = if (!drink) {
                slideUp(bottom_sheet_drink); true
            } else {
                slideDown(bottom_sheet_drink); false
            }
        }

        frag_home.setOnClickListener {
            Toast.makeText(context, "click", Toast.LENGTH_SHORT).show()
            if (food) {
                food = false; slideDown(bottom_sheet_food)
            }
            if (cafe) {
                cafe = false; slideDown(bottom_sheet_cafe)
            }
            if (drink) {
                drink = false; slideDown(bottom_sheet_drink)
            }
        }

        bottom_sheet_food_txt_kinds1.setOnClickListener {
            bottom_sheet_food_txt_kinds1.isSelected = !bottom_sheet_food_txt_kinds1.isSelected
        }
        bottom_sheet_food_txt_kinds2.setOnClickListener {
            bottom_sheet_food_txt_kinds2.isSelected = !bottom_sheet_food_txt_kinds2.isSelected
        }
        bottom_sheet_food_txt_kinds3.setOnClickListener {
            bottom_sheet_food_txt_kinds3.isSelected = !bottom_sheet_food_txt_kinds3.isSelected
        }
        bottom_sheet_food_txt_kinds4.setOnClickListener {
            bottom_sheet_food_txt_kinds4.isSelected = !bottom_sheet_food_txt_kinds4.isSelected
        }
        bottom_sheet_food_txt_kinds5.setOnClickListener {
            bottom_sheet_food_txt_kinds5.isSelected = !bottom_sheet_food_txt_kinds5.isSelected
        }
        bottom_sheet_food_txt_kinds6.setOnClickListener {
            bottom_sheet_food_txt_kinds6.isSelected = !bottom_sheet_food_txt_kinds6.isSelected
        }
        bottom_sheet_food_txt_kinds7.setOnClickListener {
            bottom_sheet_food_txt_kinds7.isSelected = !bottom_sheet_food_txt_kinds7.isSelected
        }
        bottom_sheet_food_txt_kinds8.setOnClickListener {
            bottom_sheet_food_txt_kinds8.isSelected = !bottom_sheet_food_txt_kinds8.isSelected
        }
        bottom_sheet_food_txt_kinds9.setOnClickListener {
            bottom_sheet_food_txt_kinds9.isSelected = !bottom_sheet_food_txt_kinds9.isSelected
        }
        bottom_sheet_food_txt_kinds10.setOnClickListener {
            bottom_sheet_food_txt_kinds10.isSelected = !bottom_sheet_food_txt_kinds10.isSelected
        }
        bottom_sheet_food_txt_kinds11.setOnClickListener {
            bottom_sheet_food_txt_kinds11.isSelected = !bottom_sheet_food_txt_kinds11.isSelected
        }

        bottom_sheet_food_txt_theme1.setOnClickListener {
            bottom_sheet_food_txt_theme1.isSelected = !bottom_sheet_food_txt_theme1.isSelected
        }
        bottom_sheet_food_txt_theme2.setOnClickListener {
            bottom_sheet_food_txt_theme2.isSelected = !bottom_sheet_food_txt_theme2.isSelected
        }
        bottom_sheet_food_txt_theme3.setOnClickListener {
            bottom_sheet_food_txt_theme3.isSelected = !bottom_sheet_food_txt_theme3.isSelected
        }
        bottom_sheet_food_txt_theme4.setOnClickListener {
            bottom_sheet_food_txt_theme4.isSelected = !bottom_sheet_food_txt_theme4.isSelected
        }
        bottom_sheet_food_txt_theme5.setOnClickListener {
            bottom_sheet_food_txt_theme5.isSelected = !bottom_sheet_food_txt_theme5.isSelected
        }
        bottom_sheet_food_txt_theme6.setOnClickListener {
            bottom_sheet_food_txt_theme6.isSelected = !bottom_sheet_food_txt_theme6.isSelected
        }
        bottom_sheet_food_txt_theme7.setOnClickListener {
            bottom_sheet_food_txt_theme7.isSelected = !bottom_sheet_food_txt_theme7.isSelected
        }
        bottom_sheet_food_txt_theme8.setOnClickListener {
            bottom_sheet_food_txt_theme8.isSelected = !bottom_sheet_food_txt_theme8.isSelected
        }
        bottom_sheet_food_txt_theme9.setOnClickListener {
            bottom_sheet_food_txt_theme9.isSelected = !bottom_sheet_food_txt_theme9.isSelected
        }
        bottom_sheet_food_txt_theme10.setOnClickListener {
            bottom_sheet_food_txt_theme10.isSelected = !bottom_sheet_food_txt_theme10.isSelected
        }
        bottom_sheet_food_txt_theme11.setOnClickListener {
            bottom_sheet_food_txt_theme11.isSelected = !bottom_sheet_food_txt_theme11.isSelected
        }
        bottom_sheet_food_txt_theme12.setOnClickListener {
            bottom_sheet_food_txt_theme12.isSelected = !bottom_sheet_food_txt_theme12.isSelected
        }


        loadPlaceDatas()
        loadRecoDatas()

    }

    private fun loadPlaceDatas() {
        placeDatas.apply {
            add(
                PlaceData(
                    img_place = "https://www.news-paper.co.kr/news/photo/201812/31163_22110_3241.jpg",
                    txt_place = "라라브레드",
                    img_bookmark = false,
                    txt_distance = "1.5km",
                    txt_thumbUp = "김주은외 4,345",
                    txt_thumbDown = "55"
                )
            )
            add(
                PlaceData(
                    img_place = "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSnLXIlflHc2Ck5_YNNYKn5zz4MCG2u5bKvZQ&usqp=CAU",
                    txt_place = "라라브레드",
                    img_bookmark = false,
                    txt_distance = "1.5km",
                    txt_thumbUp = "김주은외 4,345",
                    txt_thumbDown = "55"
                )
            )
            add(
                PlaceData(
                    img_place = "https://www.news-paper.co.kr/news/photo/201812/31163_22110_3241.jpg",
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

        if (frag_home_rv_place.adapter == placeLinearAdapter) {
            placeLinearAdapter.datas = placeDatas
            placeLinearAdapter.notifyDataSetChanged()
        } else {
            placeGridAdapter.datas = placeDatas
            placeGridAdapter.notifyDataSetChanged()
        }
    }

    private fun loadRecoDatas() {
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
        }

        recommandAdapter.datas = recommandDatas
        recommandAdapter.notifyDataSetChanged()
    }

    // slide the view from below itself to the current position
    fun slideUp(view: View) {
        view.visibility = View.VISIBLE
        val animate = TranslateAnimation(
            0F,  // fromXDelta
            0F,  // toXDelta
            view.height.toFloat(),  // fromYDelta
            0F
        ) // toYDelta
        animate.duration = 500
        animate.fillAfter = true
        view.startAnimation(animate)
    }

    // slide the view from its current position to below itself
    fun slideDown(view: View) {
        val animate = TranslateAnimation(
            0F,  // fromXDelta
            0F,  // toXDelta
            0F,  // fromYDelta
            view.height.toFloat()
        ) // toYDelta
        animate.duration = 500
        animate.fillAfter = true
//        animate.setListener(object : AnimatorListenerAdapter() {
//            override fun onAnimationEnd(animation: Animator) {
//                loadingView.visibility = View.GONE
//            }
//        })
        view.startAnimation (animate)
    }



}