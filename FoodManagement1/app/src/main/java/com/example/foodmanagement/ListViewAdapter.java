//山﨑里沙,2022/12/31
//家族・フレンドを表示させる追加プログラム

package com.example.foodmanagement;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewAdapter extends SimpleAdapter{
    /*protected void onCreate(Bundle savedInstanceState) {
        listView.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        Intent intent = new Intent(this,ChatRoom.class);
        // clickされたpositionのtextとphotoのID
        String selectedText = scenes[position];
        int selectedPhoto = photos[position];
        intent.putExtra("Text", selectedText);
        intent.putExtra("Photo", selectedPhoto);
        // Activity をスイッチする
        startActivity(intent);
    }*/

    private LayoutInflater inflater;
    private List<? extends Map<String, ?>> listData;
    private String[] friend;

    // 各行が保持するデータ保持クラス
    public class ViewHolder {
        TextView text1;
    }

    public ListViewAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[]to) {
        super(context, data, resource, from, to);
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.listData = data;
        this.friend = from;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        // ビューを受け取る
        View view = convertView;

        if (view == null) {
            // 画面起動時にViewHolderを作成する
            view = inflater.inflate(R.layout.row, parent, false);

            holder = new ViewHolder();
            holder.text1 = (TextView) view.findViewById(R.id.text1);

            view.setTag(holder);
        } else {
            // 行選択時などは既に作成されているものを取得する
            holder = (ViewHolder) view.getTag();
        }

        //String text1 = ((HashMap<?,?>) listData.get(position)).get("text1").toString();
        //holder.text1.setText(text1);
        holder.text1.setText(friend[position]);

        // セル上にあるボタンの処理
        //Button btn = (Button) view.findViewById(R.id.rowbutton);
        //btn.setTag(position);
        //btn.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View arg0) {
                // 選択したセルの文字を赤色にする
             //   holder.text1.setTextColor(Color.RED);
           // }
        //});
        return view;
    }

    @Override
    public int getCount() {
        return friend.length;
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