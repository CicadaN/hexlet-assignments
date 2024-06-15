package exercise;

import java.util.Map;
import java.util.HashMap;

public class FileKV implements KeyValueStorage {
    private String filePath;
    private Map<String, String> storage;

    public FileKV(String filePath, Map<String, String> initial) {
        this.filePath = filePath;
        this.storage = new HashMap<>(initial);
        save();
    }

    private void save() {
        String data = Utils.serialize(storage);
        Utils.writeFile(filePath, data);
    }

    private void load() {
        String data = Utils.readFile(filePath);
        this.storage = Utils.unserialize(data);
    }

    @Override
    public void set(String key, String value) {
        load();
        storage.put(key, value);
        save();
    }

    @Override
    public void unset(String key) {
        load();
        storage.remove(key);
        save();
    }

    @Override
    public String get(String key, String defaultValue) {
        load();
        return storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        load();
        return new HashMap<>(storage);
    }
}
