package poligon.algorithms.graphs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PathFinderTest {

    private val connections = """
            krk waw
            waw gda
            waw szy
            krk wro
            wro poz
            poz kos
            krk kos
        """.trimIndent()

    private val sg = SymbolGraph.load(connections, " ")

    private val krkIdx = sg.index("krk")
    private val wawIdx = sg.index("waw")
    private val gdaIdx = sg.index("gda")
    private val szyIdx = sg.index("szy")
    private val kosIdx = sg.index("kos")

    @Test
    fun shouldFindPathUsingRecursiveDFS() {
        val finder = PathFinder.deepSearch(sg.graph(), krkIdx)

        assertTrue(finder.hasPathTo(wawIdx))
        assertTrue(finder.hasPathTo(gdaIdx))
        assertTrue(finder.hasPathTo(szyIdx))

        assertEquals(listOf(krkIdx, wawIdx), finder.pathTo(wawIdx))
        assertEquals(listOf(krkIdx, wawIdx, szyIdx), finder.pathTo(szyIdx))
    }

    @Test
    fun shouldFindPathUsingBFS() {
        val finder = PathFinder.bfs(sg.graph(), krkIdx)

        assertTrue(finder.hasPathTo(wawIdx))
        assertTrue(finder.hasPathTo(gdaIdx))
        assertTrue(finder.hasPathTo(szyIdx))

        assertEquals(listOf(krkIdx, wawIdx), finder.pathTo(wawIdx))
        assertEquals(listOf(krkIdx, wawIdx, szyIdx), finder.pathTo(szyIdx))

        // BFS should find the shortest path:
        assertEquals(listOf(krkIdx, kosIdx), finder.pathTo(kosIdx))
    }

}