package com.irfankhoirul.mvp_core.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.irfankhoirul.mvp_core.R;


public abstract class BaseActivity extends FragmentActivity implements BaseFragment.FragmentListener {

//    @BindView(R2.id.tvToolbarTitle)
//    protected TextView tvToolbarTitle;

    protected BaseFragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeView();
        initializeFragment();
    }

    protected abstract void initializeFragment();

    protected abstract void initializeView();

    protected void setCurrentFragment(BaseFragment fragment, boolean addToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (currentFragment != null && addToBackStack) {
            fragmentTransaction.addToBackStack(currentFragment.getTitle());
        }

        fragmentTransaction.replace(R.id.flFragmentContainer, fragment, fragment.getTitle());
        fragmentTransaction.commit();

        this.currentFragment = fragment;
    }

//    @Override
//    public void setTitle(String title) {
//        tvToolbarTitle.setText(title);
//    }
}
