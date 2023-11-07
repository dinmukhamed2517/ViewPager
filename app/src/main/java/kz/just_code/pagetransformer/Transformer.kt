package kz.just_code.pagetransformer

import android.view.View
import androidx.viewpager2.widget.ViewPager2.PageTransformer

class Transformer:PageTransformer {
    private val minScale = 0.85f
    override fun transformPage(page: View, position: Float) {
        val width = page.width
        when{
            position < -1 -> page.alpha = 0f
            position <= 0  -> {
                page.alpha = 1f
                page.translationX = 0f
                page.scaleX = 1f
                page.scaleY = 1f

            }
            position <=1 -> {
                page.alpha = 1f - position
                page.translationX = width * -position
                val scale = minScale + (1- minScale) * (1- Math.abs(position))
                page.scaleY = scale
                page.scaleX = scale
            }
            else -> page.alpha = 0f
        }
    }
}