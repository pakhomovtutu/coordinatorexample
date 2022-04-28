package com.example.bottommenucoordinator.behaviors

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat

class HideToolbarBehaviorActivity() : CoordinatorLayout.Behavior<View>() {

    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: View,
        directTargetChild: View,
        target: View,
        axes: Int, // ось по которй была произведена прокрутка
        type: Int
    ): Boolean {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
    }

    override fun onNestedPreScroll(
        coordinatorLayout: CoordinatorLayout,
        child: View,// Toolbar
        target: View,
        dx: Int, // Количество пикселей которые будут прокручены по горизонтали
        dy: Int, // Количество пикселей которые будут прокручены по вертикали
        consumed: IntArray,
        type: Int
    ) {
        // При прокрутке вниз dy положительный, при прокрутке вверх отрицательный
        if(dy > 0 ) animateHide(child) else animateShow(child)
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
    }

    // Анимация смещения тулбара за экран
    private fun animateHide(child: View) =
        ObjectAnimator.ofPropertyValuesHolder(
            child,
            PropertyValuesHolder.ofFloat("translationY", -child.height.toFloat())
        ).apply {
            duration = 500
        }.start()

    // Анимация показа тулбара
    private fun animateShow(child: View) =
        ObjectAnimator.ofPropertyValuesHolder(
            child,
            PropertyValuesHolder.ofFloat("translationY", 0f)
        ).apply {
            duration = 500
        }.start()

}