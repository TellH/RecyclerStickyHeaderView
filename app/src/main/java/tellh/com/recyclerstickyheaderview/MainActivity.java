package tellh.com.recyclerstickyheaderview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private StickyHeaderViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        Gson gson = new Gson();
        Result result = gson.fromJson(User.dataSource, Result.class);
        List<User> userList = result.getItems();
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getLogin().compareToIgnoreCase(o2.getLogin());
            }
        });
        List<DataBean> userListBak = new ArrayList<>();
        String currentPrefix = userList.get(0).getLogin().substring(0, 1).toUpperCase();
        userListBak.add(new ItemHeader(currentPrefix));
        for (User user : userList) {
            if (currentPrefix.compareToIgnoreCase(user.getLogin().substring(0, 1)) == 0)
                userListBak.add(user);
            else {
                currentPrefix = user.getLogin().substring(0, 1).toUpperCase();
                userListBak.add(new ItemHeader(currentPrefix));
                userListBak.add(user);
            }
        }
        adapter = new StickyHeaderViewAdapter(userListBak)
                .RegisterItemType(new UserItemViewBinder())
                .RegisterItemType(new ItemHeaderViewBinder());
        rv.setAdapter(adapter);
    }

    private void initView() {
        rv = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_view:
                User user = new User("Sticky View", 123, "https://avatars.githubusercontent.com/u/15800681?v=3");
                user.setShouldSticky(true);
                adapter.getDisplayList().add(3, user);
                adapter.notifyItemInserted(3);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
