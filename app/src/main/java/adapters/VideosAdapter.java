package adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import hossam.mejiaasociados.R;
import model.Data;

/**
 * Created by Hossam on 4/6/2016.
 */
public class VideosAdapter extends BaseAdapter {
    private Data data;
    private Data listData;
    private Typeface face;

    private LayoutInflater mInflater;

    public VideosAdapter(Context context, Data data) {
        this.data = data;

        mInflater = LayoutInflater.from(context);

        listData = data;
        face = Typeface.createFromAsset(context.getAssets(), "fonts/volatire.ttf");
    }

    @Override
    public int getCount() {
        return listData.getVideos().size();
    }

    @Override
    public Object getItem(int i) {
        return listData.getVideos().get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;


        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);


            holder = new ViewHolder();
            holder.text = (TextView) convertView.findViewById(R.id.list_view);


            convertView.setTag(holder);
        } else {

            holder = (ViewHolder) convertView.getTag();
        }


        holder.text.setText(listData.getVideos().get(i).getNombre());
        holder.text.setTypeface(face);

        return convertView;
    }

    public void filterData(String searchStr) {
        listData = new Data();
        for (int i = 0; i < data.getVideos().size(); i++) {
            if (data.getVideos().get(i).getNombre().contains(searchStr)) {
                listData.getVideos().add(data.getVideos().get(i));
            }
        }
        notifyDataSetChanged();
    }

    public void removeFilter() {
        listData = data;
        notifyDataSetChanged();
    }


    static class ViewHolder {
        TextView text;
    }
}
