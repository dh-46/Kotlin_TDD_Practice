package di_sample_test

import di_sample.IWeather
import di_sample.Umbrella
import di_sample.Weather
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

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
        // 1. 建立假的天氣物件
        val weather = StubWeather()
        val umbrella = Umbrella(weather)

        // 2. 設定天氣為晴天狀態
        weather.fakeIsSunny = true

        // 3. 呼叫被測試的方法
        val totalPrice = umbrella.totalPrice(1, 200) // weather, 1, 200)
        val expected = 180
        Assert.assertEquals(expected, totalPrice)
    }

    /**
     * 測試晴天 (使用Mockito框架)
     * BTW 單元測試也是可以設定中斷點，執行Debug來方便除錯。
     */
    @Test
    fun totalPrice_sunnyDay_withMockito(){
        // 1. 建立假的天氣物件
        val weather = mock(IWeather::class.java)
        val umbrella = Umbrella(weather)

        // 2. 設定天氣為晴天狀態(mockito)
        // 當呼叫到weather.isSunny()，回傳true
        `when`(weather.isSunny()).thenReturn(true)

        // 3. 呼叫被測試的方法
        val totalPrice = umbrella.totalPrice(1, 200) // weather, 1, 200)
        val expected = 180
        Assert.assertEquals(expected, totalPrice)
    }


    /**
     * 測試雨天
     */
    @Test
    fun totalPrice_rainyDay() {
        val weather = StubWeather()
        val umbrella = Umbrella(weather)

        weather.fakeIsSunny = false

        val totalPrice = umbrella.totalPrice(2,300) //weather, 2, 300)
        val expected = 600
        Assert.assertEquals(expected,totalPrice)
    }
}

