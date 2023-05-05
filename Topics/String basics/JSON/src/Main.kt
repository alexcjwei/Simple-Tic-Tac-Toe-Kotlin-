fun main() {
    val text = """
        {
            "firstName": "John",
            "lastName": "Smith",
            "age": 35,
            "phoneNumbers": [
                {
                    "type": "mobile",
                    "number": "123 567-7890"
                }
            ]
        }
    """.trimIndent()
    println(text)
}