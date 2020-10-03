//
//package com.example.suffle.ui.Map
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.widget.ImageView
//import com.example.suffle.R
//import net.daum.mf.map.api.CalloutBalloonAdapter
//import net.daum.mf.map.api.MapPOIItem
//
//// CalloutBalloonAdapter 인터페이스 구현
//class CustomCalloutBalloonAdapter(context: Context) : CalloutBalloonAdapter {
//
//    val mCalloutBalloon = LayoutInflater.from(context).inflate(R.layout.custom_callout_balloon, parent, false)
//
//
//    override fun getPressedCalloutBalloon(p0: MapPOIItem?): View? {
//        return null
//    }
//
//    override fun getCalloutBalloon(mapPOIItem: MapPOIItem): View {
//        val txt_storeName = mCalloutBalloon.findViewById<ImageView>(R.id.frag_map_txt_marker_storeName)
//        txt_storeName.text
//
//    }
//
//
//
////    public CustomCalloutBalloonAdapter() {
////        val mCalloutBalloon = LayoutInflater.inflate(this, R.layout.fragment_map, false)
////    }
////
////    override fun getPressedCalloutBalloon(p0: MapPOIItem?): View? {
////        return null
////    }
////
////    override fun getCalloutBalloon(p0: MapPOIItem?): View {
////        ((ImageView) mCalloutBalloon.findViewById(R.id.badge)).setImageResource(R.drawable.ic_launcher);
////        ((TextView) mCalloutBalloon.findViewById(R.id.title)).setText(poiItem.getItemName());
////        ((TextView) mCalloutBalloon.findViewById(R.id.desc)).setText("Custom CalloutBalloon");
////        return mCalloutBalloon;    }
//}
//
////@Override
////protected void onCreate(Bundle savedInstanceState) {
////    ...
////    // 구현한 CalloutBalloonAdapter 등록
////    mMapView.setCalloutBalloonAdapter(new CustomCalloutBalloonAdapter());
////    ...
////}
