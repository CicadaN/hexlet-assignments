package exercise;

// BEGIN

// END

import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        return Javalin.create()
                .get("/welcome", ctx -> ctx.result("Welcome to Hexlet!"));
        // END
    };

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
