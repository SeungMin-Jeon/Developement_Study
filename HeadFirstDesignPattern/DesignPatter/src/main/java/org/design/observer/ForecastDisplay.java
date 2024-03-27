package org.design.observer;

public class ForecastDisplay implements Observer, DisplayElement{

    private WeatherData weatherData;
    private float currentPressure = 29.92f;
    private float lastPressure;

    public ForecastDisplay(WeatherData weatherDate) {
        this.weatherData = weatherDate;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("현재 상태: 압력 " + currentPressure
                + "이전 압력" + lastPressure + "%");
    }

    @Override
    public void update() {
        lastPressure = currentPressure;
        currentPressure = weatherData.getPressure();
        display();
    }


}
