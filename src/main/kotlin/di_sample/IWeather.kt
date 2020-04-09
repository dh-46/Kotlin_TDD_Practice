package di_sample

/**
 * 依賴注入解法
 * 建立 IWeather介面，並讓原本的 Weather物件實作這個介面
 */
interface IWeather {
    fun isSunny(): Boolean
}