package exercise.dto.posts;

import exercise.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
@Setter
public class PostsPage {
    private List<Post> posts;
    private int currentPage;
    private boolean hasPrevious;
    private boolean hasNext;
}
