package ru.asselinux.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        slider.addOnChangeListener { _, percentage, _ ->
            val value = edit_text.text.toString().toLongOrNull()
                ?: return@addOnChangeListener text_view.setText("")
            display(value, percentage.toInt())
        }

        edit_text.doAfterTextChanged {
            val value = it?.toString()?.toLongOrNull()
                ?: return@doAfterTextChanged text_view.setText("")
            display(value, slider.value.toInt())
        }
    }

    private fun display(bill: Long, percentage: Int) {
        text_view.text = getString(R.string.display, bill, percentage)
    }
}