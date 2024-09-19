@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

<html>
<head>
    <title>${page.getPost().getName()}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>${page.getPost().getName()}</h1>
    <p>${page.getPost().getBody()}</p>
    <a href="${NamedRoutes.postsPath()}" class="btn btn-primary">Back to Posts</a>
</div>
</body>
</html>