package br.com.goodfeel.app.appdobem.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.goodfeel.app.appdobem.R;
import br.com.goodfeel.app.appdobem.domain.Quote;
import br.com.goodfeel.app.appdobem.ui.activity.AuthorOverviewActivity;
import br.com.goodfeel.app.appdobem.ui.adapter.interfaces.OnItemLongClickListener;
import br.com.goodfeel.app.appdobem.ui.adapter.recyclerview.TopQuotesAdapter;
import br.com.goodfeel.app.appdobem.utils.ContentManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {

    private static final String TAG = "quotefragment";

    private AuthorOverviewActivity activity;

    private RecyclerView quoteAuthorList;
    private TopQuotesAdapter adapter;

    private List<Quote> quotes;
    private ContentManager contentManager;

    private int contextMenuShareIndex;

    public QuoteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        contentManager = new ContentManager(getContext());

        activity = (AuthorOverviewActivity) getActivity();

        quotes = activity.getQuotes();

        adapter = new TopQuotesAdapter(getContext(), quotes);

        View itemView = inflater.inflate(R.layout.fragment_quote, container, false);

        quoteAuthorList = itemView.findViewById(R.id.author_quotes_section);
        quoteAuthorList.setAdapter(adapter);
        adapter.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(int position) {
                contextMenuShareIndex = position;
                return false;
            }
        });

        return itemView;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                contentManager.share(quotes.get(contextMenuShareIndex));
                break;
        }
        return super.onContextItemSelected(item);
    }
}
