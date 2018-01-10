package io.github.yusukeiwaki.kotlindatabindingplayground

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

class UserNameTextView : TextView {
    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {}

    fun setUser(user: User?) {
        setText(user?.displayName() ?: "-")
    }
}
