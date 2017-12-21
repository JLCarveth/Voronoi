import java.awt.Color
import java.awt.GridLayout
import javax.swing.JFrame
import javax.swing.JPanel

/**
 * A JFrame class that allows for a visualization of TileMap classes.
 * TODO: Better color system, to support n 'biome' colors
 */
class TileMapViewer(val tilemap : TileMap) : JFrame("Tile Map") {
    init {
        super.setLayout(GridLayout(tilemap.size, tilemap.size))
        populate()
        isVisible = true
        isResizable = false
        pack()
        defaultCloseOperation = EXIT_ON_CLOSE
    }

    fun populate() {
        for (y in 0 until tilemap.size) {
            for (x in 0 until tilemap.size) {
                val panel = JPanel()

                when (tilemap.getTilePoint(x,y).data) {
                    0 -> panel.background = Color.GREEN
                    1 -> panel.background = Color.BLUE
                    2 -> panel.background = Color.decode("#D2691E")
                    3 -> panel.background = Color.PINK
                    4 -> panel.background = Color.YELLOW
                    5 -> panel.background = Color.CYAN
                    else -> panel.background = Color.BLACK
                }

                this.add(panel)
            }
        }
    }
}