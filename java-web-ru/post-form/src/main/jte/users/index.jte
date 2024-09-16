@import exercise.dto.users.UsersPage
@param UsersPage page
<meta charset="utf-8" />

@template.layout.page(
    content = @`
        <h1>Пользователи</h1>

        <div class="mb-3">
            <a href="/users/build">Зарегистрировать нового пользователя</a>
        </div>

        <table class="table table-striped">
            @for(var user : page.getUsers())
                <tr>
                    <td>
                        ${user.getId()}
                    </td>
                    <td>
                        ${user.getFirstName()} ${user.getLastName()}
                    </td>
                </tr>
            @endfor
        </table>
    `
)
