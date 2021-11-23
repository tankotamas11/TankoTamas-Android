package types

import IDictionary
import java.io.File
import java.io.InputStream
import java.util.*

object TreeSetDictionary : IDictionary{
    private var words : TreeSet<String> = TreeSet()

    init{
        val input : InputStream = File("labor2/src/${IDictionary.filename}").inputStream()
        input.bufferedReader().forEachLine { add(it) }
    }

    override fun add(dict: String): Boolean{
        if(!find(dict)){
            words.add(dict)
            return true
        }
        return false
    }

    override fun find(dict: String): Boolean {
        if(words.find {it.contains(dict)} != null){
            return true
        }
        return false
    }

    override fun size(): Int {
        return words.size
    }
}