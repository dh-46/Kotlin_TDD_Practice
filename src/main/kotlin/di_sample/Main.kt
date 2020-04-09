package di_sample

fun main() {
    val weather : IWeather = Weather()
    val umbrella = Umbrella()
    val totalPrice = umbrella.totalPrice(weather,1,600)

    println("TotalPrice: NTD $totalPrice-")
}