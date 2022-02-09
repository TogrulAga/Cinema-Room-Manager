fun parseCardNumber(cardNumber: String): Long {
    if (cardNumber.any { !it.isDigit() && it != ' ' }) {
        throw Exception("A correct card number should consist of digits and spaces!")
    }

    if (cardNumber.count() != 19) {
        throw Exception("A card number must have 16 digits and 3 spaces!")
    }

    if (cardNumber.split(" ").any { it.length != 4 }) {
        throw Exception("THe card number must consist of 4 pieces of 4 digits!")
    }

    return cardNumber.replace(" ", "").toLong()
}