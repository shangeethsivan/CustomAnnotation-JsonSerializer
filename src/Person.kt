import chikuserializer.annotations.Init
import chikuserializer.annotations.JsonElement
import chikuserializer.annotations.JsonSerialize

@JsonSerialize
class Person {

    @JsonElement(key = "name")
    lateinit var name: String

    @JsonElement(key = "age")
    var age: Int = 0

    @JsonElement(key = "home_town")
    lateinit var homeTown: String

    @Init
    private fun initialize() {
        name = "Kumar"
        age = 56
        homeTown = "Trichy"
    }
}