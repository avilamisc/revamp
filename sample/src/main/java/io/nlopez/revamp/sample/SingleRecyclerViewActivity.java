package io.nlopez.revamp.sample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.nlopez.revamp.sample.model.User;
import io.nlopez.revamp.sample.util.DataGenerator;
import io.nlopez.revamp.sample.view.UserView;
import io.nlopez.smartadapters.SmartAdapter;

public class SingleRecyclerViewActivity extends Activity {

    @InjectView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_recyclerview);

        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        List<User> userList = DataGenerator.generateUsers(100);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SmartAdapter.items(userList).map(User.class, UserView.class).into(recyclerView);
    }

}
