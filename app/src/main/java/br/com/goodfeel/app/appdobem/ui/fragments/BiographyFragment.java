package br.com.goodfeel.app.appdobem.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;

import br.com.goodfeel.app.appdobem.R;
import br.com.goodfeel.app.appdobem.domain.Author;
import br.com.goodfeel.app.appdobem.ui.activity.AuthorOverviewActivity;


public class BiographyFragment extends Fragment {

    private static final String TAG = "biofragment";

    private AuthorOverviewActivity activity;

    private TextView authorBiography;

    public BiographyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        activity = (AuthorOverviewActivity) getActivity();

        View itemView = inflater.inflate(R.layout.fragment_biography, container, false);

        authorBiography = itemView.findViewById(R.id.author_biography);
        authorBiography.setText(activity.getAuthor().getDescription());

        return itemView;
    }

}
