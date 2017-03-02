package com.gaohuiyu.lib;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by sakura on 2017/3/2.
 */

public class CountView extends LinearLayout {

    public CountView(Context context) {
        this(context, null);
    }

    public CountView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CountView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

//    public CountView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }

    private float mDensity;

    private int mCount = 1;
    private int mMin = 1;

    /**
     * 最小数，到了这个数，减号就不能点了
     * @param min
     */
    public void setMin(int min) {
        this.mMin = min;
    }

    public void setCount(int count) {
        this.mCount = count;
    }

    public int getCount() {
        return mCount;
    }

    private void init() {
        mDensity = getResources().getDisplayMetrics().density;

        setGravity(Gravity.CENTER_VERTICAL);

        mtvSub = new ImageView(getContext());
//        mtvSub.setBackgroundColor(getResources().getColor(R.color.count_view_sub_back));
        mtvSub.setBackgroundDrawable(getResources().getDrawable(R.drawable.count_view_sub_back));
        mtvSub.setMinimumWidth((int) (mDensity * 27));
        mtvSub.setMinimumHeight((int) (mDensity * 27));
        mtvSub.setImageResource(R.drawable.count_view_sub);
        mtvSub.setPadding((int) mDensity * 8, (int) mDensity * 8,
                (int) mDensity * 8, (int) mDensity * 8);
        mtvSub.setEnabled(false);

        mtvSub.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mtvCount.setText(String.valueOf(--mCount));
                if (mCount <= mMin) {
                    mtvSub.setEnabled(false);
                }
            }
        });

        mtvCount = new TextView(getContext());
        mtvCount.setText(String.valueOf(mCount));
        mtvCount.setTextSize(13);
        mtvCount.setWidth((int) mDensity * 34);
        mtvCount.setHeight((int) (mDensity * 27));
        mtvCount.setBackgroundColor(Color.parseColor("#F5F5F5"));
        mtvCount.setGravity(Gravity.CENTER);

        LinearLayout.LayoutParams lpCount = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lpCount.setMargins((int) mDensity, 0, (int) mDensity, 0);
        mtvCount.setLayoutParams(lpCount);

        mtvAdd = new ImageView(getContext());
        mtvAdd.setBackgroundDrawable(getResources().getDrawable(R.drawable.count_view_sub_back));
        mtvAdd.setMinimumWidth((int) (mDensity * 27));
        mtvAdd.setMinimumHeight((int) (mDensity * 27));
        mtvAdd.setImageResource(R.drawable.count_view_add);
        mtvAdd.setPadding((int) mDensity * 8, (int) mDensity * 8,
                (int) mDensity * 8, (int) mDensity * 8);

        mtvAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mtvCount.setText(String.valueOf(++mCount));
                if (mCount > mMin) {
                    mtvSub.setEnabled(true);
                }
            }
        });

        this.addView(mtvSub);
        this.addView(mtvCount);
        this.addView(mtvAdd);
    }

    private ImageView mtvSub;
    private ImageView mtvAdd;
    private TextView  mtvCount;

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
//        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
//        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
//
//        Log.d("test", "widthMode: " + widthMode);
//        Log.d("test", "widthSize: " + widthSize);
//        Log.d("test", "heightMode: " + heightMode);
//        Log.d("test", "heightSize: " + heightSize);
//
//    }

}
