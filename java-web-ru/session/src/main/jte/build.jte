@import exercise.util.NamedRoutes;


@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <form action="${NamedRoutes.loginPath()}" method="post">
            <div>
                <label for="name">Имя пользователя:</label>
                <input type="text" id="name" placeholder="Nickname" name="name" required />
            </div>
            <div>
                <label for="password">Пароль:</label>
                <input type="password" id="password" placeholder="Password" name="password" required />
            </div>
            <div>
                <input type="submit" value="Войти" />
            </div>

        </form>
    </div>
`
)
