@import exercise.dto.users.UsersPage
@import exercise.model.User

@param UsersPage page

@template.layout.page(
content = @`
    <h1>Users</h1>
    <form action="/users" method="get" class="mb-3">
        <div class="input-group">
            <input type="text" name="term" value="${page.getTerm() != null ? page.getTerm() : ""}" class="form-control" placeholder="Search by first name">
            <button class="btn btn-primary" type="submit">Search</button>
        </div>
    </form>

    @if(page.getUsers().isEmpty())
        <p>No users found</p>
    @else
        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
            </tr>
            </thead>
            <tbody>
            @for(User user : page.getUsers())
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getFirstName()}</td>
                    <td>${user.getLastName()}</td>
                    <td>${user.getEmail()}</td>
                </tr>
            @endfor
            </tbody>
        </table>
    @endif
`
)