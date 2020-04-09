package di_sample
/**
 * 實作介面方法
 */
class Weather : IWeather {
    override fun isSunny(): Boolean {
        return true
    }
}