package com.github.jlcarveth.util

import java.awt.Color
import java.util.*

object ColorPicker {

    fun randomColor() : Color {
        val r = Random()
        val c = Color(r.nextInt(255), r.nextInt(255), r.nextInt(255))
        println("ColorPicker: Generated (R${c.red}, G${c.green}, B${c.blue})")
        return c
    }

}