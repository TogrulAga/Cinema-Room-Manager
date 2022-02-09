package cinema

fun main() {
    val cinema = Cinema()

    cinema.start()
}

class Cinema {
    private var nRows: Int
    private var nSeatsPerRow: Int
    private var soldTickets = mutableListOf<List<Int>>()
    private var totalSeats: Int

    init {
        println("Enter the number of rows:")
        nRows = readln().toInt()

        println("Enter the number of seats in each row:")
        nSeatsPerRow = readln().toInt()

        totalSeats = nRows * nSeatsPerRow
    }

    fun start() {
        do {
            println("1. Show the seats")
            println("2. Buy a ticket")
            println("3. Statistics")
            println("0. Exit")
            val answer = readln().toInt()

            if (answer == 1) printSeats() else if (answer == 2) sellTicket() else if (answer == 3) printStats()
        } while (answer != 0)
    }

    private fun printSeats() {
        print("Cinema:\n ")
        for (i in 1..nSeatsPerRow) {
            print(" $i")
        }

        println()

        for (j in 1..nRows) {
            print(j)

            for (k in 1..nSeatsPerRow) {
                if (listOf(j, k) in soldTickets) {
                    print(" B")
                } else {
                    print(" S")
                }
            }

            println()
        }
    }

    private fun sellTicket() {
        var selectedRow: Int
        var selectedSeat: Int
        while (true) {
            println("Enter a row number:")
            selectedRow = readln().toInt()

            println("Enter a seat number in that row:")
            selectedSeat = readln().toInt()

            if (listOf(selectedRow, selectedSeat) in soldTickets) {
                println("That ticket has already been purchased!")
                continue
            } else if (selectedRow !in 1..nRows || selectedSeat !in 1..nSeatsPerRow) {
                println("Wrong input!")
                continue
            }

            break
        }

        soldTickets.add(listOf(selectedRow, selectedSeat))

        ticketPrice(selectedRow)
    }

    private fun ticketPrice(selectedRow: Int) {
        if (nRows * nSeatsPerRow <= 60) {
            println("Ticket price: \$10")
            return
        }

        if (selectedRow in 1..nRows / 2) {
            println("Ticket price: \$10")
        } else {
            println("Ticket price: \$8")
        }
    }

    private fun printStats() {
        println("Number of purchased tickets: ${soldTickets.count()}")
        println("Percentage: %.2f%%".format(soldTickets.count().toDouble() / (nRows * nSeatsPerRow) * 100))

        var currentIncome = 0
        for ((row, _) in soldTickets) {
            currentIncome += if (totalSeats <= 60) {
                10
            } else {
                if (row in 1..nRows / 2) 10 else 8
            }
        }

        println("Current income: \$$currentIncome")
        totalIncome()
    }

    private fun totalIncome() {
        if (totalSeats <= 60) {
            println("Total income:\n\$${nRows * nSeatsPerRow * 10}")
        } else {
            val frontRows = nRows / 2
            val backRows = nRows - nRows / 2

            println("Total income: \$${(frontRows * 10 + backRows * 8) * nSeatsPerRow}")
        }
    }
}
