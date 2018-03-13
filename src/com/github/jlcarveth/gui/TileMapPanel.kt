package com.github.jlcarveth.gui

import com.github.jlcarveth.main.TileMap
import com.github.jlcarveth.util.ColorPicker
import java.awt.Color
import java.awt.GridLayout
import javax.swing.JPanel

/**
 * A Custom JPanel that displays data in TileMap objects.
 * TODO: Make color choice configurable
 */
class TileMapPanel(val tilemap : TileMap) : JPanel() {
    init {
        super.setLayout(GridLayout(tilemap.size, tilemap.size))
        populate()
    }

    /**
     * Private function to
     */
    private fun populate() {
        val colorPalette : ArrayList<Color> = ArrayList()
        // Start with a color palette of 20 colors
        for (x in 0..10) {
            colorPalette.add(ColorPicker.randomColor())
        }

        for (y in 0 until tilemap.size) {
            for (x in 0 until tilemap.size) {
                val tile = JPanel()
                val temp = tilemap.getTilePoint(x,y)

                while (temp.data!! >= colorPalette.count()) {
                    println(colorPalette.count())
                    colorPalette.add(ColorPicker.randomColor())
                }

                tile.background = colorPalette[tilemap.getTile(x,y)]
                this.add(tile)
            }
        }
    }

}