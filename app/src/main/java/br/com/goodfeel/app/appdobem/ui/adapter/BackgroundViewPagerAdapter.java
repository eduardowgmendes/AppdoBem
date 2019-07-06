package br.com.goodfeel.app.appdobem.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.goodfeel.app.appdobem.R;

public class BackgroundViewPagerAdapter extends PagerAdapter {

    private Context context;
    private List<String> backgroundsURLs;

    public BackgroundViewPagerAdapter(Context context, List<String> backgroundsURLs) {
        this.context = context;
        this.backgroundsURLs = backgroundsURLs;
    }

    @Override
    public int getCount() {
        return backgroundsURLs.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View item = LayoutInflater.from(context).inflate(R.layout.background_selector_layout, container, false);

        ImageView background = item.findViewById(R.id.background);
        Picasso.get().load(backgroundsURLs.get(position)).fit().centerCrop().into(background);

        container.addView(item);

        return item;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
