package br.com.goodfeel.app.appdobem.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import br.com.goodfeel.app.appdobem.R;
import br.com.goodfeel.app.appdobem.domain.Quote;

public class ContentManager {

    private Random random = new Random();

    private Context context;
    private List<Quote> quotes;

    public ContentManager(Context context) {
        this.context = context;
    }

    public ContentManager(Context context, List<Quote> quotes) {
        this.context = context;
        this.quotes = quotes;
    }

    public List<Quote> generateTopQuotes() {
        List<Quote> topQuotes = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            topQuotes.add(quotes.get(random.nextInt(quotes.size())));
        }

        return topQuotes;
    }


    public Quote getQuoteOfDay() {
        return quotes.get(random.nextInt(quotes.size()));
    }

    public Quote getRandomQuote() {
        return quotes.get(random.nextInt(quotes.size()));
    }

    public void share(Quote quote) {
        List<Intent> targets = new ArrayList<Intent>();
        Intent template = new Intent(Intent.ACTION_SEND);
        template.setType("text/plain");
        List<ResolveInfo> candidates = context.getPackageManager().
                queryIntentActivities(template, 0);

        // remove facebook which has a broken share intent
        for (ResolveInfo candidate : candidates) {
            String packageName = candidate.activityInfo.packageName;
            if (!packageName.equals("com.facebook.katana")) {
                Intent target = new Intent(android.content.Intent.ACTION_SEND);
                target.setType("text/plain");
                target.putExtra(Intent.EXTRA_TEXT, "\"" + quote.getContent() + "\" - " + quote.getAuthor());
                target.putExtra(Intent.EXTRA_SUBJECT, context.getResources().getString(R.string.quote_of_day_section));
                target.setPackage(packageName);
                targets.add(target);
            }
        }
        Intent chooser = Intent.createChooser(targets.remove(0), context.getResources().getString(R.string.share_via));
        chooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, targets.toArray(new Parcelable[]{}));
        context.startActivity(chooser);
    }

    public void shareFromList(List<Quote> quotes, int index) {
        this.share(quotes.get(index));
    }

}
