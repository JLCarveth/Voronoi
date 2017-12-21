import java.util.*

/**
 *
 */
object Generator {

    fun generate(size : Int, detail : Int, biome : Int) : TileMap {
        val points = getCenterPoints(detail, size, biome)

        val tilemap = TileMap(size)

        for (p in points) {
            tilemap.placeTile(p.x, p.y, p.data!!)
        }


        for (y in 0 until size) {
            for (x in 0 until size) {
                val p = getClosestCenterPoint(tilemap.getTilePoint(x,y), points)
                tilemap.placeTile(x,y,p.data!!)
            }
        }

        return tilemap
    }

    private fun getCenterPoints(detail: Int, size : Int, biome : Int): ArrayList<Point<Int>> {
        val points = ArrayList<Point<Int>>()

        for (i in 0..detail) {
            val r = Random()
            val x = r.nextInt(size - 1)
            val y = r.nextInt(size - 1)
            val b = r.nextInt(biome)

            println("$x,$y")

            if (!points.contains(Point(x,y))) {
                println("Not contained")
                val p = Point<Int>(x,y)
                p.data = b

                points.add(p)
            }
        }

        return points
    }

    private fun getClosestCenterPoint(point : Point<Int>, points : ArrayList<Point<Int>>) : Point<Int> {
        var minPoint = points[0]
        var minDist = 999999.9
        for (p in points) {
            val dist = point.getDistance(p)
            if (dist < minDist) {
                minDist = dist
                minPoint = point

                minPoint.data = p.data
            }

        }
        return minPoint
    }
}