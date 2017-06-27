package com.hensen.greendaodemo.Adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hensen.greendaodemo.Bean.User;
import com.hensen.greendaodemo.R;
import com.lidroid.xutils.BitmapUtils;

import java.util.List;

/**
 * Created by handsome on 2016/4/8.
 */
public class UserListAdapter extends BaseAdapter {

    private List<User> list;
    //使用XUtils2包的图片加载模块
    private BitmapUtils bitmapUtils;
    private LayoutInflater mInflater;

    public UserListAdapter(Context context, List<User> list) {
        this.list = list;
        mInflater = LayoutInflater.from(context);
        bitmapUtils = new BitmapUtils(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.adapter_user_list, null);
        }
        ViewHolder holder = getViewHolder(convertView);
        User user = list.get(position);
        bitmapUtils.display(holder.iv_shop, user.getImage_url());
        holder.tv_name.setText(user.getName());
        holder.tv_price.setText("25%");
        //holder.tv_price_discount.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.tv_sell_num.setText("淘气值:86");
        return convertView;
    }

    /**
     * 获得控件管理对象
     *
     * @param view
     * @return
     */
    private ViewHolder getViewHolder(View view) {
        ViewHolder holder = (ViewHolder) view.getTag();
        if (holder == null) {
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        return holder;
    }

    /**
     * 控件管理类
     */
    private class ViewHolder {
        private TextView tv_name, tv_price, tv_price_discount, tv_sell_num;
        private ImageView iv_shop;

        ViewHolder(View view) {
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_price = (TextView) view.findViewById(R.id.tv_price);
            tv_price_discount = (TextView) view.findViewById(R.id.tv_price_discount);
            tv_sell_num = (TextView) view.findViewById(R.id.tv_sell_num);
            iv_shop = (ImageView) view.findViewById(R.id.iv_shop);
        }
    }
}
