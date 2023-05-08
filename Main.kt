import java.util.LinkedList

fun main() {
        val upperLimit = 10_000_000
        val sets = IntArray(upperLimit + 1)
        val signifies1Link = 1
        val signifies89Link = 89
        var count = 1
        sets[1] = signifies1Link
        sets[89] = signifies89Link

        fun updateSets(chain: LinkedList<Int>, set: Int) {
            chain.forEach { sets[it] = set }
        }

        (1..upperLimit).forEach { chainStart ->
            var currentChainLink = chainStart
            val chain = LinkedList<Int>()
            while (true) {
                if (sets[currentChainLink] == signifies1Link) {
                    updateSets(chain, signifies1Link)
                    return@forEach
                }
                if (sets[currentChainLink] == signifies89Link) {
                    updateSets(chain, signifies89Link)
                    count += chain.size
                    return@forEach
                }
                chain.add(currentChainLink)

                var sumSquare = 0
                while (currentChainLink > 0) {
                    val remainder = currentChainLink % 10
                    sumSquare += remainder*remainder
                    currentChainLink /= 10
                }
                currentChainLink = sumSquare
            }
        }

        println(count)
}
