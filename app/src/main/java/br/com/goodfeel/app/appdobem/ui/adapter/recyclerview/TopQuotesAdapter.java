package br.com.goodfeel.app.appdobem.ui.adapter.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.goodfeel.app.appdobem.R;
import br.com.goodfeel.app.appdobem.domain.Quote;
import br.com.goodfeel.app.appdobem.ui.adapter.interfaces.OnItemClickListener;
import br.com.goodfeel.app.appdobem.ui.adapter.interfaces.OnItemLongClickListener;

public class TopQuotesAdapter extends RecyclerView.Adapter<TopQuotesAdapter.QuotesViewHolder> {

    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;
    private Context context;
    private List<Quote> quoteList;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public TopQuotesAdapter(Context context, List<Quote> quoteList) {
        this.context = context;
        this.quoteList = quoteList;
    }

    @NonNull
    @Override
    public QuotesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.quote_item, viewGroup, false);
        return new QuotesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull QuotesViewHolder quotesViewHolder, int i) {
        quotesViewHolder.bind(quoteList.get(i));
    }

    @Override
    public int getItemCount() {
        return quoteList.size();
    }

    public class QuotesViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        private TextView content;
        private TextView author;

        public QuotesViewHolder(@NonNull View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.quote_content);
            author = itemView.findViewById(R.id.quote_author);

            itemView.setOnCreateContextMenuListener(this);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(getAdapterPosition());
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (onItemLongClickListener != null) {
                        onItemLongClickListener.onItemLongClick(getAdapterPosition());
                    }

                    return false;
                }
            });
        }

        public void bind(Quote quote) {
            content.setText(quote.getContent());
            author.setText(quote.getAuthor().toString());
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(this.getAdapterPosition(), 0, 0, R.string.share);
        }
    }
}
