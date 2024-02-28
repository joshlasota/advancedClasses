class Employee(
    private val name: String,
    private val position: PositionTitle,
    private val isSalary: Boolean,
    private val payRate: Double,
    private val shift: Int
) {
    fun display() {
        println("$name\n${position.name} Is salary: $isSalary shift: $shift\nRate of pay is: $$payRate per hour")
    }

    fun calculate(hoursIn: Double) {
        var totalPay: Double
        val overtimePayRate = if (isSalary) payRate / 40 * 1.5 else payRate * 1.5

        totalPay = if (hoursIn <= 40) {
            payRate * hoursIn
        } else {
            if (isSalary) payRate * 40 else payRate * 40 + overtimePayRate * (hoursIn - 40)
        }

        // Apply shift bonus
        totalPay *= when (shift) {
            2 -> 1.05 // 5% higher for second shift
            3 -> 1.10 // 10% higher for third shift
            else -> 1.0 // no bonus for other shifts
        }

        println("$name earned $${"%.2f".format(totalPay)} this week")
    }
}
