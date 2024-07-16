package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    public SingleTag(String nameTag, Map<String, String> attributes) {
        super(nameTag, attributes);
    }

    @Override
    public String toString() {
        return "<" + nameTag + (attributes.isEmpty() ? "" : " " + renderAttributes()) + ">";
    }
}
// END
