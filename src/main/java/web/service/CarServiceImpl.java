package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {
    private static int cars_count;
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car(++cars_count, "BMW", 34));
        cars.add(new Car(++cars_count, "Ford", 1969));
        cars.add(new Car(++cars_count, "Moskvich", 2101));
        cars.add(new Car(++cars_count, "Volvo", 90));
        cars.add(new Car(++cars_count, "GTI", 403));
    }

    public List<Car> getCarsByCount(int count) {
        return cars.stream().limit(count).toList();
    }
}
