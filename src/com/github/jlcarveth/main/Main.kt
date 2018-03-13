package com.github.jlcarveth.main

import com.github.jlcarveth.gui.TileMapViewer

fun main(args : Array<String>) {
    val viewer = TileMapViewer(Generator.generateVoronoi(1000, 500, 15))
}