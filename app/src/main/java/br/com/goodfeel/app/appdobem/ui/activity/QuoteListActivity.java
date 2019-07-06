package br.com.goodfeel.app.appdobem.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.goodfeel.app.appdobem.R;
import br.com.goodfeel.app.appdobem.domain.Author;
import br.com.goodfeel.app.appdobem.domain.Quote;
import br.com.goodfeel.app.appdobem.ui.adapter.QuoteListAdapter;

public class QuoteListActivity extends AppCompatActivity {

    private List<Quote> quotes;
    private ListView quotesList;
    private QuoteListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_list);

        quotes = new ArrayList<>();
        quotes.add(new Quote("Nada é pequeno no amor. Quem espera as grandes ocasiões para provar a sua ternura não sabe amar.", new Author("https://cdn.pensador.com/img/authors/la/ur/laure-conan-l.jpg", "Laure", "Conan", "", "", "")));
        quotes.add(new Quote("Nada é pequeno no amor. Quem espera as grandes ocasiões para provar a sua ternura não sabe amar.", new Author("https://cdn.pensador.com/img/authors/la/ur/laure-conan-l.jpg", "Laure", "Conan", "", "", "")));
        quotes.add(new Quote("Nada é pequeno no amor. Quem espera as grandes ocasiões para provar a sua ternura não sabe amar.", new Author("https://cdn.pensador.com/img/authors/la/ur/laure-conan-l.jpg", "Laure", "Conan", "", "", "")));
        quotes.add(new Quote("Nada é pequeno no amor. Quem espera as grandes ocasiões para provar a sua ternura não sabe amar.", new Author("https://cdn.pensador.com/img/authors/la/ur/laure-conan-l.jpg", "Laure", "Conan", "", "", "")));
        quotes.add(new Quote("Nada é pequeno no amor. Quem espera as grandes ocasiões para provar a sua ternura não sabe amar.", new Author("https://cdn.pensador.com/img/authors/la/ur/laure-conan-l.jpg", "Laure", "Conan", "", "", "")));
        quotes.add(new Quote("Nada é pequeno no amor. Quem espera as grandes ocasiões para provar a sua ternura não sabe amar.", new Author("https://cdn.pensador.com/img/authors/la/ur/laure-conan-l.jpg", "Laure", "Conan", "", "", "")));

        adapter = new QuoteListAdapter(this, quotes);

        quotesList = findViewById(R.id.quote_list);
        quotesList.setAdapter(adapter);
    }
}
