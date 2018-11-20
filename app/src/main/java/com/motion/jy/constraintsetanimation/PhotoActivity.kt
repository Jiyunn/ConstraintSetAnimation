package com.motion.jy.constraintsetanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.AnticipateOvershootInterpolator
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_photo.*
import android.view.WindowManager


class PhotoActivity : AppCompatActivity() {

    private var isDetailShown = false //whether detail view is shown.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS) //for transparent statusBar.

        img_photo.setOnClickListener {
            if(!isDetailShown) showDetail() else hideDetail()
        }
    }

    private fun showDetail() {
        isDetailShown = true

        ConstraintSet().apply {
            clone(this@PhotoActivity, R.layout.layout_photo_detail) //clone detail layout.

            ChangeBounds().apply {
                duration = 1100
                interpolator = AnticipateOvershootInterpolator(0.5f)

                TransitionManager.beginDelayedTransition(constraint_photo, this)
            }

            applyTo(constraint_photo)
        }
    }

    private fun hideDetail() {
        isDetailShown = false

        ConstraintSet().apply {
            clone(this@PhotoActivity, R.layout.activity_photo) //clone detail layout.

            ChangeBounds().apply {
                duration = 1100
                interpolator = AnticipateOvershootInterpolator(0.8f)

                TransitionManager.beginDelayedTransition(constraint_photo, this)
            }

            applyTo(constraint_photo)
        }
    }
}
