package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public abstract class Tag {
    protected String nameTag;
    protected Map<String, String> attributes;

    public Tag(String nameTag, Map<String, String> attributes) {
        this.nameTag = nameTag;
        this.attributes = attributes;
    }

    public String getNameTag() {
        return nameTag;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    protected String renderAttributes() {
        return attributes.entrySet()
                .stream()
                .map(entry -> entry.getKey() + "=\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(" "));
    }

    public abstract String toString();


}
// END
