/*
 * Copyright (C) 2016 Mantas Varnagiris.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

package com.mvcoding.expensius.feature

import com.mvcoding.expensius.LoadingState
import com.mvcoding.expensius.LoadingState.LOADING

interface LoadingView : Presenter.View {
    fun showLoading()
    fun hideLoading()
}

fun LoadingView.showLoadingState(loadingState: LoadingState) = if (loadingState == LOADING) showLoading() else hideLoading()