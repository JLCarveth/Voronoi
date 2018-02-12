data class Point<E>(val x : Int, val y : Int) {
    var data : E? = null

    /**
     * Returns the Euclidean Distance between two points
     */
    fun getDistance(p : Point<E>) : Double {
        return Math.sqrt(Math.pow((this.x - p.x).toDouble(),2.0)
                + Math.pow((this.y - p.y).toDouble(), 2.0))
    }

    override fun equals(other: Any?): Boolean {
        return if (other is Point<*>) {
            (other.x == this.x && other.y == this.y && other.data == this.data)
        } else {
            false
        }
    }

    class CoordinatesOutOfBoundsException(p: Point<*>, size: Int) :
            Exception("(${p.x}, ${p.y}) out of bounds for size : $size.") {
    }

}