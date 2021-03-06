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

package com.mvcoding.expensius.feature.calculator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.mvcoding.expensius.R
import com.mvcoding.expensius.feature.ActivityStarter
import com.mvcoding.expensius.feature.BaseActivity
import com.mvcoding.expensius.feature.calculator.CalculatorPresenter.ResultDestination.BACK
import com.mvcoding.expensius.feature.calculator.CalculatorPresenter.ResultDestination.TRANSACTION
import java.math.BigDecimal

class CalculatorActivity : BaseActivity() {
    companion object {
        private const val EXTRA_INITIAL_NUMBER = "EXTRA_INITIAL_NUMBER"
        private const val EXTRA_RESULT_DESTINATION = "EXTRA_RESULT_DESTINATION"

        fun start(context: Context) {
            ActivityStarter(context, CalculatorActivity::class)
                    .extra(EXTRA_RESULT_DESTINATION, TRANSACTION)
                    .start()
        }

        fun startWithInitialNumberForResult(context: Context, requestCode: Int, initialNumber: BigDecimal) {
            ActivityStarter(context, CalculatorActivity::class)
                    .extra(EXTRA_INITIAL_NUMBER, initialNumber)
                    .extra(EXTRA_RESULT_DESTINATION, BACK)
                    .startForResult(requestCode)
        }

        fun resultExtraAmount(data: Intent) = data.getSerializableExtra(CalculatorView.RESULT_EXTRA_AMOUNT) as BigDecimal
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_calculator)

        val initialNumber = intent.getSerializableExtra(EXTRA_INITIAL_NUMBER) as BigDecimal?
        val resultDestination = intent.getSerializableExtra(EXTRA_RESULT_DESTINATION) as CalculatorPresenter.ResultDestination
        val calculatorView = findViewById(R.id.calculatorView) as CalculatorView
        calculatorView.init(initialNumber, resultDestination)
    }
}