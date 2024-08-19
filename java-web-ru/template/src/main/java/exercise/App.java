package exercise;

import io.javalin.Javalin;

import java.util.Collections;
import java.util.List;
import exercise.model.User;
import io.javalin.rendering.template.JavalinJte;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/users", ctx -> {
            ctx.render("users/index.jte", Collections.singletonMap("users", USERS));
        });

        app.get("/users/{id}", ctx -> {
            long id = Long.parseLong(ctx.pathParam("id"));

            var user = USERS.stream()
                    .filter(u -> u.getId() == id)
                    .findFirst()
                    .orElse(null);

            if (user != null) {
                ctx.render("users/show.jte", Collections.singletonMap("user", user));
            } else {
                ctx.status(404);
                ctx.result("User not found");
            }
        });


        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
