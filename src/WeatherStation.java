import java.util.Scanner;

/**

* WeatherStation handles data from the atomic missles in unalaska, alaska and okay, oklahoma.

* 1. imports

* 2. class header

* 3. properties

* 4. constructors

* 5. setters and getters

*/


public class WeatherStation {


public double temperature;

public double windSpeed;

public int windDirection;


//constructors


//accessors and Mutators


public double getTemperature() {

System.out.println(temperature);

return getTemperatureF();

}

public double getTemperatureC () {

return temperature;

}


public double getTemperatureF () {

return convertCtoF(temperature);

}


private double convertCtoF(double c) {

return c * 9 / 5 + 32;

}


private double convertFtoC(double f) {

return (f - 32) * 5 / 9;

}


public void setTemperature(double temperature) {

temperature = convertFtoC(temperature);

}

public double getWindSpeed() {

return windSpeed;

}

public int getWindDirection() {

return windDirection;

}


}

