package br.com.goodfeel.app.appdobem.ui.activity;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.goodfeel.app.appdobem.R;
import br.com.goodfeel.app.appdobem.database.AppDatabase;
import br.com.goodfeel.app.appdobem.domain.Author;
import br.com.goodfeel.app.appdobem.domain.Quote;
import br.com.goodfeel.app.appdobem.ui.adapter.tabs.SectionsPagerAdapter;
import br.com.goodfeel.app.appdobem.ui.fragments.BiographyFragment;
import br.com.goodfeel.app.appdobem.ui.fragments.QuoteFragment;
import br.com.goodfeel.app.appdobem.ui.pagetransform.ZoomOutPageTransformer;
import br.com.goodfeel.app.appdobem.utils.ContentManager;

public class AuthorOverviewActivity extends AppCompatActivity {

    private static final String TAG = "authoroverview";

    private Author author;
    private AppDatabase database;

    private CollapsingToolbarLayout toolbarLayout;
    private ImageView authorBackdrop;

    private TabLayout authorTabLayout;
    private SectionsPagerAdapter adapter;
    private ViewPager sectionsViewPager;

    private BiographyFragment biographyFragment;
    private QuoteFragment quoteFragment;

    private Bundle bundle;
    private ContentManager contentManager;
    private int contextMenuShareIndex;

    //All Data to Fragments
    private List<Quote> quotes;

    private AdView adView;
    private AdRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_overview);


        database = new AppDatabase(this);

        MobileAds.initialize(this, "ca-app-pub-8331859175410957~6275011656");

        //ca-app-pub-8331859175410957/9412310888

        adView = findViewById(R.id.author_overview_adview);
        request = new AdRequest.Builder().addTestDevice("27BA4DF7F6EB7C6DEABAEEB89B414A0B").build();
        adView.loadAd(request);

        author = (Author) getIntent().getSerializableExtra("author");

        contentManager = new ContentManager(this);
        quotes = database.queryAllFromAuthor(author.getCompleteName());

        biographyFragment = new BiographyFragment();
        quoteFragment = new QuoteFragment();

        adapter = new SectionsPagerAdapter(getSupportFragmentManager());

        sectionsViewPager = findViewById(R.id.sections_view_pager);
        sectionsViewPager.setAdapter(adapter);
        sectionsViewPager.setPageTransformer(false, new ZoomOutPageTransformer());

        authorTabLayout = findViewById(R.id.author_tab_layout);
        authorTabLayout.setupWithViewPager(sectionsViewPager);

        //TODO Passar os dados apropriadamente para os Fragments

        toolbarLayout = findViewById(R.id.author_main_collapsing);
        authorBackdrop = findViewById(R.id.author_backdrop);

        toolbarLayout.setTitle(author.toString());
        Picasso.get().load(author.getPicture()).placeholder(R.drawable.ic_supervisor_account_black_300dp).fit().centerCrop().into(authorBackdrop);

    }

    public Author getAuthor() {
        return author;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

}
