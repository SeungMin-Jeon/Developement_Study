package org.design.observer;

public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionDisplay currentConditionDisplay =
                new CurrentConditionDisplay(weatherData);

        weatherData.setMeasuerments(80, 65, 30.4f);
        weatherData.setMeasuerments(20, 45, 20.4f);
    }
}
