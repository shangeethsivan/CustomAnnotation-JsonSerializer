import chikuserializer.ChikuSerializer

fun main() {
    val serializer = ChikuSerializer()
    val person = Person()
    print(serializer.convertToJson(person))
}