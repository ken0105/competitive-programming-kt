fun main() {
}

private fun next(): String = readLine()!!
private fun nextInt(): Int = next().toInt()
private fun nextLong(): Long = next().toLong()
private fun nextStrings(): List<String> = next().split(" ")
private fun nextInts(): List<Int> = nextStrings().map(String::toInt)
private fun nextLongs(): List<Long> = nextStrings().map(String::toLong)
private fun nextDoubles(): List<Double> = nextStrings().map(String::toDouble)
private const val MOD = 1000000007L

private fun <T> printList(l: List<T>) {
    kotlin.io.println(l.joinToString(" "))
}

private fun <T> println(vararg args: T) {
    val str = mutableListOf<String>()
    args.forEach { str.add(it.toString()) }
    printList(str)
}