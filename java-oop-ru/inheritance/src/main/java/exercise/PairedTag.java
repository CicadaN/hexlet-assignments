   package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag{
    private String tagContent;
    private List<Tag> children;

    public PairedTag(String tagName, Map<String, String> attributes, String tagContent, List<Tag> children) {
        super(tagName, attributes);
        this.tagContent = tagContent;
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("<%s %s>", tagName, getAttributesString()));
        for (Tag child : children) {
            sb.append(child.toString());
        }
        sb.append(tagContent);
        sb.append(String.format("</%s>", tagName));
        return sb.toString();
    }
}
// END
