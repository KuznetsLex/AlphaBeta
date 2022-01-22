package com.example.alphabeta

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView



class DrawingView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    //drawing path
    private val drawPath = Path()
    //drawing and canvas paint
    private val drawPaint = Paint()
    private val canvasPaint = Paint(Paint.DITHER_FLAG)
    //initial color
    private var paintColor = -0x0f
    private var paintAlpha = 255
    //canvas
    private var drawCanvas: Canvas? = null
    //canvas bitmap
    private lateinit var canvasBitmap: Bitmap
    //brush sizes

    private val medium = 70F


    init {
        setupDrawing()
    }

    private fun setupDrawing() {
        //prepare for drawing and setup paint stroke properties
        drawPaint.color = paintColor
        drawPaint.isAntiAlias = true
        drawPaint.style = Paint.Style.STROKE
        drawPaint.strokeJoin = Paint.Join.ROUND
        drawPaint.strokeCap = Paint.Cap.ROUND
        drawPaint.strokeWidth = medium

    }

    //size assigned to view
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        drawCanvas = Canvas(canvasBitmap)
    }

    //draw the view - will be called after touch event
    override fun onDraw(canvas: Canvas) {
        canvas.drawBitmap(canvasBitmap, 0f, 0f, canvasPaint)
        canvas.drawPath(drawPath, drawPaint)
    }

    //register user touches as drawing action
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val touchX = event.x
        val touchY = event.y
        //respond to down, move and up events
        when (event.action) {
            MotionEvent.ACTION_DOWN -> drawPath.moveTo(touchX, touchY)
            MotionEvent.ACTION_MOVE -> drawPath.lineTo(touchX, touchY)
            MotionEvent.ACTION_UP -> {
                drawPath.lineTo(touchX, touchY)
                drawCanvas?.drawPath(drawPath, drawPaint)
                drawPath.reset()
            }
            else -> return false
        }
        //redraw
        invalidate()
        return true
    }

    fun startNew() {
        drawCanvas?.drawColor(0, PorterDuff.Mode.CLEAR)
        invalidate()
    }

}