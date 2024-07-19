package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;


// BEGIN
class App {
    public static void save(Path path, Car car) throws IOException {
        String json = car.serialize(car);
        Files.write(path, json.getBytes());
    }

    public static Car extract(Path path) throws IOException {
        String json = Files.readString(path);
        return Car.unserialize(json);
    }
}
// END
