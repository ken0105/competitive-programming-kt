package util

private class UnionFind(size: Int) {
    private val data: Array<Int> = Array(size) { -1 }

    fun find(x: Int): Int {
        return if (data[x] < 0) {
            x
        } else {
            // パス圧縮
            data[x] = find(data[x])
            data[x]
        }
    }

    fun unite(x: Int, y: Int): Boolean {
        val parentX = find(x)
        val parentY = find(y)
        if (isSame(parentX, parentY)) return false
        // merge by rank
        if (parentX < parentY) {
            data[parentY] = parentX
        } else {
            data[parentX] = parentY
        }
        return true
    }

    fun isSame(x: Int, y: Int): Boolean {
        return find(x) == find(y)
    }
}