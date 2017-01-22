package tellh.com.recyclerstickyheaderview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.List;
import java.util.Stack;

/**
 * Created by tlh on 2017/1/21 :)
 */

public class StickyHeaderView extends FrameLayout {
    private static final String TAG = "StickyHeaderView";
    private FrameLayout mHeaderContainer;
    private boolean hasInit = false;
    private RecyclerView mRecyclerView;
    private int mHeaderHeight = -1;
    private StickyHeaderViewAdapter adapter;
    private LinearLayoutManager layoutManager;
    private Stack<Integer> stickyHeaderPositionStack = new Stack<>();

    public StickyHeaderView(Context context) {
        super(context);
    }

    public StickyHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StickyHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView() {
        if (hasInit) {
            return;
        }
        hasInit = true;
        View view = getChildAt(0);
        if (!(view instanceof RecyclerView))
            throw new RuntimeException("RecyclerView should be the first child view.");
        mRecyclerView = (RecyclerView) view;
        mHeaderContainer = new FrameLayout(getContext());
        mHeaderContainer.setBackgroundColor(Color.WHITE);
        mHeaderContainer.setLayoutParams(
                new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        addView(mHeaderContainer);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (mHeaderHeight == -1 || mHeaderHeight == 0 || adapter == null || layoutManager == null) {
                    mHeaderHeight = mHeaderContainer.getHeight();
                    adapter = (StickyHeaderViewAdapter) mRecyclerView.getAdapter();
                    layoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    if (adapter != null)
                        stickyHeaderPositionStack.push(findFirstVisibleStickyHeaderPosition(adapter.displayList, 0));
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (mHeaderHeight == -1 || adapter == null || layoutManager == null)
                    return;
                List<DataBean> displayList = adapter.getDisplayList();
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
                int firstVisibleStickyHeaderPosition = findFirstVisibleStickyHeaderPosition(displayList, firstVisibleItemPosition);
                int currentStickyHeaderPosition = stickyHeaderPositionStack.peek();
                if (firstVisibleStickyHeaderPosition - firstVisibleItemPosition > 1) {
                    return;
                }
                View firstVisibleStickyHeader = layoutManager.findViewByPosition(firstVisibleStickyHeaderPosition);
                if (firstVisibleStickyHeader == null)
                    return;
                int headerTop = firstVisibleStickyHeader.getTop();
                if (headerTop > 0 && headerTop <= mHeaderHeight) {
                    mHeaderContainer.setY(-(mHeaderHeight - headerTop));
                    if (firstVisibleStickyHeaderPosition == currentStickyHeaderPosition) {
                        stickyHeaderPositionStack.pop();
                        if (!stickyHeaderPositionStack.isEmpty())
                            updateHeaderView(stickyHeaderPositionStack.peek());
                    }
                } else if (headerTop <= 0) {
                    mHeaderContainer.setY(0);
                    updateHeaderView(firstVisibleItemPosition);
                }

                // Cache the StickyHeader position.
                if (firstVisibleStickyHeaderPosition > currentStickyHeaderPosition)
                    stickyHeaderPositionStack.push(firstVisibleStickyHeaderPosition);
                else if (firstVisibleStickyHeaderPosition < currentStickyHeaderPosition)
                    stickyHeaderPositionStack.pop();
                }
            }

        );

    }

    private int findFirstVisibleStickyHeaderPosition(List<DataBean> displayList, int firstVisibleItemPosition) {
        int i = firstVisibleItemPosition;
        for (; i < displayList.size(); i++) {
            if (!displayList.get(i).shouldSticky())
                continue;
            break;
        }
        return i;
    }

    public void updateHeaderView(int position) {
        DataBean entity = adapter.getDisplayList().get(position);
        int layoutId = entity.getItemLayoutId(adapter);
        clearHeaderView();
        View v = LayoutInflater.from(mHeaderContainer.getContext())
                .inflate(layoutId, mHeaderContainer, false);
        mHeaderContainer.addView(v);
        mHeaderHeight = mHeaderContainer.getHeight();
        ViewBinder headerViewBinder = adapter.getViewBinder(layoutId);
        headerViewBinder.bindView(adapter, headerViewBinder.provideViewHolder(v), position, entity);
    }

    public void clearHeaderView() {
        mHeaderContainer.removeAllViews();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        initView();
        super.onLayout(changed, left, top, right, bottom);
    }

}
