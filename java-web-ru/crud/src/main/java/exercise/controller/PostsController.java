package exercise.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.util.NamedRoutes;

import java.util.List;
import java.util.Collections;

public class PostsController {

    public static void listPost(Context ctx) {
        int page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        int pageSize = 5;

        List<Post> posts = PostRepository.findAll(page, pageSize);
        int totalPosts = PostRepository.getEntities().size();

        boolean hasPrevious = page > 1;
        boolean hasNext = page * pageSize < totalPosts;

        var postsPage = new PostsPage(posts, page, hasPrevious, hasNext);
        ctx.render("posts/index.jte", Collections.singletonMap("page", postsPage));
    }

    public static void showPost(Context ctx) {
        long id = ctx.pathParamAsClass("id", Long.class).getOrDefault(null);

        Post post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Page not found"));

        var page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }
}