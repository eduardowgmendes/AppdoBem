package br.com.goodfeel.app.appdobem.utils;

import android.content.Context;
import android.content.Intent;

import java.util.List;
import java.util.Random;

import br.com.goodfeel.app.appdobem.R;
import br.com.goodfeel.app.appdobem.domain.Quote;

public class QuoteControls {

    private Random random;
    private Context context;

    private Quote quoteOfDay;
    private List<Quote> quotes;

    public QuoteControls(Context context, List<Quote> quotes) {
        this.random = new Random();
        this.context = context;
        this.quotes = quotes;
        this.quoteOfDay = quotes.get(random.nextInt(quotes.size()));
    }

    public void renew() {
        this.quoteOfDay = quotes.get(random.nextInt(quotes.size()));
    }

    public Quote getQuoteOfDay() {
        return quoteOfDay;
    }

    public void setQuoteOfDay(Quote quoteOfDay) {
        this.quoteOfDay = quoteOfDay;
    }

    public void share(Quote quote) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Quote of the Day");
        intent.putExtra(Intent.EXTRA_TEXT, quote.getContent() + " - " + quote.getAuthor().toString());
        context.startActivity(Intent.createChooser(intent, context.getResources().getString(R.string.share_via)));
    }

    public void shareQuoteOfDay() {
        this.share(quoteOfDay);
    }

}
