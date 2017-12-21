class TileMap(val size : Int) {
    private val tiles = Array(size) { Array(size) { 0 } }

    /**
     * TODO replace t with a dedicated Tile class
     */
    fun placeTile(x : Int, y : Int, t : Int) {
        tiles[y][x] = t
    }

    fun getTile(x : Int, y : Int) : Int {
        return tiles[y][x]
    }

    fun getTilePoint(x : Int, y : Int) : Point<Int> {
        val p = Point<Int>(x,y)
        p.data = tiles[y][x]
        return p
    }

    override fun toString() : String {
        val sb = StringBuilder()
        for (t in tiles) {
            sb.append(t.joinToString(" "))
            sb.append("\n")
        }
        return sb.toString()
    }

    fun getTiles() : Array<Array<Int>> {
        return tiles
    }
}