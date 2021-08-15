package tech.medina.tvshows.ui.utils

fun runIfNotNull(data: Any?, function:() -> Unit) {
    if (data == null) return
    function()
}