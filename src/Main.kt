fun main(args : Array<String>) {
    val viewer = TileMapViewer(Generator.generateVoronoi(200, 500, 4))
    Generator.generateGrowth(1000, 100, 3)
}