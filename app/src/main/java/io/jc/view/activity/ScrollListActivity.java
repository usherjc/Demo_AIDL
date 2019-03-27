package io.jc.view.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import io.jc.R;

/**
 * @name : usherchen
 * @date : 2019/3/27
 * @item : midea fridge
 * @desc : ScrollListActivity
 */
public class ScrollListActivity extends Activity {

    private LinearLayout mLlContent;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_li);
        //////////////////////////////////////////////////////////// init views
        mLlContent = findViewById(R.id.ll_content);
        //////////////////////////////////////////////////////////// init actions
        for (int i = 0; i < 10; i++) {
            View v = LayoutInflater.from(this).inflate(R.layout.view_child, mLlContent, false);
            TextView tv = v.findViewById(R.id.tv_item);
            tv.setText("test data item -- " + i);
            mLlContent.addView(v);
        }
    }

}
