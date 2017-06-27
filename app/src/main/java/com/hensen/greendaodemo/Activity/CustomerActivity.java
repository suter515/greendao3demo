package com.hensen.greendaodemo.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.hensen.greendaodemo.Adapter.UserListAdapter;
import com.hensen.greendaodemo.Bean.User;
import com.hensen.greendaodemo.Dao.LoveDao;
import com.hensen.greendaodemo.Dao.UserDaoImp;
import com.hensen.greendaodemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 购买者activity
 */
public class CustomerActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_add, bt_delete, bt_update, bt_query;
    private ListView lv_content;
    private UserListAdapter adapter;
    private List<User> mUsers;
    private static int i = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        bt_add = (Button) findViewById(R.id.btn_add);
        bt_delete = (Button) findViewById(R.id.btn_delete);
        bt_update = (Button) findViewById(R.id.btn_update);
        bt_query = (Button) findViewById(R.id.btn_query);
        lv_content = (ListView) findViewById(R.id.lv_content_user);
        bt_add.setOnClickListener(this);
        bt_delete.setOnClickListener(this);
        bt_update.setOnClickListener(this);
        bt_query.setOnClickListener(this);

        queryDate();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                addDate();
                break;
            case R.id.btn_delete:
                deleteDate();
                break;
            case R.id.btn_update:
                updateDate();
                break;
            case R.id.btn_query:
                queryDate();
                break;
        }
    }

    private void deleteDate() {
        if (!mUsers.isEmpty()) {
            UserDaoImp.deleteUser(mUsers.get(0).getId());
            queryDate();
        }
    }

    private void queryDate() {
        mUsers = new ArrayList<>();
        mUsers = UserDaoImp.queryAll();
        adapter = new UserListAdapter(this, mUsers);
        lv_content.setAdapter(adapter);
    }

    private void addDate() {
        User user = new User();
        user.setImage_url("https://gd1.alicdn.com/imgextra/i1/1891562466/TB2fKt5Xb5K.eBjy0FnXXaZzVXa_!!1891562466.jpg");
        user.setName("王小二 " + i++);
        UserDaoImp.insertUser(user);
        User user2 = new User();
        user2.setImage_url("https://gd1.alicdn.com/imgextra/i1/1917525643/TB210xKdFXXXXawXXXXXXXXXXXX_!!1917525643.jpg");
        user2.setName("郦小军 " + i++);
        UserDaoImp.insertUser(user2);


        queryDate();
    }

    private void updateDate() {
        if (!mUsers.isEmpty()) {
            User user = mUsers.get(0);
            user.setName("suter519");
            UserDaoImp.updateUser(user);
            queryDate();
        }
    }
}
