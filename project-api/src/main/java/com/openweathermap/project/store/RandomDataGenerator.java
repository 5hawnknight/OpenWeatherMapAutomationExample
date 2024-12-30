package com.openweathermap.project.store;

import com.openweathermap.project.library.ConfigurationFactory;
import com.openweathermap.project.models.Location;

import java.util.List;
import java.util.Random;
import java.util.function.Function;

public interface RandomDataGenerator extends ConfigurationFactory {

    Function<Integer,Integer> randomInteger = max -> new Random().nextInt(max);

    static <T> T randomListItem(List<T> list) {
        return list.get(randomInteger.apply(list.size()));
    }

     static Location getRandomLocation() {
        List<String> locations = configuration.getStringList ("locations");
        return randomListItem(locations.stream().map(Location::of).toList());
    }
}
