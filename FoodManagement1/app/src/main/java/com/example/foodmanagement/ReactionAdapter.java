package com.example.foodmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class ReactionAdapter extends SimpleAdapter {
    private LayoutInflater inflater;
    private List<? extends Map<String, ?>> listData;
    private String[] reaction;


    // 各行が保持するデータ保持クラス
    public class ViewHolder {
        TextView name;
    }

    public ReactionAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[]to) {
        super(context, data, resource, from, to);
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.listData = data;
        this.reaction = from;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        // ビューを受け取る
        View view = convertView;

        if (view == null) {
            // 画面起動時にViewHolderを作成する
            view = inflater.inflate(R.layout.list_reaction, parent, false);

            holder = new ViewHolder();
            holder.name = (TextView) view.findViewById(R.id.displayUser1);

            view.setTag(holder);
        } else {
            // 行選択時などは既に作成されているものを取得する
            holder = (ViewHolder) view.getTag();
        }

        holder.name.setText(reaction[position]);

        return view;
    }

    @Override
    public int getCount() {
        return reaction.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
