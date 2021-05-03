package util

import java.lang.Long.max
import java.lang.Long.min

class Util {
    private fun isPrime(num: Int): Boolean {
        for (i in 2..num) {
            if (i * i > num) break
            if (num % i == 0) return false
        }
        return true
    }

    private fun <T> gcd(x: T, y: T): Long {
        when (x) {
            is Int -> x.toLong()
            is Double -> x.toLong()
        }
        when (y) {
            is Int -> y.toLong()
            is Double -> y.toLong()
        }
        var a = max(x as Long, y as Long)
        var b = min(x, y)
        while (a % b != 0L) {
            a = b.also { b = a % b }
        }
        return b
    }

    private fun <T> lcm(x: T, y: T): Long {
        when (x) {
            is Int -> x.toLong()
            is Double -> x.toLong()
        }
        when (y) {
            is Int -> y.toLong()
            is Double -> y.toLong()
        }
        return x as Long * y as Long / gcd(x, y)
    }

    private fun ncr(n: Int, r: Int): Int {
        var r = r
        r = Integer.min(n - r, r)
        if (r == 0) return 1
        val over = ((n-r+1)..n).reduce(Int::times)
        val under = (1..r).reduce(Int::times)
        println(listOf(n,r,over,under))
        return over / under
    }
}