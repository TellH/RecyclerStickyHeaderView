package tellh.com.stickyheaderview_rv.adapter;

import android.support.annotation.LayoutRes;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class StickyHeaderViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static int SIZE_VIEW_BINDER_POOL = 10;
    private SparseArrayCompat<ViewBinder> viewBinderPool;
    protected List<DataBean> displayList;
    private DataSetChangeListener onDataSetChangeListener;

    public StickyHeaderViewAdapter(List<? extends DataBean> displayList) {
        viewBinderPool = new SparseArrayCompat<>(SIZE_VIEW_BINDER_POOL);
//        if (displayList == null)
        this.displayList = new ArrayList<>();
        this.displayList.addAll(displayList);
    }

    private List<DataBean> getDisplayList() {
        return displayList;
    }

    public int getDisplayListSize() {
        return displayList == null ? 0 : displayList.size();
    }

    public DataBean get(int i) {
        if (i < getDisplayListSize())
            return displayList.get(i);
        else return null;
    }

    public int getPosition(DataBean dataBean) {
        return displayList.indexOf(dataBean);
    }

    @Override
    public int getItemViewType(int position) {
        return displayList.get(position).getItemLayoutId(this);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewBinder viewBinder = getViewBinder(viewType);
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(viewBinder.getItemLayoutId(this), parent, false);
        return viewBinder.provideViewHolder(itemView);
    }

    public ViewBinder getViewBinder(int viewType) {
        return viewBinderPool.get(viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //normal view
        DataBean dataBean = displayList.get(position);
        dataBean.provideViewBinder(this, viewBinderPool, position).bindView(this, holder, position, dataBean);
    }

    @Override
    public int getItemCount() {
        return displayList == null ? 0 : displayList.size();
    }

    public ViewBinder findViewBinderFromPool(@LayoutRes int layoutId) {
        return viewBinderPool.get(layoutId);
    }

    public static void setViewBinderPoolInitSize(int size) {
        SIZE_VIEW_BINDER_POOL = size;
    }

    public void clearViewBinderCache() {
        viewBinderPool.clear();
    }

    public void append(List<? extends DataBean> list) {
        if (list == null)
            return;
        displayList.addAll(list);
        notifyDataSetChanged();
    }

    public void append(DataBean dataBean) {
        displayList.add(dataBean);
        notifyItemInserted(displayList.size() - 1);
    }

    public void refresh(List<? extends DataBean> list) {
        if (list == null)
            return;
        onDataSetChangeListener.onClearAll();
        displayList.clear();
        displayList.addAll(list);
        notifyDataSetChanged();
    }

    public void delete(int pos) {
        onDataSetChangeListener.remove(pos);
        displayList.remove(pos);
        notifyItemRemoved(pos);
    }

    public void clear(RecyclerView recyclerView) {
        onDataSetChangeListener.onClearAll();
        displayList.clear();
        notifyDataSetChanged();
        recyclerView.scrollToPosition(0);
    }

    public StickyHeaderViewAdapter RegisterItemType(ViewBinder viewBinder) {
        viewBinderPool.put(viewBinder.getItemLayoutId(this), viewBinder);
        return this;
    }

    // Don't Call this Method
    public void setDataSetChangeListener(DataSetChangeListener listener) {
        this.onDataSetChangeListener = listener;
    }

    public interface DataSetChangeListener {
        void onClearAll();

        void remove(int pos);
    }
}
