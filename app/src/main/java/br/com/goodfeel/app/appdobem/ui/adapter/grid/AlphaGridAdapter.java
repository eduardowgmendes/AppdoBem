package br.com.goodfeel.app.appdobem.ui.adapter.grid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import br.com.goodfeel.app.appdobem.R;

public class AlphaGridAdapter extends BaseAdapter {

    private Context context;
    private List<Character> characters;

    public AlphaGridAdapter(Context context, List<Character> characters) {
        this.context = context;
        this.characters = characters;
    }

    @Override
    public int getCount() {
        return characters.size();
    }

    @Override
    public Object getItem(int position) {
        return characters.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.alpha_item, parent, false);

        Button alpha_code = itemView.findViewById(R.id.alpha_code);
        alpha_code.setText(String.valueOf(characters.get(position)));

        return itemView;
    }
}
