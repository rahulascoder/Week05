package com.day2_json;
import org.json.JSONObject;

class Car {
    //Atrributes
    private String make;
    private String model;
    private int year;

    // Constructor
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Converting Car object to JSON
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("make", this.make);
        json.put("model", this.model);
        json.put("year", this.year);
        return json;
    }
}

public class CarToJSON {
    public static void main(String[] args) {
        // Creating a Car object
        Car car = new Car("Thar", "Black", 2022);

        // Converting Car object to JSON
        System.out.println(car.toJSON().toString(2));
    }
}