package com.github.jlcarveth.main

import java.util.*

/**
 *
 */
object Generator {

    /**
     * Generates a com.github.jlcarveth.main.TileMap using the Voronoi generation algorithm
     */
    fun generateVoronoi(size : Int, detail : Int, biome : Int) : TileMap {
        val points = getCenterPoints(detail, size, biome)

        val tilemap = TileMap(size)

        for (p in points) {
            tilemap.placeTile(p.x, p.y, p.data!!)
        }


        for (y in 0 until size) {
            for (x in 0 until size) {
                val p = getClosestCenterPoint(tilemap.getTilePoint(x, y), points)
                tilemap.placeTile(x,y,p.data!!)
            }
        }

        return tilemap
    }

    /**
     * Generates a com.github.jlcarveth.main.TileMap through growth of centerpoints
     * Similar to the Voronoi generation, where we select centerpoints.
     * Each turn, these centerpoints can claim adjacent tiles equal to the
     * number of tiles currently in that centerpoint's 'biome'
     */
    fun generateGrowth(size : Int, detail : Int, biome : Int) : TileMap {
        val points = getCenterPoints(detail, size, biome)

        val tilemap = TileMap(size)
        val groups = ArrayList<PointGroup<Int>>()

        // Add the Centerpoints to their respective groups
        for (p in points) {
            val g = PointGroup<Int>(p.data!!)
            g.addPoint(p)
            groups.add(g)

            tilemap.placeTile(p.x ,p.y, p.data!!)
        }

        while (!tilemap.isTileMapFull()) {
            for (g in groups) {
                val adjPts = ArrayList<Point<Int>>()

                // For every point in the group, get available adj. tiles
                for (p in g.points) {
                    if (p.data == 0 && !adjPts.contains(p)) {
                        adjPts.add(p)
                    }
                }

                adjPts.shuffle()

                for (i in 0..g.getGroupSize()) {
                    tilemap.placeTile(adjPts[i].x, adjPts[i].y, g.data)
                    g.addPoint(adjPts[i])
                }
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

            if (!points.contains(Point(x, y))) {
                val p = Point<Int>(x, y)
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