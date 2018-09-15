package com.colinares.tictactoe.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.colinares.tictactoe.Constants.AppConstants;
import com.colinares.tictactoe.R;
import com.colinares.tictactoe.Utils.ThemeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Colinares on 9/14/2018.
 */

public class FragAbout extends Fragment {

    Unbinder unbinder;

    public FragAbout() {
    }

    private View mView;

    private ThemeUtils themeUtils;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.frag_layout_about, null, false);

        themeUtils = new ThemeUtils(getContext());

        unbinder = ButterKnife.bind(this, mView);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (themeUtils.loadNightMode()) {
            getActivity().setTheme(R.style.DarkTheme);
        } else {
            getActivity().setTheme(R.style.AppTheme);
        }

    }

    @OnClick({R.id.about_fab_fb, R.id.about_fab_linkedin, R.id.about_fab_github})
    public void setViewOnClick(View v) {
        switch (v.getId()) {
            case R.id.about_fab_fb:
                String fb = AppConstants.DEV_FB;
                goIntent(fb);
                break;
            case R.id.about_fab_linkedin:
                String linkedIn = AppConstants.DEV_LINKED_IN;
                goIntent(linkedIn);
                break;
            case R.id.about_fab_github:
                String gitHub = AppConstants.DEV_GITHUB;
                goIntent(gitHub);
                break;
        }
    }

    private void goIntent(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(i);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
