package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;

import java.util.HashMap;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx) throws Exception {
        var firstName = ctx.formParam("firstName");
        var lastName = ctx.formParam("lastName");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");
        var secret = Security.generateToken();

        var user = new User(firstName, lastName, email, password, secret);
        UserRepository.save(user);
        ctx.cookie("JSESSIONID", secret);
        ctx.redirect("/users/" + user.getId());
    }

    public static void show(Context ctx) throws Exception {
        try {
            var idUser = ctx.pathParamAsClass("id", Long.class);
            Long id = idUser.get();

            var secret = ctx.cookie("JSESSIONID");
            var user = UserRepository.find(id);

            if (user.isPresent()) {
                var userR = user.get();
                if (user.get().getToken().equals(secret)) {
                    var model = new HashMap<String, Object>();
                    model.put("page", new UserPage(userR)); // Добавляем объект UserPage
                    ctx.render("users/show.jte", model);
                } else
                    ctx.render("/users/build.jte");
            } else {
                ctx.status(404); // Устанавливаем статус 404 Not Found
                ctx.result("User not found"); // Можно также рендерить страницу с ошибкой
            }
        } catch (java.util.NoSuchElementException e) {
            // Обработка случая, когда `id` не был найден или не может быть преобразован
            ctx.status(400); // Устанавливаем статус 400 Bad Request
            ctx.result("Invalid user ID");
        } catch (Exception e) {
            ctx.status(500); // Устанавливаем статус 500 Internal Server Error
            ctx.result("An error occurred: " + e.getMessage());
        }
    // END
}
}