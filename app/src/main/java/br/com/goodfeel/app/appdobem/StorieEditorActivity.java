package br.com.goodfeel.app.appdobem;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import br.com.goodfeel.app.appdobem.ui.adapter.BackgroundViewPagerAdapter;
import br.com.goodfeel.app.appdobem.ui.pagetransform.ZoomOutPageTransformer;

public class StorieEditorActivity extends AppCompatActivity {

    private List<String> URLs;
    private EditText quoteEditor;
    private ViewPager backgroundSelector;
    private BackgroundViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storie_editor);

        URLs = new ArrayList<>();
        URLs.add("https://cdn.pixabay.com/photo/2018/05/10/00/37/leaves-3386570_960_720.jpg");
        URLs.add("https://cdn.pixabay.com/photo/2012/08/27/14/19/evening-55067_960_720.png");
        URLs.add("https://cdn.pixabay.com/photo/2019/04/30/07/49/star-4167939_960_720.jpg");
        URLs.add("https://cdn.pixabay.com/photo/2016/02/13/12/26/aurora-1197753_960_720.jpg");

        adapter = new BackgroundViewPagerAdapter(this, URLs);
        backgroundSelector = findViewById(R.id.background_selector);
        backgroundSelector.setAdapter(adapter);
        backgroundSelector.setPageTransformer(false, new ZoomOutPageTransformer());
        quoteEditor = findViewById(R.id.quote_editor);
    }
}
