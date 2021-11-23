interface IDictionary {
    companion object{
        val filename = "bemenet.txt"
    }
    fun add(dict : String) : Boolean
    fun find(dict : String) : Boolean
    fun size(): Int
}