package com.github.jlcarveth.main

/**
 * Class for keeping track of groups of Points / tiles
 * Has methods for getting adjacent points and # of points in the group
 */
class PointGroup<E>(val data : E) {
    val points = ArrayList<Point<E>>()

    /**
     * Adds a com.github.jlcarveth.main.Point to the com.github.jlcarveth.main.PointGroup.
     * @return true if the point was added to the group successfully.
     */
    fun addPoint(p : Point<E>) : Boolean{
        return if (points.contains(p)) {
            false
        } else {
            points.add(p)
            true
        }
    }

    /**
     * The number of tiles in the
     */
    fun getGroupSize() : Int { return points.count() }
}