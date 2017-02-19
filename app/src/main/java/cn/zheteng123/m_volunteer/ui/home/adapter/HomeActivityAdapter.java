package cn.zheteng123.m_volunteer.ui.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cn.zheteng123.m_volunteer.R;
import cn.zheteng123.m_volunteer.entity.HomeActivityEntity;

/**
 * Created on 2017/2/17.
 */


public class HomeActivityAdapter extends BaseAdapter {

    private List<HomeActivityEntity> mHomeActivityList;
    private LayoutInflater mInflater;

    public HomeActivityAdapter(Context context, List<HomeActivityEntity> homeActivityList) {
        mHomeActivityList = homeActivityList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mHomeActivityList.size();
    }

    @Override
    public HomeActivityEntity getItem(int position) {
        return mHomeActivityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        HomeActivityEntity homeActivity = getItem(position);

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_home_activity, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tv_item_activity_title);
            viewHolder.tvDistance = (TextView) convertView.findViewById(R.id.tv_distance);
            viewHolder.tvDistrict = (TextView) convertView.findViewById(R.id.tv_district);
            viewHolder.tvEnrollNum = (TextView) convertView.findViewById(R.id.tv_person);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvTitle.setText(homeActivity.getTitle());

        double distance = homeActivity.getDistance();
        if (distance > 50) {
            viewHolder.tvDistance.setText(">" + distance + "km");
        } else {
            viewHolder.tvDistance.setText(distance + "km");
        }

        viewHolder.tvDistrict.setText(homeActivity.getDistrict());

        viewHolder.tvEnrollNum.setText(homeActivity.getEnrollNum() + "/" + homeActivity.getTotalNum());

        return convertView;
    }

    class ViewHolder {
        TextView tvTitle;
        TextView tvDistance;
        TextView tvDistrict;
        TextView tvEnrollNum;
    }
}
