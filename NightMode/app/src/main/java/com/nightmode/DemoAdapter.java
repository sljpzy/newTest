package com.nightmode;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by xiaowu on 2017/6/12.
 */

public class DemoAdapter extends BaseAdapter {
    private Context context;
    private List<Demo> list;

    private static final int TYPE_HAS_PIC = 0;
    private static final int TYPE_NO_PIC = 1;

    public DemoAdapter(Context context, List<Demo> list) {
        this.context = context;
        this.list = list;
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
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        boolean isHas = list.get(position).isHasImg();
        /**
         * 判断条件
         */
        // 根据业务逻辑来，是判断的什么时候加载哪种布局
//        String str = list.get(position).getName();
//        if (TextUtils.isEmpty(str)) {
//            return TYPE_HAS_PIC;
//        }else{
//            return TYPE_NO_PIC;
//        }

        if (isHas) {
            return TYPE_HAS_PIC;
        } else {
            return TYPE_NO_PIC;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        int type = getItemViewType(position);
        if (convertView == null) {
            holder = new ViewHolder();
            switch (type) {
                case TYPE_HAS_PIC:
                    convertView = View.inflate(context, R.layout.item_has_pic, null);
                    holder.imgShow = (ImageView) convertView.findViewById(R.id.img_show);
                    holder.txtName = (TextView) convertView.findViewById(R.id.txt_name);
                    break;
                case TYPE_NO_PIC:
                    convertView = View.inflate(context, R.layout.item_no_pic, null);
                    holder.txtName = (TextView) convertView.findViewById(R.id.txt_name);
                    break;
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        switch (type) {
            case TYPE_HAS_PIC:
                holder.imgShow.setImageResource(list.get(position).getResId());
                holder.txtName.setText(list.get(position).getName());
                break;
            case TYPE_NO_PIC:
                holder.txtName.setText(list.get(position).getName());
                break;
        }

        return convertView;
    }

    class ViewHolder {
        ImageView imgShow;
        TextView txtName;
    }
}
