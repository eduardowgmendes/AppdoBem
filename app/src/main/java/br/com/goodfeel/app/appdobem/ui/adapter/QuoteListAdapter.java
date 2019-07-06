package br.com.goodfeel.app.appdobem.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import java.util.List;

import br.com.goodfeel.app.appdobem.R;
import br.com.goodfeel.app.appdobem.domain.Quote;

public class QuoteListAdapter extends BaseAdapter {

    private Context context;
    private List<Quote> quotes;

    public QuoteListAdapter(Context context, List<Quote> quotes) {
        this.context = context;
        this.quotes = quotes;
    }

    @Override
    public int getCount() {
        return quotes.size();
    }

    @Override
    public Object getItem(int position) {
        return quotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = LayoutInflater.from(context).inflate(R.layout.quote_item, parent, false);

        TextView quoteContent = item.findViewById(R.id.quote_content);
        quoteContent.setText(quotes.get(position).getContent());

        TextView quoteAuthor = item.findViewById(R.id.quote_author);
        quoteAuthor.setText(quotes.get(position).getAuthor().toString());

        return item;
    }
}
