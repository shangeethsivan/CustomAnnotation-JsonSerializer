package chikuserializer

import chikuserializer.exception.CannotSerializeException
import chikuserializer.annotations.Init
import chikuserializer.annotations.JsonElement
import chikuserializer.annotations.JsonSerialize

class ChikuSerializer {

    fun convertToJson(any: Any): String {
        checkIfSerializable(any)
        initializeObjects(any)
        return getJsonString(any)
    }

    private fun checkIfSerializable(any: Any) {
        val clazz = any.javaClass
        if (!clazz.isAnnotationPresent(JsonSerialize::class.java)) {
            throw CannotSerializeException()
        }
    }

    private fun initializeObjects(any: Any) {
        val clazz = any.javaClass
        for (method in clazz.declaredMethods) {
            if (method.isAnnotationPresent(Init::class.java)) {
                method.isAccessible = true
                method.invoke(any)
            }
        }
    }

    private fun getJsonString(any: Any): String {
        val clazz = any.javaClass
        val keyValueMap = mutableMapOf<String, Any>()
        for (field in clazz.declaredFields) {
            if (field.isAnnotationPresent(JsonElement::class.java)) {
                val key = field.getAnnotation(JsonElement::class.java).key
                field.isAccessible = true
                val value = field.get(any)
                val finalValue = when (value) {
                    is Int -> value.toString()
                    is String -> value
                    is Float -> value.toString()
                    else -> error("Unknown Type")
                }
                keyValueMap[key] = finalValue
            }
        }
        return keyValueMap.toString()
    }
}