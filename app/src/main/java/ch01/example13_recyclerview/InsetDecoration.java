package ch01.example13_recyclerview;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.darwindeveloper.dispositivosmoviles.R;

public class InsetDecoration extends RecyclerView.ItemDecoration {

    private int mInsetMargin;

    public InsetDecoration(Context context) {
        super();
        mInsetMargin = context.getResources()
                .getDimensionPixelOffset(R.dimen.inset_margin);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(mInsetMargin, mInsetMargin, mInsetMargin, mInsetMargin);
    }
}
