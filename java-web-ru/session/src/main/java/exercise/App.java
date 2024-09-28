package exercise;

import exercise.dto.LoginPage;
import io.javalin.Javalin;
import exercise.controller.SessionsController;
import exercise.util.NamedRoutes;
import io.javalin.rendering.template.JavalinJte;

import static io.javalin.rendering.template.TemplateUtil.model;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());

        });
        app.before(ctx -> ctx.header("Content-Type", "text/html; charset=UTF-8"));

        // BEGIN
        app.get("/", ctx -> {
            var page = new LoginPage(ctx.sessionAttribute("name"), "");
            ctx.render("index.jte", model("page", page));
        });

        app.get(NamedRoutes.buildSessionPath(), SessionsController::authenticate);
        app.post(NamedRoutes.loginPath(), SessionsController::create);
        app.post(NamedRoutes.logoutPath(), SessionsController::destroy);
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.before(ctx -> ctx.header("Content-Type", "text/html; charset=UTF-8"));
        app.start(7070);
    }
}
