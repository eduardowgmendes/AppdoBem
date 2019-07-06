package br.com.goodfeel.app.appdobem.domain.appdomain;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.com.goodfeel.app.appdobem.R;
import br.com.goodfeel.app.appdobem.domain.Quote;

public class StorieBuilder {

    private Context context;
    private Story quote;

    private Bitmap bitmap;

    public StorieBuilder(Context context, Story quote) {
        this.context = context;
        this.quote = quote;
    }

    private void build(View view) {
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        view.draw(canvas);

        this.bitmap = returnedBitmap;
    }

    private View render(Story quote, ViewGroup root) {
        View storieLayout = LayoutInflater.from(context).inflate(R.layout.storie_layout, root, false);

        ImageView quoteBackground = storieLayout.findViewById(R.id.story_layout_background);
        Picasso.get().load(quote.getBackground()).fit().centerCrop().into(quoteBackground);

        TextView quoteContent = storieLayout.findViewById(R.id.quote_story_content);
        quoteContent.setText(quote.getContent());

        return storieLayout;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }
}
