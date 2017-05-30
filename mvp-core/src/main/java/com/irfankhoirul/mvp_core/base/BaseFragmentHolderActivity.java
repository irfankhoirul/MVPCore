package com.irfankhoirul.mvp_core.base;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.irfankhoirul.mvp_core.R;
import com.irfankhoirul.mvp_core.R2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public abstract class BaseFragmentHolderActivity extends BaseActivity {

    @BindView(R2.id.tvToolbarTitle)
    protected TextView tvToolbarTitle;
    @BindView(R2.id.flFragmentContainer)
    protected FrameLayout flFragmentContainer;
    @BindView(R2.id.btOptionMenu)
    protected ImageButton btOptionMenu;
    @BindView(R2.id.ivIcon)
    protected ImageView ivIcon;
    @BindView(R2.id.btBack)
    protected ImageButton btBack;
    @BindView(R2.id.vMenuBarShadow)
    protected View vMenuBarShadow;
    @BindView(R2.id.rlActivityFragmentHolder)
    protected RelativeLayout rlActivityFragmentHolder;

    @Override
    protected void initializeView() {
        setContentView(R.layout.activity_fragment_holder);
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.btBack)
    public void btBack() {
        onBackPressed();
    }

}
