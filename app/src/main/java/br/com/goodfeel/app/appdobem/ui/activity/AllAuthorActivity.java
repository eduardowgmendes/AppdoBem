package br.com.goodfeel.app.appdobem.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.List;

import br.com.goodfeel.app.appdobem.R;
import br.com.goodfeel.app.appdobem.database.AppDatabase;
import br.com.goodfeel.app.appdobem.domain.Author;
import br.com.goodfeel.app.appdobem.ui.adapter.interfaces.OnItemClickListener;
import br.com.goodfeel.app.appdobem.ui.adapter.recyclerview.AuthorRecyclerAdapter;
import br.com.goodfeel.app.appdobem.utils.ContentManager;

public class AllAuthorActivity extends AppCompatActivity {

    private static final String TAG = "allauthoractivity";

    private AppDatabase database;
    private ContentManager contentManager;

    private List<Author> authors;
    private AuthorRecyclerAdapter adapter;
    private RecyclerView allAuthorList;

    private AdView adView;
    private AdRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_author);

        database = new AppDatabase(this);

        //ca-app-pub-8331859175410957/5137846349

        MobileAds.initialize(this, "ca-app-pub-8331859175410957~6275011656");

        adView = findViewById(R.id.all_author_adview);
        request = new AdRequest.Builder().addTestDevice("27BA4DF7F6EB7C6DEABAEEB89B414A0B").build();
        adView.loadAd(request);

        contentManager = new ContentManager(this);

        getSupportActionBar().setTitle(R.string.all_authors);

        authors = database.queryAllAuthor();

        allAuthorList = findViewById(R.id.all_author_list);
        loadList(authors);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu_author, menu);

        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint(getResources().getString(R.string.search_main_menu_title));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                authors = database.queryAuthorBy(s);
                loadList(authors);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                authors = database.queryAuthorBy(s);
                loadList(authors);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void loadList(final List<Author> authors) {
        adapter = new AuthorRecyclerAdapter(this, authors);
        allAuthorList.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(AllAuthorActivity.this, AuthorOverviewActivity.class);
                intent.putExtra("author", authors.get(position));
                startActivity(intent);
            }
        });
    }

}
