package id.ac.pnj.fauzan.jamilah

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import androidx.core.content.res.ResourcesCompat

class StarsView : View {
    private val starPaint = Paint()
    private var stars: ArrayList<Star> = arrayListOf()
    constructor(context: Context): super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        stars.apply {
            add(Star(1, 1))
            add(Star(2, 2))
            add(Star(3, 3))
            add(Star(4, 4))
            add(Star(5, 5))

        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = getDefaultSize(suggestedMinimumWidth, widthMeasureSpec)
        val height = getDefaultSize(suggestedMinimumHeight, heightMeasureSpec)
        val oneFifthWidth = width / 5
        var xValue = -350F
        for (i in 0..4) {
            stars[i].apply {
                x = xValue
                y = height.toFloat()
            }
            xValue += 150
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)


        for (star in stars) {
            drawStar(canvas, star)
        }
    }

    private fun drawStar(canvas: Canvas?, star: Star) {
        starPaint.style = Paint.Style.FILL
        starPaint.color = ResourcesCompat.getColor(resources, R.color.gray_77, null)

        canvas?.save()
        canvas?.translate(star.x as Float, star.y as Float)

        val starPath = Path()
        starPath.apply {
            moveTo(0F, 40F)
            lineTo(80F, 100F)
            lineTo(50F, 0F)
            lineTo(20F, 100F)
            lineTo(100F, 40F)
            lineTo(0F, 40F)
        }
        starPath.close()
        canvas?.drawPath(starPath, starPaint)

        canvas?.restore()
    }

}

data class Star(
    val id: Int,
    val value: Int,
    var x: Float? = 0F,
    var y: Float? = 0F,
)