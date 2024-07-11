package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    protected Map<String, String> attributes;
    protected String tagName;

    public Tag(String tagName, Map<String, String> attributes) {
        this.attributes = attributes;
        this.tagName = tagName;
    }

    protected String getAttributesString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            sb.append(entry.getKey()).append("=\"").append(entry.getValue()).append("\" ");
        }
        return sb.toString().trim();
    }

    public String getAtribute() {
        return atribute;
    }

    public void setAtribute(String atribute) {
        this.atribute = atribute;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
// END
