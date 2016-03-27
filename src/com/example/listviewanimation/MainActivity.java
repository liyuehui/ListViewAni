package com.example.listviewanimation;

import java.util.ArrayList;

import com.example.listviewanimation.ui.ParallaxListView;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.AbsListView.OnScrollListener;

public class MainActivity extends Activity {

	protected static final String TAG = MainActivity.class.getSimpleName();
	private ParallaxListView listView;
	private ArrayList<String> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listView = (ParallaxListView) findViewById(R.id.listView);

		list = new ArrayList<String>();
		list.add("ParallaxText");
		for (int i = 0; i < 10; i++) {
			list.add("text" + i);
		}

		listView.setAdapter(new MyAdapter());
		
	}

	class MyAdapter extends BaseAdapter {
		
		private int HEADER_VIEW = 0;
		private int COM_VIEW = 1;

//		@Override
//		public int getItemViewType(int position) {
//			if(position == 0){
//				return HEADER_VIEW;
//			}
//			return COM_VIEW;
//		}

//		@Override
//		public int getViewTypeCount() {
//			return 2;
//		}

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			View view = null;
//			if (getItemViewType(position) == HEADER_VIEW) {
//				view = View.inflate(MainActivity.this, R.layout.item_header2, null);
//			} else {
				view  = View.inflate(MainActivity.this, R.layout.item_header2, null);
				((TextView)view).setText(list.get(position));
//			}
			view.setMinimumHeight(500);
			return view;
		}

	}
	
	@Override
	protected void onResume() {
		listView.setOnScrollListener(new OnScrollListener() {

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
//				Log.e(TAG, TAG + " scrollState:" + scrollState);

			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//					Log.e(TAG, TAG + " firstVisibleItem:" + firstVisibleItem +" visibleItemCount:"+visibleItemCount+ " totalItemCount:"+totalItemCount);
				if(firstVisibleItem == 0 && listView.getChildAt(0) != null){
					int top = listView.getChildAt(0).getTop();
////					
					Log.e(TAG, TAG + " top:" + top +" "+(float) (-top /1.5));
					if(top != 0){
						listView.getChildAt(0).setTranslationY( (float) (-top /1.5));
					}
				}
			}
		});
		super.onResume();
	}

}
