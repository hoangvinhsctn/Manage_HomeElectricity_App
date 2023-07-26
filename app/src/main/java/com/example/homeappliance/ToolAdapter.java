package com.example.homeappliance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ToolAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Tool> toolList;

    public ToolAdapter(Context context, int layout, List<Tool> toolList) {
        this.context = context;
        this.layout = layout;
        this.toolList = toolList;
    }

    @Override
    public int getCount() {
        return toolList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder {
        TextView tvToolName, tvToolP, tvToolt;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout,null);

            viewHolder.tvToolName = (TextView) view.findViewById(R.id.textViewName);
            viewHolder.tvToolP = (TextView) view.findViewById(R.id.textViewP);
            viewHolder.tvToolt = (TextView) view.findViewById(R.id.textViewt);
            view.setTag(viewHolder);
        }else
            viewHolder = (ViewHolder) view.getTag();

        Tool tool = toolList.get(i);
        viewHolder.tvToolName.setText(tool.getName());
        viewHolder.tvToolP.setText(tool.getP().toString());
        viewHolder.tvToolt.setText(tool.getT().toString());

        return view;
    }
}
