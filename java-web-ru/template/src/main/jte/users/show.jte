@import exercise.model.User

@param User user

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Details</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1>User Details</h1>
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">${user.getFirstName()} ${user.getLastName()}</h5>
            <p class="card-text"><strong>ID:</strong> ${user.getId()}</p>
            <p class="card-text"><strong>Email:</strong> ${user.getEmail()}</p>
            <a href="/users" class="btn btn-secondary">Back to List</a>
        </div>
    </div>
</div>
</body>
</html>