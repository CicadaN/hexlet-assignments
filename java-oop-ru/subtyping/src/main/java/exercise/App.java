package exercise;

import java.util.Map;
import java.util.Set;

public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        // Получаем текущие данные из базы данных
        Map<String, String> originalMap = storage.toMap();

        // Создаем набор для хранения записей
        Set<Map.Entry<String, String>> entries = originalMap.entrySet();

        // Проходим по всем записям оригинального словаря
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();

            // Удаляем текущую запись из базы данных
            storage.unset(key);

            // Добавляем новую запись, поменяв местами ключ и значение
            storage.set(value, key);
        }
    }
}
