@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

<html>
<head>
    <title>Posts</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Posts</h1>
    <ul class="list-group">
        @for(var post : page.getPosts())
            <li class="list-group-item">
                <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
            </li>
        @endfor
    </ul>
    <div class="mt-3">
        @if(page.isHasPrevious())
            <a href="${NamedRoutes.postsPath()}?page=${page.getCurrentPage() - 1}" class="btn btn-primary">Previous</a>
        @endif
        @if(page.isHasNext())
            <a href="${NamedRoutes.postsPath()}?page=${page.getCurrentPage() + 1}" class="btn btn-primary">Next</a>
        @endif
    </div>
</div>
</body>
</html>