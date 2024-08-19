@import exercise.Data
@import exercise.model.User
@import java.util.List

@param List<User> users = Data.getUsers()

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1>Users List</h1>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        @for(User user : users)
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getFirstName()} ${user.getLastName()}</td>
                <td>${user.getEmail()}</td>
                <td>
                    <a href="/users/${user.getId()}" class="btn btn-primary">View</a>
                </td>
            </tr>
        @endfor
        </tbody>
    </table>
</div>
</body>
</html>