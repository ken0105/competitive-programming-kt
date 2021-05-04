package util

import java.util.PriorityQueue

fun main() {
    val (n, m) = nextInts()
    val adjList = Array(n) { mutableListOf<Pair<Int, Int>>() }
    repeat(m) {
        var (a, b, c) = nextInts()
        a -= 1
        b -= 1
        adjList[a].add(Pair(b, c))
        adjList[b].add(Pair(a, c))
    }
    val dijkstra1 = Dijkstra(0, n, adjList)
    val dijkstra2 = Dijkstra(n - 1, n, adjList)
    for (i in 0 until n) {
        println(dijkstra1.dist[i] + dijkstra2.dist[i])
    }
}

private class Dijkstra(start: Int, node: Int, adjList: Array<MutableList<Pair<Int, Int>>>) {
    val dist = IntArray(node) { Int.MAX_VALUE }.also { it[start] = 0}

    init {
        val confirmed = BooleanArray(node)

        val candidates = PriorityQueue(node) { x: Candidate, y: Candidate -> x.distance - y.distance }
            .apply { add(Candidate(0, start)) }

        while (candidates.size > 0) {
            val candidate = candidates.remove().town
            if (confirmed[candidate]) continue else confirmed[candidate] = true
            for ((to: Int, weight: Int) in adjList[candidate]) {
                if (!confirmed[to] && dist[to] > dist[candidate] + weight) {
                    dist[to] = dist[candidate] + weight
                    candidates.add(Candidate(dist[to], to))
                }
            }
        }
    }
    private class Candidate(val distance: Int, val town: Int)
}

private fun next(): String = readLine()!!
private fun nextStrings(): List<String> = next().split(" ")
private fun nextInts(): List<Int> = nextStrings().map(String::toInt)