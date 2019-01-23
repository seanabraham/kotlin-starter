package me.seanabraham

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON

class App {
    val greeting: String
        get() {
            return "Hello world."
        }
}

@Serializable
data class Data(val a: Int, @Optional val b: String = "30")

fun main(args: Array<String>) {
    println(JSON.stringify(Data.serializer(), Data(42)))
    println(JSON.parse(Data.serializer(), """{"a": 10}"""))
}
