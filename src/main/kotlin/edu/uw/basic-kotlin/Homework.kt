package edu.uw.basickotlin

// write a "whenFn" that takes an arg of type "Any" and returns a String
fun whenFn(arg: Any): String {
    when (arg) {
        is String -> {
            return if (arg == "Hello") "world"
            else "Say what?"
        }
        is Int -> {
            when (arg) {
                0 -> return "zero"
                1 -> return "one"
                in 2..10 -> return "low number"
                else -> {
                    return "a number"
                }
            }
        }
        else -> {
            return "I don't understand"
        }
    }
}
// write an "add" function that takes two Ints, returns an Int, and adds the values
fun add(lhs: Int, rhs: Int): Int {
    return lhs + rhs
}

// write a "sub" function that takes two Ints, returns an Int, and subtracts the values
fun sub(lhs: Int, rhs: Int): Int {
    return lhs - rhs
}

// write a "mathOp" function that takes two Ints and a function (that takes two Ints and returns an Int), returns an Int, and applies the passed-in-function to the arguments
fun mathOp(lhs: Int, rhs: Int, op: (Int, Int) -> Int) = op(lhs, rhs)


// write a class "Person" with first name, last name and age
class Person(val firstName: String, val lastName: String, var age: Int) {
    val debugString = "[Person firstName:${this.firstName} lastName:${this.lastName} age:${this.age}]"
}

// write a class "Money"
class Money(val amount: Int, val currency: String) {
    init {
        if (amount < 0) {
          throw IllegalArgumentException("Currency cannot be less than 0")
        } else if (currency != "USD" && currency != "GBP" && currency != "CAN" && currency != "EUR") {
          throw IllegalArgumentException("Not accepted Currency")
        }
    }
    fun convert(newCurrency: String): Money {
        var converted = amount
        if (currency == "USD") {
            if(newCurrency == "EUR") {
                converted = amount*3/2
            }
            if(newCurrency == "CAN")
                converted = amount*5/4
            }
            if(newCurrency == "GBP") {
                converted = amount/2
            }
        if (currency == "EUR") {
            if(newCurrency == "USD") {
                converted = amount*2/3
            }
            if(newCurrency == "CAN") {
                converted = amount*6/5
            }
            if(newCurrency == "GBP") {
                converted = amount/3
            }
        }
        if (currency == "CAN") {
            if(newCurrency == "USD") {
                converted = amount*4/5
            }
            if(newCurrency == "EUR") {
                converted = amount*6/5
            }
            if(newCurrency == "GBP") {
                converted = amount*2/5
            }
        }
        if (currency == "GBP") {
            if(newCurrency == "USD") {
                converted = amount*2
            }
            if(newCurrency == "EUR") {
                converted = amount*3
            }
            if(newCurrency == "CAN") {
                converted = amount*5/2
            }
        }
        return Money(converted, newCurrency)
    }
    operator fun plus(other: Money): Money {
        val result: Int = this.amount + other.convert(this.currency).amount
        return Money(result, this.currency)
    }
}