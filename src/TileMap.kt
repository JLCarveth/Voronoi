class TileMap(val size : Int) {
    /**
     * The 2D Array / Matrix filled with 0s represents an empty TileMap
     */
    private val tiles = Array(size) { Array(size) { 0 } }
    /**
     * The number of tiles which have been "assigned" / given a value
     */
    private val tileCount = 0

    /**
     * TODO replace t with a dedicated Tile class
     * Assigns data to a coordinate on the map
     * @param x the x coordinate
     * @param y the y coordinate
     * @param t the data to be assigned to the tile
     */
    fun placeTile(x : Int, y : Int, t : Int) {
        if (tiles[y][x] == 0) {
            tileCount + 1
        }
        tiles[y][x] = t
    }

    fun getTile(x : Int, y : Int) : Int {
        return tiles[y][x]
    }

    fun getTilePoint(x : Int, y : Int) : Point<Int> {
        if (x < 0 || y < 0 || x > size-1 || y > size-1) {
            throw IndexOutOfBoundsException("Point ($x, $y) out of bounds on TileMap of size $size.")
        }
        val p = Point<Int>(x,y)
        p.data = tiles[y][x]
        return p
    }

    /**
     * Gets all adjacent points that exist on the tilemap
     * @throws Point.CoordinatesOutOfBoundsException if the point given does not exist in TileMap
     */
    fun getAdjacentPoints(p : Point<Int>) : ArrayList<Point<Int>> {
        if (p.x > size || p.x < 0 || p.y > size || p.y < 0) {
            throw Point.CoordinatesOutOfBoundsException(p, size)
        }
        // TODO Might be a better way to handle if an adjacent point is outofbounds
        // Maybe a function that adds the point if it exists, or does nothing
        try {
            val leftPoint = getTilePoint(p.x-1, p.y)
            val rightPoint = getTilePoint(p.x+1, p.y)
            val topPoint = getTilePoint(p.x,p.y-1)
            val bottomPoint = getTilePoint(p.x, p.y+1)

            val al = ArrayList<Point<Int>>()
            // If the point lies in top-left
            if (p.x == 0 && p.y == 0) {
                al.add(bottomPoint)
                al.add(rightPoint)
            } else if (p.x == size-1 && p.y == 0) {
                // If the point lies in top-right
                al.add(leftPoint)
                al.add(bottomPoint)
            } else if (p.x == size-1 && p.y == size-1) {
                // If the point lies in the bottom-right
                al.add(topPoint)
                al.add(leftPoint)
            } else if (p.x == 0 && p.y == size-1) {
                // If the point lies in the bottom left
                al.add(topPoint)
                al.add(rightPoint)
            } else if (p.y == 0) {
                // If it lies on the top
                al.add(bottomPoint)
                al.add(leftPoint)
                al.add(rightPoint)
            } else if (p.y == size-1) {
                // If it lies on the bottom
                al.add(topPoint)
                al.add(leftPoint)
                al.add(rightPoint)
            } else if (p.x == 0) {
                // If it lies on the left size
                al.add(topPoint)
                al.add(bottomPoint)
                al.add(rightPoint)
            } else if (p.x == size-1) {
                // If it lies on the left size
                al.add(topPoint)
                al.add(bottomPoint)
                al.add(leftPoint)
            } else {
                al.add(topPoint)
                al.add(bottomPoint)
                al.add(rightPoint)
                al.add(leftPoint)
            }

            return al
        } catch (e : IndexOutOfBoundsException) { }

        return ArrayList<Point<Int>>()
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

    fun isTileMapFull() : Boolean {
        return tileCount == (size * size)
    }
}