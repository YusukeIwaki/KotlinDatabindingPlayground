package io.github.yusukeiwaki.kotlindatabindingplayground

import android.text.TextUtils

fun User.displayName(): String {
    return if (TextUtils.isEmpty(name)) "名無しの権兵衛" else name
}