package com.irfankhoirul.mvp_core.base;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.irfankhoirul.mvp_core.R;
import com.irfankhoirul.mvp_core.custom_views.SnakeBar;
import com.irfankhoirul.mvp_core.custom_views.Toaster;

import butterknife.Unbinder;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public abstract class BaseDialog<T extends Activity, U extends BasePresenter> extends DialogFragment {

    protected Unbinder unbinder;
    protected T activity;
    protected AlertDialog loadingDialog;
    protected View fragmentView;
    protected U mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mPresenter == null) {
            this.dismiss();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (T) context;
    }

    @Override
    public void onDetach() {
        this.activity = null;
        super.onDetach();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    protected void setLoadingDialog(boolean isLoading, @Nullable String message) {
        if (isLoading) {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity);
            LayoutInflater inflater = this.getLayoutInflater(null);
            View dialogView = inflater.inflate(R.layout.dialog_loading, null);
            TextView tvMessage = (TextView) dialogView.findViewById(R.id.tvMessage);
            tvMessage.setText(message);
            dialogBuilder.setView(dialogView);
            loadingDialog = dialogBuilder.create();
            loadingDialog.setCancelable(false);
            loadingDialog.show();
        } else {
            if (loadingDialog != null) {
                loadingDialog.dismiss();
            }
        }
    }

    protected void showStatus(int type, String message) {
//        showSnackBar(type, message, null, null, null);
        showToast(type, message);
    }

    protected void showSnackBar(int type, String message, String action, View root, View.OnClickListener listener) {
        new SnakeBar().builder(activity)
                .setMessage(message)
                .setActionName(action)
                .setLength(Snackbar.LENGTH_SHORT)
                .setRoot(fragmentView)
                .setType(type)
                .setActionListener(listener)
                .show();
    }

    protected void showToast(int type, String message) {
        new Toaster().builder(activity)
                .setType(type)
                .setMessage(message)
                .show();
    }
}
