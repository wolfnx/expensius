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

package com.mvcoding.expensius.feature.premium

import android.app.Activity
import android.content.Intent
import com.mvcoding.expensius.Settings
import com.mvcoding.expensius.SubscriptionType.FREE
import com.mvcoding.expensius.SubscriptionType.PREMIUM_PAID
import rx.Observable.just

class DummyRemoteBillingProductsService(private val settings: Settings) : RemoteBillingProductsService, BillingFlow {
    override fun billingProducts() = just(listOf(
            BillingProduct("premium_1", FREE, "Premium 1", "Unlocks all features", "3.99", settings.subscriptionType == PREMIUM_PAID),
            BillingProduct("premium_2", FREE, "Premium 2", "Unlocks all features", "5.99", false),
            BillingProduct("premium_3", FREE, "Premium 3", "Unlocks all features", "7.99", false),
            BillingProduct("donation_1", PREMIUM_PAID, "Donation 1", "Donation", "1.99", false),
            BillingProduct("donation_2", PREMIUM_PAID, "Donation 2", "Donation", "3.99", false),
            BillingProduct("donation_3", PREMIUM_PAID, "Donation 3", "Donation", "4.99", false),
            BillingProduct("donation_4", PREMIUM_PAID, "Donation 4", "Donation", "7.99", false)))

    override fun dispose() = Unit
    override fun startPurchase(activity: Activity, requestCode: Int, productId: String) = just(Unit)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) = true
}