# RecyclerStickyHeaderView
[![](https://jitpack.io/v/TellH/RecyclerStickyHeaderView.svg)](https://jitpack.io/#TellH/RecyclerStickyHeaderView)<br>
Sticky header view or suspending view for RecyclerView.<br>
[StickyListHeaders](https://github.com/emilsjolander/StickyListHeaders)  is an Android library that makes it easy to integrate section headers
 stick to the top in ListView. Inspire by it, I setup this project to implement the same effect in RecyclerView.
## Effect
![](https://raw.githubusercontent.com/TellH/RecyclerStickyHeaderView/master/raw/effect.gif)

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
   compile 'com.github.TellH:RecyclerStickyHeaderView:1.1.0'
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

- Instantiate StickyHeaderViewAdapter for RecyclerView and register ViewBinders for each item types.
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

## Thanks
- [SuspensionBar](https://github.com/wuapnjie/SuspensionBar)
- [NoListAdapter](https://github.com/TellH/NoListAdapter)

## License
   Copyright 2016 TellH
   
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
       http://www.apache.org/licenses/LICENSE-2.0
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.



