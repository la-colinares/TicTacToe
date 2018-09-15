package com.colinares.tictactoe.Utils;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SpaceDecorator extends RecyclerView.ItemDecoration {
    private int mItemOffset;

    public SpaceDecorator(int itemOffset) {
        mItemOffset = itemOffset;
    }

    public SpaceDecorator(@NonNull Context context, @DimenRes int itemOffsetId) {
        this(context.getResources().getDimensionPixelSize(itemOffsetId));
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (parent.getChildLayoutPosition(view) == 0)
            outRect.top = mItemOffset;
        outRect.left = mItemOffset;
        outRect.right = mItemOffset;
        outRect.bottom = mItemOffset;
    }
}
