# RecyclerStickyHeaderView
[![](https://jitpack.io/v/TellH/RecyclerStickyHeaderView.svg)](https://jitpack.io/#TellH/RecyclerStickyHeaderView)<br>
Sticky header view or suspending view for RecyclerView.<br>

## Effect
![](https://raw.githubusercontent.com/TellH/RecyclerTreeView/master/raw/effect.gif)

## Usage

### Setup
root build.gradle
```groovy
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```
app build.gradle
```groovy
dependencies {
   compile 'com.github.TellH:RecyclerStickyHeaderView:1.0.0'
}
```

### Quick Start

- Place RecylerView into StickyHeaderView
``` xml
    <tellh.com.stickyheaderview_rv.StickyHeaderView
        android:id="@+id/stickyHeaderView"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <android.support.v7.widget.RecyclerView
            android:id="@+id/recyclerView"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:background="@android:color/white"
            android:scrollbars="vertical" />
    </tellh.com.stickyheaderview_rv.StickyHeaderView>

```

- Create data bean class for each item type in RecyclerView. They should extend DataBean. Override the method <br>
`public boolean shouldSticky()` to decide whether the item view should be suspended on the top.
``` java
public class User extends DataBean {
    private String login;
    private int id;
    private String avatar_url;
    private boolean shouldSticky;
    @Override
    public int getItemLayoutId(StickyHeaderViewAdapter adapter) {
        return R.layout.item_user;
    }
    public void setShouldSticky(boolean shouldSticky) {
        this.shouldSticky = shouldSticky;
    }
    // Decide whether the item view should be suspended on the top.
    @Override
    public boolean shouldSticky() {
        return shouldSticky;
    }
}
public class ItemHeader extends DataBean {
    private String prefix;
    @Override
    public int getItemLayoutId(StickyHeaderViewAdapter adapter) {
        return R.layout.header;
    }
    @Override
    public boolean shouldSticky() {
        return true;
    }
}
```

- Create ViewBinder to bind different type views with specific data beans.
As you see, `provideViewHolder(View itemView)` corresponds for `onCreateViewHolder` in RecyclerView, and `bindView` corresponds for `onBindViewHolder` in RecyclerView.

``` java
public class ItemHeaderViewBinder extends ViewBinder<ItemHeader, ItemHeaderViewBinder.ViewHolder> {
    @Override
    public ViewHolder provideViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }
    @Override
    public void bindView(StickyHeaderViewAdapter adapter, ViewHolder holder, int position, ItemHeader entity) {
        holder.tvPrefix.setText(entity.getPrefix());
    }
    @Override
    public int getItemLayoutId(StickyHeaderViewAdapter adapter) {
        return R.layout.header;
    }
    static class ViewHolder extends ViewBinder.ViewHolder {
        TextView tvPrefix;
        public ViewHolder(View rootView) {
            super(rootView);
            this.tvPrefix = (TextView) rootView.findViewById(R.id.tv_prefix);
        }
    }
}
```

- Create StickyHeaderViewAdapter for RecyclerView and register ViewBinders for each item types.
``` java
        rv = (RecyclerView) findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        List<DataBean> userList = new ArrayList<>();
        adapter = new StickyHeaderViewAdapter(userList)
                .RegisterItemType(new UserItemViewBinder())
                .RegisterItemType(new ItemHeaderViewBinder());
        rv.setAdapter(adapter);
```

That is all. 

Please check out the Demo and source code for more information. If you have any question, feel free to raise an issue. Thanks a lot!





