package com.irfankhoirul.mvp_core.base;

import android.support.annotation.Nullable;

/**
 * Berisi daftar method yang diimplementasikan oleh view dan dipanggil dari presenter
 * atau/dan view itu sendiri
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since 1.0 (7 November 2016)
 */

public interface BaseView<T> {
    void setPresenter(T presenter);

    void setLoadingDialog(boolean isLoading, @Nullable String message);

    void showStatus(int type, String message);
}
