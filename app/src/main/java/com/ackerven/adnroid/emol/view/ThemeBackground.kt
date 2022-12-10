package com.ackerven.adnroid.emol.view


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.ackerven.adnroid.emol.R

private val TAG = "ThemeBackground"

class ThemeBackground : View {
    private var bgColor: Int = Color.parseColor("#ECEDE4")
    private var lineColor: Int = Color.parseColor("#DCDDD8")
    private lateinit var paint: Paint
    private var space: Int = 3
    private var strokeWidth: Int = 50

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attributeSet: AttributeSet) : super(context, attributeSet, 0)

    constructor(context: Context?, attributeSet: AttributeSet, i: Int) :
            super(context, attributeSet, i)

    init {
        if (context != null) {
            this.strokeWidth = context.resources.getDimensionPixelSize(R.dimen.x2)
        }
        if (context != null) {
            this.space = context.resources.getDimensionPixelSize(R.dimen.x30)
        }
    }


    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(this.bgColor)
        this.paint = Paint()
        this.paint.color = this.lineColor
        this.paint.strokeJoin = Paint.Join.ROUND
        this.paint.strokeCap = Paint.Cap.ROUND
        this.paint.strokeWidth = this.strokeWidth.toFloat()
        val width = width
        val height = height
        val i = space
        val max = Math.max(width / i, height / i)
        var i2 = 0
        var i3 = 0
        for (i4 in 0..max) {
            val f = i2
            canvas?.drawLine(0.0f, f.toFloat(), width.toFloat(), f.toFloat(), this.paint)
            val f2 = i3
            canvas?.drawLine(f2.toFloat(), 0.0f, f2.toFloat(), height.toFloat(), this.paint)
            val i5 = this.space
            i2 += i5
            i3 += i5
        }
    }
}