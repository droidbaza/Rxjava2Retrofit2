package com.droidbaza.movies.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ZoomLinearLayoutManager extends LinearLayoutManager {

    private final float mAmount = 0.15f;
    private final float mDistance = 0.9f;

    public ZoomLinearLayoutManager(Context context) {
        super(context);
    }

    public ZoomLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public ZoomLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int orientation = getOrientation();
        if (orientation == VERTICAL) {
            int scrolled = super.scrollVerticallyBy(dy, recycler, state);
            float midpoint = getHeight() / 2.f;
            float d0 = 0.f;
            float d1 = mDistance * midpoint;
            float s0 = 1.f;
            float s1 = 1.f - mAmount;
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                assert child != null;
                float childMidpoint =
                        (getDecoratedBottom(child) + getDecoratedTop(child)) / 2.f;
                float d = Math.min(d1, Math.abs(midpoint - childMidpoint));
                float scale = s0 + (s1 - s0) * (d - d0) / (d1 - d0);
                child.setScaleX(scale);
                child.setScaleY(scale);
            }
            return scrolled;
        } else {
            return 0;
        }
    }

    /*
    @Override
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int orientation = getOrientation();
        if (orientation == HORIZONTAL) {
            int scrolled = super.scrollHorizontallyBy(dx, recycler, state);

            float midpoint = getWidth() / 2.f;
            float d0 = 0.f;
            float d1 = mDistance * midpoint;
            float s0 = 1.f;
            float s1 = 1.f - mAmount;
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                assert child != null;
                float childMidpoint =
                        (getDecoratedRight(child) + getDecoratedLeft(child)) / 2.f;
                float d = Math.min(d1, Math.abs(midpoint - childMidpoint));
                float scale = s0 + (s1 - s0) * (d - d0) / (d1 - d0);
                child.setScaleX(scale);
                child.setScaleY(scale);
            }
            return scrolled;
        } else {
            return 0;
        }

    }*/
}
