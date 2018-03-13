package com.github.jlcarveth.gui

import com.github.jlcarveth.main.TileMap
import javax.swing.JFrame

/**
 * A JFrame class that allows for a visualization of com.github.jlcarveth.main.TileMap classes.
 *
 * We will add other User Interfaces here later, to help making generations
 */
class TileMapViewer(val tilemap : TileMap) : JFrame("Tile Map") {
    init {
        this.add(TileMapPanel(tilemap))
        isVisible = true
        isResizable = true
        pack()
        defaultCloseOperation = EXIT_ON_CLOSE
    }

}