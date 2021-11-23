import DictionaryProvider.Companion.createDictionary
import kotlin.collections.ArrayList
import kotlin.math.roundToInt

fun exercise1(){
    val dict: IDictionary = ListDictionary //TreeSetDictionary
    println("Number of words: ${dict.size()}")
    var word: String?
    while(true){
        print("What to find? ")
        word = readLine()
        if( word.equals("quit")){
            break
        }
        println("Result: ${word?.let { dict.find(it) }}")
    }

    val dictionary : IDictionary = createDictionary(DictionaryType.HAS_SET)
    println("\n\nNumber of words: ${dictionary.size()}")
}

fun exercise2(){
    val list= arrayListOf("apple","pear","melon")
    val separator="#"

    list.merge(separator)

   // list.longest()
}
fun MutableList<String>.merge(separator: String)  = println(this.joinToString(separator))

//fun MutableList<String>.longest()  = println(this.maxByOrNull { it.length }.toString())

fun String.monogram() = println(this.split(" ").map { it[0] }.joinToString(""))



fun Date.isLeapYear() : Boolean {
    var leapYear = false

    if (this.year % 4 == 0) {
        leapYear = if (this.year % 100 == 0) {
            this.year % 400 == 0
        } else
            true
    }
    return leapYear
}


fun Date.validateDate() : Boolean {
    var isValid = false
    if (this.year > 0) {
        if (this.month in 1..12) {
            if (this.day in 1..31) {
                isValid = true
            }
        }
    }
    return isValid
}

fun createRandomIntBetween(start: Int, end: Int): Int {
    return start + (Math.random() * (end - start)).roundToInt()
}

fun createRandomDate(start : Int, end : Int) : Date {
    val day = createRandomIntBetween(1, 28);
    val month = createRandomIntBetween(1, 12);
    val year = createRandomIntBetween(start, end);
    return Date(year, month, day)
}

fun printRandomDateList(list: List<Date>) {
    list.forEach { println(it) }
}

fun exercise3() {
    val date = Date()
    println("Is leap year: " + date.isLeapYear())

    var validDates = 0
    val randomDatesList: MutableList<Date> = ArrayList()

    while (validDates <= 10) {
        val randomDates = createRandomDate(1900, 2000)
        if (randomDates.validateDate()) {
            validDates++
            randomDatesList.add(randomDates)
        } else {
            println(randomDates)
        }
    }


    printRandomDateList(randomDatesList)
    println("Sorted list:")
    randomDatesList.sort()
    printRandomDateList(randomDatesList)


    println("Reversed list:")
    randomDatesList.reverse()
    printRandomDateList(randomDatesList)


    val date1 = Date(1990, 12, 12)
    val date2 = Date(1990, 11, 10)
    print(date1 == date2)
}

fun main(){
    //exercise1()
    //exercise2()
    exercise3()
}