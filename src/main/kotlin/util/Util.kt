package util

class Util {
    fun pow(base: Long, exp: Int, mod: Long? = null): Long {
        return when (exp) {
            0 -> 1L
            1 -> base
            else ->
                if (mod == null) {
                    pow(base * base, exp shr 1) * pow(base, exp and 1)
                } else {
                    pow(base * base % mod, exp shr 1, mod) * pow(base, exp and 1, mod) % mod
                }

        }
    }

    private fun isPrime(num: Int): Boolean {
        for (i in 2..num) {
            if (i * i > num) break
            if (num % i == 0) return false
        }
        return true
    }

    private fun gcd(x: Int, y: Int): Int {
        var a: Int = Integer.max(x, y)
        var b: Int = Integer.min(x, y)
        while (a % b != 0) {
            a = b.also { b = a % b }
        }
        return b
    }

    private fun lcm(x: Int, y: Int): Int {
        return x * y / gcd(x, y)
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