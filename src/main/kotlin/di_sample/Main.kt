package di_sample

fun main() {
    val weather : IWeather = Weather()
    val umbrella = Umbrella(weather)
    val totalPrice = umbrella.totalPrice(1,600) // weather,1,600)

    println("TotalPrice: NTD $totalPrice-")
}