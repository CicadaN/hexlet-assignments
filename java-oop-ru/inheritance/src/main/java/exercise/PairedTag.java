package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {

    private String body;
    private List<Tag> children;

    public PairedTag(String nameTag, Map<String, String> attributes, String body, List<Tag> children) {
        super(nameTag, attributes);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        String childrenString = children.stream()
                .map(Tag::toString)
                .collect(Collectors.joining());
        return "<" + nameTag + (attributes.isEmpty() ? "" : " " + renderAttributes()) + ">"
                + body + childrenString + "</" + nameTag + ">";
    }
}
// END
