package com.codepirates.myapplicationtask

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countryCode.setOnCountryChangeListener {
            //click only on flag and set a code country in textview
            code.text = countryCode.selectedCountryCodeWithPlus
        }
        et_mobile_number.setOnClickListener {
            changeState(false)
        }

        et_mobile_number.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (et_mobile_number.text?.isEmpty() == true) {
                    changeState(true)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (et_mobile_number.text?.isEmpty() == true) {
                    changeState(true)
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (et_mobile_number.text?.isEmpty() == true) {
                    changeState(true)
                } else {
                    changeState(false)
                }
            }
        })
    }

    private fun changeState(isNormalState: Boolean) {
        if (isNormalState) {
            // when be normal state
            phoneContainer.setBackgroundResource(R.drawable.rounded_stroke_gry)
            focasBtn.setTextColor(Color.parseColor("#AFAEAF"))
        } else {
            // when be active state
            phoneContainer.setBackgroundResource(R.drawable.rounded_stroke_bb)
            focasBtn.setTextColor(Color.parseColor("#AA00FF"))
        }
    }
}