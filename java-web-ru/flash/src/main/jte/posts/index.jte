@import exercise.dto.posts.PostsPage
@import exercise.model.Post
@param PostsPage page

@template.layout.page(
page = page,
content = @`
    <h1>Список постов</h1>
    <a href="/posts/build" class="btn btn-primary mb-3">Создать пост</a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Название</th>
            <th>Действия</th>
        </tr>
        </thead>
        <tbody>
        @for(Post post : page.getPosts())
            <tr>
                <td>${post.getId()}</td>
                <td>${post.getName()}</td>
                <td>
                    <a href="/posts/${post.getId()}" class="btn btn-info btn-sm">Просмотр</a>
                </td>
            </tr>
        @endfor
        </tbody>
    </table>
`
)