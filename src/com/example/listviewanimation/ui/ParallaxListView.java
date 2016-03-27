package com.example.listviewanimation.ui;

import com.example.listviewanimation.MainActivity;
import com.example.listviewanimation.R;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AbsListView;
import android.widget.ListView;

public class ParallaxListView extends ListView {

	protected static final String TAG = ParallaxListView.class.getSimpleName();
	public int mHeightFirstView;

	public ParallaxListView(Context context) {
		super(context);
		init();
	}

	public ParallaxListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	private void init() {
		View view = View.inflate(getContext(), R.layout.item_header, null);
		view.setMinimumHeight(500);
		addHeaderView(view);
	}

	@Override
	protected void onFinishInflate() {
		

		getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			
			@Override
			public void onGlobalLayout() {
				mHeightFirstView = getChildAt(0).getMeasuredHeight();
				if(mHeightFirstView != 0){
					getViewTreeObserver().removeGlobalOnLayoutListener(this);
					Log.e(TAG, TAG + " mHeightFirstView:"+mHeightFirstView);
					
				}
			}
		});
		
		
		super.onFinishInflate();
	}
	
//	@Override
//	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
//		super.onScrollChanged(l, t, oldl, oldt);
////		Log.e(TAG, TAG + " t:" + t+ " oldt::"+oldt);
//	}

}
