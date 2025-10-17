package com.example.listycity;
import org.junit.Test;
import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }
    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }
    @Test
    public void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    private void assertThrows(Class<IllegalArgumentException> illegalArgumentExceptionClass, City o) {
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
        @Test
        public void has_delete_count_minimal() {
            CityList list = new CityList();
            City edm = new City("Edmonton", "AB");

            assertEquals(0, list.countCities());
            list.add(edm);
            assertTrue(list.hasCity(edm));
            assertEquals(1, list.countCities());

            list.delete(edm);
            assertFalse(list.hasCity(edm));
            assertEquals(0, list.countCities());
        }

        @Test(expected = IllegalArgumentException.class)
        public void delete_throws_when_absent() {
            new CityList().delete(new City("Calgary", "AB"));
        }

}
