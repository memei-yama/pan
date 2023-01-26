package com.example.foodmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimelineAdapter extends SimpleAdapter {

    private LayoutInflater inflater;
    private List<? extends Map<String, ?>> listData;

    public boolean good = false;

    public  class ViewHolder {
        TextView name;
        TextView date;
        TextView num;
        TextView food;
        ImageView image;
    }

    public TimelineAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.listData = data;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        View view = convertView;

        if(view == null) {
            view = inflater.inflate(R.layout.list_tl, parent, false);

            holder = new ViewHolder();
            holder.name = (TextView) view.findViewById(R.id.tl_name);
            holder.date = (TextView) view.findViewById(R.id.tl_data);
            holder.num = (TextView) view.findViewById(R.id.tl_num);
            holder.food = (TextView) view.findViewById(R.id.food);
            holder.image = (ImageView) view.findViewById(R.id.tlimageView);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        String name = ((HashMap<?, ?>) listData.get(position)).get("tl_name").toString();
        String date = ((HashMap<?, ?>) listData.get(position)).get("tl_data").toString();
        String num = ((HashMap<?, ?>) listData.get(position)).get("tl_num").toString();
        String food = ((HashMap<?, ?>) listData.get(position)).get("food").toString();
        String image_string = ((HashMap<?, ?>) listData.get(position)).get("tlimageView").toString();
        int image = Integer.parseInt(image_string);

        holder.name.setText(name);
        holder.date.setText(date);
        holder.num.setText((num));
        holder.food.setText(food);
        holder.image.setImageResource(image);

        ImageButton btn = (ImageButton) view.findViewById(R.id.heartButton);
        btn.setTag(position);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //goodの値がfalse(リアクションがない)だったらハートマークをつける
                if (!good) {
                    btn.setImageResource(R.drawable.color_heart);
                    good = true;
                    //データベースにユーザIDを格納

                    //goodの値がtrue(リアクションがある)だったらハートマークを消す
                } else if (good) {
                    btn.setImageResource(R.drawable.heart);
                    good = false;
                    //データベースからユーザIDを削除
                }
            }
        });
        return view;
    }
}
