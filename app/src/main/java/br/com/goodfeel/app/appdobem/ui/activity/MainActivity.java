package br.com.goodfeel.app.appdobem.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.goodfeel.app.appdobem.R;
import br.com.goodfeel.app.appdobem.database.AppDatabase;
import br.com.goodfeel.app.appdobem.domain.Author;
import br.com.goodfeel.app.appdobem.domain.Quote;
import br.com.goodfeel.app.appdobem.ui.adapter.interfaces.OnItemClickListener;
import br.com.goodfeel.app.appdobem.ui.adapter.interfaces.OnItemLongClickListener;
import br.com.goodfeel.app.appdobem.ui.adapter.recyclerview.TopAuthorAdapter;
import br.com.goodfeel.app.appdobem.ui.adapter.recyclerview.TopQuotesAdapter;
import br.com.goodfeel.app.appdobem.utils.ConnectionChecker;
import br.com.goodfeel.app.appdobem.utils.ContentManager;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "mainactivity";

    private List<Quote> quotes;
    private AppDatabase database;

    private List<Quote> topQuotes;

    private ConnectionChecker checker;
    private AdView adView;
    private AdRequest request;

    private ContentManager contentManager;

    private Quote quoteOfDay;

    //private Button buildStoriesButton;

    private int contextMenuSelectionIndex;

    // TOP Authors - GRID SNAP
    private RecyclerView topAuthorRecyclerView;
    private LinearSnapHelper helper;
    private TopAuthorAdapter authorAdapter;
    private List<Author> authors;

    //TOP Quotes - Linear Vertical List
    private RecyclerView topQuotesList;
    private TopQuotesAdapter quotesAdapter;

    private CardView quoteOfDayCardView;
    private TextView quoteOfDayContent, quoteOfDayAuthor;

    private ImageView quoteOfDaySectionBackground;
    private Button toListButton, renewButton, shareButton, moreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = new AppDatabase(this);

        authors = database.queryAllAuthor();
        quotes = database.queryAllQuote();

        contentManager = new ContentManager(this, quotes);
        topQuotes = contentManager.generateTopQuotes();

        //ca-app-pub-8331859175410957/2726648882

        MobileAds.initialize(this, "ca-app-pub-8331859175410957~6275011656");

        //AdView
        adView = findViewById(R.id.ad_view);
        request = new AdRequest.Builder().addTestDevice("27BA4DF7F6EB7C6DEABAEEB89B414A0B").build();
        adView.loadAd(request);

        checker = new ConnectionChecker(this);

        quoteOfDay = contentManager.getQuoteOfDay();

        /*buildStoriesButton = findViewById(R.id.build_storie);
        buildStoriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StorieEditorActivity.class);
                startActivity(intent);
            }
        });*/

        topAuthorRecyclerView = findViewById(R.id.top_authors_recycler_snapview);
        authorAdapter = new TopAuthorAdapter(this, authors);
        topAuthorRecyclerView.setAdapter(authorAdapter);
        helper = new LinearSnapHelper();
        helper.attachToRecyclerView(topAuthorRecyclerView);
        authorAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, AuthorOverviewActivity.class);
                intent.putExtra("author", authors.get(position));
                startActivity(intent);
            }
        });

        topQuotesList = findViewById(R.id.top_quotes_list);
        quotesAdapter = new TopQuotesAdapter(this, topQuotes);
        topQuotesList.setAdapter(quotesAdapter);
        quotesAdapter.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final int position) {
                contextMenuSelectionIndex = position;
                Log.d(TAG, "value: " + contextMenuSelectionIndex);
                return false;
            }
        });

        quoteOfDayContent = findViewById(R.id.quote_of_day_content);
        quoteOfDayContent.setText(quoteOfDay.getContent());

        quoteOfDayAuthor = findViewById(R.id.quote_of_day_author);
        quoteOfDayAuthor.setText(quoteOfDay.getAuthor().toString());

        quoteOfDayCardView = findViewById(R.id.quote_of_day_card);
        quoteOfDayCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contentManager.share(quoteOfDay);
            }
        });

        renewButton = findViewById(R.id.renew_quote_button);
        renewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quoteOfDay = contentManager.getRandomQuote();
                renewQuote(quoteOfDay);
            }
        });

        moreButton = findViewById(R.id.more_author_button);
        moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllAuthorActivity.class);
                startActivity(intent);
            }
        });

        shareButton = findViewById(R.id.share_quote_button);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contentManager.share(quoteOfDay);
            }
        });

        quoteOfDaySectionBackground = findViewById(R.id.quote_of_day_background);
        Picasso.get().load("https://wallpapersite.com/images/pages/pic_w/5348.jpg").placeholder(R.drawable.main_error_background_picasso).error(R.drawable.main_error_background_picasso).fit().centerCrop().into(quoteOfDaySectionBackground);

        checker.promptUser(findViewById(R.id.main_root_layout));
    }

    private void renewQuote(Quote quote) {
        quoteOfDayContent.setText(quote.getContent());
        quoteOfDayAuthor.setText(quote.getAuthor().toString());
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                contentManager.shareFromList(topQuotes, contextMenuSelectionIndex);
                break;
        }
        return super.onContextItemSelected(item);
    }


    @Override
    protected void onResume() {
        super.onResume();
        checker.promptUser(findViewById(R.id.main_root_layout));
        Picasso.get().load("https://wallpapersite.com/images/pages/pic_w/5348.jpg").placeholder(R.drawable.main_error_background_picasso).error(R.drawable.main_error_background_picasso).fit().centerCrop().into(quoteOfDaySectionBackground);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        checker.promptUser(findViewById(R.id.main_root_layout));
        Picasso.get().load("https://wallpapersite.com/images/pages/pic_w/5348.jpg").placeholder(R.drawable.main_error_background_picasso).error(R.drawable.main_error_background_picasso).fit().centerCrop().into(quoteOfDaySectionBackground);
    }

    //TODO REMOVER A CLASSE ContentManager FUTURAMENTE E ACRESCENTAR NOVOS MÉTODOS AO BANCO DE DADOS PARA FORNECER FRASES DE DIVERSAS MANEIRAS
}
