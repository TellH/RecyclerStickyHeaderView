package tellh.com.stickyheaderview_rv;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.List;
import java.util.Stack;

import tellh.com.stickyheaderview_rv.adapter.DataBean;
import tellh.com.stickyheaderview_rv.adapter.StickyHeaderViewAdapter;
import tellh.com.stickyheaderview_rv.adapter.ViewBinder;

/**
 * Created by tlh on 2017/1/21 :)
 */

public class StickyHeaderView extends FrameLayout {
    private static final String TAG = "StickyHeaderView";
    private boolean hasInit = false;
    private FrameLayout mHeaderContainer;
    private RecyclerView mRecyclerView;
    private int mHeaderHeight = -1;
    private StickyHeaderViewAdapter adapter;
    private LinearLayoutManager layoutManager;
    private Stack<Integer> stickyHeaderPositionStack = new Stack<>();
    private LruCache<Integer, RecyclerView.ViewHolder> mViewHolderCache;

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
        mRecyclerView.addOnScrollListener(
                new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                        super.onScrollStateChanged(recyclerView, newState);
                        if (mHeaderHeight == -1 || mHeaderHeight == 0 || adapter == null || layoutManager == null) {
                            mHeaderHeight = mHeaderContainer.getHeight();
                            adapter = (StickyHeaderViewAdapter) mRecyclerView.getAdapter();
                            layoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
                            if (adapter != null) {
                                mViewHolderCache = new LruCache<>(adapter.getItemCount() / 3);
                            }
                        }
                    }

                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);
                        if (mHeaderHeight == -1 || adapter == null || layoutManager == null)
                            return;
                        List<DataBean> displayList = adapter.getDisplayList();
                        if (stickyHeaderPositionStack.isEmpty())
                            stickyHeaderPositionStack.push(findFirstVisibleStickyHeaderPosition(displayList, 0));
                        int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
                        int firstVisibleStickyHeaderPosition = findFirstVisibleStickyHeaderPosition(displayList, firstVisibleItemPosition);
                        int currentStickyHeaderPosition = stickyHeaderPositionStack.peek();
                        if (firstVisibleStickyHeaderPosition - firstVisibleItemPosition > 1) {
                            return;
                        }
                        // 如果两个连续两个都是StickyView, 取下面那个View
                        if (displayList.get(firstVisibleStickyHeaderPosition + 1).shouldSticky())
                            firstVisibleStickyHeaderPosition++;
                        View firstVisibleStickyHeader = layoutManager.findViewByPosition(firstVisibleStickyHeaderPosition);
                        if (firstVisibleStickyHeader == null)
                            return;
                        int headerTop = firstVisibleStickyHeader.getTop();
                        if (headerTop > 0 && headerTop <= mHeaderHeight) { //吸顶正在更替的状态
                            mHeaderContainer.setY(-(mHeaderHeight - headerTop));
                            if (firstVisibleStickyHeaderPosition == currentStickyHeaderPosition) {
                                stickyHeaderPositionStack.pop();
                                if (!stickyHeaderPositionStack.isEmpty())
                                    updateHeaderView(stickyHeaderPositionStack.peek());
                            }
                        } else if (headerTop <= 0) {  //吸顶稳定在最上方的状态
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

    private void updateHeaderView(int position) {
        DataBean entity = adapter.getDisplayList().get(position);
        int layoutId = entity.getItemLayoutId(adapter);
        clearHeaderView();
        RecyclerView.ViewHolder viewHolder = mViewHolderCache.get(layoutId);
        ViewBinder headerViewBinder = adapter.getViewBinder(layoutId);
        if (viewHolder == null) {
            View v = LayoutInflater.from(mHeaderContainer.getContext())
                    .inflate(layoutId, mHeaderContainer, false);
            viewHolder = headerViewBinder.provideViewHolder(v);
            mViewHolderCache.put(layoutId, viewHolder);
        }
        mHeaderContainer.addView(viewHolder.itemView);
        mHeaderHeight = mHeaderContainer.getHeight();
        headerViewBinder.bindView(adapter, viewHolder, position, entity);
    }

    private void clearHeaderView() {
        mHeaderContainer.removeAllViews();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        initView();
        super.onLayout(changed, left, top, right, bottom);
    }

}
