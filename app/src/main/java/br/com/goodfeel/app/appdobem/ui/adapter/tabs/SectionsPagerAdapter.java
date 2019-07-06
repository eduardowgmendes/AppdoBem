package br.com.goodfeel.app.appdobem.ui.adapter.tabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.com.goodfeel.app.appdobem.ui.fragments.BiographyFragment;
import br.com.goodfeel.app.appdobem.ui.fragments.QuoteFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new QuoteFragment();

            case 1:
                return new BiographyFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Frases";
            case 1:
                return "Biografia";
        }

        return null;
    }
}
