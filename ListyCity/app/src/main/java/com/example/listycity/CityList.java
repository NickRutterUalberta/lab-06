package com.example.listycity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();
    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }
    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }
    /**
     * Return true if the given city is in the list.
     * @param city the city to check
     * @return true if the city exists in the list, false otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Remove the city if present; otherwise throw an exception.
     * @param city the city to remove
     * @throws IllegalArgumentException if the city is not found
     */
    public void delete(City city) {
        if (!cities.remove(city)) {
            throw new IllegalArgumentException("City not found: " + city);
        }
    }

    /**
     * Return the number of cities in the list.
     * @return the number of cities currently stored
     */
    public int countCities() {
        return cities.size();
    }


}