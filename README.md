# ConstraintSetAnimation

### It is a simple project that makes animations using [constraintSet](https://developer.android.com/reference/android/support/constraint/ConstraintSet).
<br/>

<img src="https://github.com/Jiyunn/ConstraintSetAnimation/blob/master/screenshot/video.gif" width="300" height="613" /></a>



## How it works

#### The components in both layouts to be animated must have the same ID.

1. layout_first.xml

```
<androidx.constraintlayout.widget.ConstraintLayout 
    xmlns:android = "http://schemas.android.com/apk/res/android"
    xmlns:app = "http://schemas.android.com/apk/res-auto"
    android:id = "@+id/constraint_photo"
    >

    <ImageView
        android:id = "@+id/img_photo"
        android:layout_width = "0dp"
        android:layout_height = "0dp"
        app:layout_constraintBottom_toBottomOf = "parent"
        app:layout_constraintEnd_toEndOf = "parent"
        app:layout_constraintStart_toStartOf = "parent"
        app:layout_constraintTop_toTopOf = "parent"
        />


    <TextView
        android:id = "@+id/text_photo"
        android:layout_width = "match_parent"
        android:layout_height = "wrap_content"
        app:layout_constraintTop_toBottomOf = "parent"
        />
```

2. layout_second.xml

```
<androidx.constraintlayout.widget.ConstraintLayout 
    xmlns:android = "http://schemas.android.com/apk/res/android"
    xmlns:app = "http://schemas.android.com/apk/res-auto"
    >

    <ImageView
        android:id = "@+id/img_photo"
        android:layout_width = "match_parent"
        android:layout_height = "350dp"
        app:layout_constraintStart_toStartOf = "parent"
        app:layout_constraintTop_toTopOf = "parent"
        />

    <TextView
        android:id = "@+id/text_date"
        android:layout_width = "wrap_content"
        android:layout_height = "wrap_content"
        app:layout_constraintBottom_toBottomOf = "@+id/img_photo"
        />

    <TextView
        android:id = "@+id/text_photo"
        android:layout_width = "match_parent"
        android:layout_height = "wrap_content"
        app:layout_constraintTop_toBottomOf = "@+id/text_date"
        />
```


3. Your activity.

```
  ConstraintSet().apply {
            clone(this@PhotoActivity, R.layout.layout_second) //clone detail layout.

            ChangeBounds().apply { //you can customize.
                duration = 1100
                interpolator = AnticipateOvershootInterpolator(0.5f)

                TransitionManager.beginDelayedTransition(constraint_photo, this)
            }

            applyTo(constraint_photo)
        }
```



## Notice
This project's gradle version is `3.2.1`

