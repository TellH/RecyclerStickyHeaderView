package tellh.com.stickyheaderview_rv;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import tellh.com.stickyheaderview_rv.adapter.DataBean;
import tellh.com.stickyheaderview_rv.adapter.StickyHeaderViewAdapter;
import tellh.com.stickyheaderview_rv.adapter.ViewBinder;

/**
 * Created by tlh on 2017/1/21 :)
 */

public class StickyHeaderView extends FrameLayout
        implements StickyHeaderViewAdapter.DataSetChangeListener {
    private boolean hasInit = false;
    private FrameLayout mHeaderContainer;
    private RecyclerView mRecyclerView;
    private int mHeaderHeight = -1;
    private StickyHeaderViewAdapter adapter;
    private LinearLayoutManager layoutManager;
    private LinkListStack<DataBean> stickyHeaderStack = new LinkListStack<>();
    private SparseArray<RecyclerView.ViewHolder> mViewHolderCache;

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
                        if (mHeaderHeight == -1 || adapter == null || layoutManager == null) {
                            mHeaderHeight = mHeaderContainer.getHeight();
                            RecyclerView.Adapter adapter = mRecyclerView.getAdapter();
                            if (!(adapter instanceof StickyHeaderViewAdapter))
                                throw new RuntimeException
                                        ("Your RecyclerView.Adapter should be the type of StickyHeaderViewAdapter.");
                            StickyHeaderView.this.adapter = (StickyHeaderViewAdapter) adapter;
                            StickyHeaderView.this.adapter.setDataSetChangeListener(StickyHeaderView.this);
                            layoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
                            mViewHolderCache = new SparseArray<>();
                        } /*else if (mHeaderHeight == 0) {
                            mHeaderHeight = mHeaderContainer.getHeight();
                        }*/

                    }

                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);
                        if (mHeaderHeight == -1 || adapter == null || layoutManager == null)
                            return;
                        if (stickyHeaderStack.isEmpty() && adapter.getDisplayListSize() != 0)
                            stickyHeaderStack.push(adapter.get(findFirstVisibleStickyHeaderPosition(0)));
                        int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
                        if (firstVisibleItemPosition == -1)
                            return;
                        int firstVisibleStickyHeaderPosition = findFirstVisibleStickyHeaderPosition(firstVisibleItemPosition);
                        int currentStickyHeaderPosition = adapter.getPosition(stickyHeaderStack.peek());
                        if (firstVisibleStickyHeaderPosition - firstVisibleItemPosition > 1) {
                            return;
                        }
                        // 如果两个连续两个都是StickyView, 取下面那个View
                        DataBean dataBean = adapter.get(firstVisibleStickyHeaderPosition + 1);
                        if (dataBean != null && dataBean.shouldSticky())
                            firstVisibleStickyHeaderPosition++;
                        View firstVisibleStickyHeader = layoutManager.findViewByPosition(firstVisibleStickyHeaderPosition);
                        if (firstVisibleStickyHeader == null)
                            return;
                        int headerTop = firstVisibleStickyHeader.getTop();
                        if (headerTop > 0 && headerTop <= mHeaderHeight) { //吸顶正在更替的状态
                            mHeaderContainer.setY(-(mHeaderHeight - headerTop));
                            if (firstVisibleStickyHeaderPosition == currentStickyHeaderPosition) {
                                stickyHeaderStack.pop();
                                if (!stickyHeaderStack.isEmpty())
                                    updateHeaderView(stickyHeaderStack.peek());
                            }
                        } else if (headerTop <= 0) {  //吸顶稳定在最上方的状态
                            mHeaderContainer.setY(0);
                            updateHeaderView(adapter.get(firstVisibleItemPosition));
                        }

                        // Cache the StickyHeader position.
                        if (firstVisibleStickyHeaderPosition > currentStickyHeaderPosition)
                            stickyHeaderStack.push(adapter.get(firstVisibleStickyHeaderPosition));
                        else if (firstVisibleStickyHeaderPosition < currentStickyHeaderPosition)
                            stickyHeaderStack.pop();
                    }
                }

        );

    }

    private int findFirstVisibleStickyHeaderPosition(int firstVisibleItemPosition) {
        int i = firstVisibleItemPosition;
        for (; i < adapter.getDisplayListSize(); i++) {
            if (!adapter.get(i).shouldSticky())
                continue;
            break;
        }
        return i;
    }

    private void updateHeaderView(DataBean entity) {
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
        headerViewBinder.bindView(adapter, viewHolder, adapter.getPosition(entity), entity);
    }

    // Remove the Header View
    private void clearHeaderView() {
        mHeaderContainer.removeAllViews();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        initView();
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    public void onClearAll() {
        stickyHeaderStack.clear();
        clearHeaderView();
    }

    @Override
    public void remove(int pos) {
        DataBean entity = adapter.get(pos);
        if (stickyHeaderStack.peek() == entity)
            clearHeaderView();
        if (entity != null && entity.shouldSticky()) {
            stickyHeaderStack.remove(entity);
        }
    }
}
