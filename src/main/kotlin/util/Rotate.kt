package util

private class Rotate(val base: Vector, val center: Vector = Vector(0.0, 0.0)) {
    fun rotate(degree: Double): Vector {
        val base = base - center
        val sin = Math.sin(Math.toRadians(degree))
        val cos = Math.cos(Math.toRadians(degree))
        return Vector(base.x * cos - base.y * sin, base.x * sin + base.y * cos) + center
    }
}

private data class Vector(val x: Double, val y: Double) {
    operator fun minus(other: Vector): Vector {
        return Vector(x - other.x, y - other.y)
    }
    operator fun plus(other: Vector): Vector {
        return Vector(x + other.x, y + other.y)
    }
}