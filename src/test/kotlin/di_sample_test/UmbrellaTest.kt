package di_sample_test

import di_sample.Umbrella
import org.junit.Assert
import org.junit.Test

/**
 * 運用DI將測試所需的物件解相依，
 * 並透過介面實作來建立假的測試物件。
 */
class UmbrellaTest {
    /**
     * 測試晴天
     */
    @Test
    fun totalPrice_sunnyDay(){
        val umbrella = Umbrella()
        // 1. 建立假的天氣物件
        val weather = StubWeather()

        // 2. 設定天氣為晴天狀態
        weather.fakeIsSunny = true

        // 3. 呼叫被測試的方法
        val totalPrice = umbrella.totalPrice(weather, 1, 200)
        val expected = 180
        Assert.assertEquals(expected, totalPrice)
    }

    /**
     * 測試雨天
     */
    @Test
    fun totalPrice_rainyDay() {
        val umbrella = Umbrella()
        val weather = StubWeather()

        weather.fakeIsSunny = false

        val totalPrice = umbrella.totalPrice(weather, 2, 300)
        val expected = 600
        Assert.assertEquals(expected,totalPrice)
    }
}

