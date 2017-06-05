package com.irfankhoirul.mvp_core.data;

import com.irfankhoirul.mvp_core.base.BasePojo;

/**
 * Merupakan interface yang berfungsi sebagai listener hasil query menggunakan retrofit
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (13 November 2016)
 * @since 1.0
 */

public interface RequestResponseListener<T extends BasePojo> {
    void onSuccess(DataResult<T> result);

    void onFailure(Throwable throwable);
}
