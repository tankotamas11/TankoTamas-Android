
import types.HasSetDictionary
import types.TreeSetDictionary

class DictionaryProvider (){

    companion object{
        fun createDictionary(type: DictionaryType):IDictionary{
            return when (type){
                DictionaryType.ARRAY_LIST -> ListDictionary
                DictionaryType.TREE_SET -> TreeSetDictionary
                DictionaryType.HAS_SET -> HasSetDictionary

            }
        }
    }
}