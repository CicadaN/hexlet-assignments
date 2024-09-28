package exercise.controller;


import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import exercise.util.Security;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import static io.javalin.rendering.template.TemplateUtil.model;

public class SessionsController {

    // BEGIN
    public static void authenticate(Context ctx) {
        ctx.render("build.jte");
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var password = ctx.formParam("password");
        var encryptedPassword = Security.encrypt(password);
        var user = UsersRepository.findByName(name)
//                .orElseThrow(() -> new NotFoundResponse(name + " not found"));
                .orElse(null);
        if (user == null || !encryptedPassword.equals(user.getPassword())) {
            var page = new LoginPage(ctx.sessionAttribute("name"), "Wrong username or password");
            ctx.render("index.jte", model("page", page));
        } else {
            ctx.sessionAttribute("name", name);
            ctx.redirect("/"); // Редирект на главную страницу после успешного входа
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("name", null);
        ctx.redirect("/");
    }
    // END
}
