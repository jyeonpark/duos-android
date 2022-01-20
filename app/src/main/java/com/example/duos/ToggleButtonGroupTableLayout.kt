package com.example.duos

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TableLayout
import android.widget.TableRow


class ToggleButtonGroupTableLayout : TableLayout, View.OnClickListener {

    var checkedRadioButtonId: Int =
        if (activeRadioButton != null) {
            activeRadioButton!!.id
        } else -1

    /**
     * @param context
     */
    constructor(context: Context?) : super(context) {        // TODO Auto-generated constructor stub
    }

    /**
     * @param context
     * @param attrs
     */
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context,
        attrs
    ) {        // TODO Auto-generated constructor stub
    }

    override fun onClick(v: View) {
        val rb = v as RadioButton
        if (activeRadioButton != null) {
            activeRadioButton!!.isChecked = false
        }
        rb.isChecked = true
        activeRadioButton = rb
        checkedRadioButtonId = activeRadioButton!!.id
    }

    /* (non-Javadoc)
     * @see android.widget.TableLayout#addView(android.view.View, int, android.view.ViewGroup.LayoutParams)
     */
    override fun addView(
        child: View, index: Int,
        params: ViewGroup.LayoutParams
    ) {
        super.addView(child, index, params)
        setChildrenOnClickListener(child as TableRow)
    }

    /* (non-Javadoc)
     * @see android.widget.TableLayout#addView(android.view.View, android.view.ViewGroup.LayoutParams)
     */
    override fun addView(child: View, params: ViewGroup.LayoutParams) {
        super.addView(child, params)
        setChildrenOnClickListener(child as TableRow)
    }

    private fun setChildrenOnClickListener(tr: TableRow) {
        val c = tr.childCount
        for (i in 0 until c) {
            val v = tr.getChildAt(i)
            (v as? RadioButton)?.setOnClickListener(this)
        }
    }

    override fun onSaveInstanceState(): Parcelable? {
        val bundle = Bundle()
        bundle.putParcelable("superState", super.onSaveInstanceState())
        activeRadioButton?.let { bundle.putInt("stuff", it.id) } // ... save stuff
        return bundle
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        var state = state
        if (state is Bundle) // implicit null check
        {
            val bundle = state
            this.checkedRadioButtonId = bundle.getInt("stuff") // ... load stuff
            activeRadioButton = findViewById(checkedRadioButtonId)
            state = bundle.getParcelable("superState")
        }
        super.onRestoreInstanceState(state)
    }

    companion object {
        private const val TAG = "ToggleButtonGroupTableLayout"
        var activeRadioButton: RadioButton? = null
    }
}