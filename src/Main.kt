fun main() {
    val serializer = ShangeethSerializer()
    val person = Person()
    print(serializer.convertToJson(person))
}