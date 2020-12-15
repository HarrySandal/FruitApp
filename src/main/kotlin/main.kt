fun main(args: Array<String>) {
    var filteredList:Array<String>
    var appleCount:Int
    var orangeCount:Int
    var totalCost: Double
    val appleStock:Int = 10
    val orangeStock:Int = 10

    filteredList=filterData(args)
    appleCount= filteredList.count { it == "apple" }
    orangeCount= filteredList.count { it == "orange" }

    appleCount = offerOnApple(appleCount)
    orangeCount = offerOnOrange(orangeCount)

    if (appleStock > appleCount && orangeStock > orangeCount) {
        totalCost = (fruit(appleCount, 0.60) + fruit(orangeCount, 0.25))
        printNotification(appleCount, orangeCount, totalCost)
    } else {
        println("Order out of stocks")
    }
}

fun filterData(args:Array<String>):Array<String>{
    var fruitList:Array<String>
    fruitList=args

    for(i in 0..fruitList.size-1){
        fruitList[i]=fruitList[i].removeSuffix(",")
        fruitList[i]=fruitList[i].toLowerCase()
    }

    return fruitList
}

fun offerOnApple(appleCount: Int): Int {
    var appleCountOffer = 0
    if (appleCount != 0) {
        appleCountOffer = appleCount * 2
        return appleCountOffer
    } else {
        return appleCount
    }
}

fun offerOnOrange(orangeCount: Int): Int {
    var orangeCountOffer = 0
    if (orangeCount != 0) {
        orangeCountOffer = orangeCount + orangeCount / 2
        return orangeCountOffer
    } else {
        return orangeCount
    }
}

fun fruit(count: Int, price: Double): Double {
    var totalPrice = count * price
    totalPrice="%.2f".format(totalPrice).toDouble()
    return totalPrice
}

fun printNotification(appleCount: Int, orangeCount: Int, totalCost: Double) {
    println("Order Confirmed \n\nOrder details: \n$appleCount Apples $orangeCount Oranges \nTotal cost $totalCost")
}