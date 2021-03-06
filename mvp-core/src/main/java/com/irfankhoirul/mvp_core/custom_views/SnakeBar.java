package com.irfankhoirul.mvp_core.custom_views;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.irfankhoirul.mvp_core.R;

import static com.irfankhoirul.mvp_core.custom_views.ConstantStatus.STATUS_ERROR;
import static com.irfankhoirul.mvp_core.custom_views.ConstantStatus.STATUS_INFO;
import static com.irfankhoirul.mvp_core.custom_views.ConstantStatus.STATUS_SUCCESS;
import static com.irfankhoirul.mvp_core.custom_views.ConstantStatus.STATUS_WARNING;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public class SnakeBar {
    private SnakeBar instance;
    private View root;
    private String message;
    private String actionName;
    private int length;
    private View.OnClickListener listener;
    private int type;
    private Activity activity;

    public SnakeBar() {

    }

    public SnakeBar builder(Activity activity) {
        instance = new SnakeBar();
        instance.activity = activity;
        return instance;
    }

    public SnakeBar setRoot(View root) {
        this.root = root;
        return this;
    }

    public SnakeBar setMessage(String message) {
        this.message = message;
        return this;
    }

    public SnakeBar setActionName(String actionName) {
        this.actionName = actionName;
        return this;
    }

    public SnakeBar setLength(int length) {
        this.length = length;
        return this;
    }

    public SnakeBar setActionListener(View.OnClickListener listener) {
        this.listener = listener;
        return this;
    }

    public SnakeBar setType(int type) {
        this.type = type;
        return this;
    }

    public void show() {
        Snackbar snackbar = Snackbar
                .make(root, message, length)
                .setAction(actionName, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onClick(view);
                    }
                });

        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);

        switch (type) {
            case STATUS_INFO:
                sbView.setBackgroundColor(ContextCompat.getColor(sbView.getContext(), R.color.light_blue_100));
                textView.setTextColor(ContextCompat.getColor(activity, R.color.light_blue_700));
                break;

            case STATUS_SUCCESS:
                sbView.setBackgroundColor(ContextCompat.getColor(sbView.getContext(), R.color.light_green_100));
                textView.setTextColor(ContextCompat.getColor(activity, R.color.light_green_700));
                break;

            case STATUS_WARNING:
                sbView.setBackgroundColor(ContextCompat.getColor(sbView.getContext(), R.color.orange_100));
                textView.setTextColor(ContextCompat.getColor(activity, R.color.orange_700));
                break;

            case STATUS_ERROR:
                sbView.setBackgroundColor(ContextCompat.getColor(sbView.getContext(), R.color.red_100));
                textView.setTextColor(ContextCompat.getColor(activity, R.color.red_700));
                break;
        }

        snackbar.setActionTextColor(ContextCompat.getColor(activity, R.color.pure_white));
        snackbar.show();
    }

}
