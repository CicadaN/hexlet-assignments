@import exercise.dto.posts.EditPostPage
@import exercise.util.NamedRoutes
@param EditPostPage page

@template.layout.page(
content = @`
    <main>
        <div class="mx-auto p-4 py-md-5">
            <h1>Редактировать пост</h1>
            <form method="POST" action="${NamedRoutes.updatePost(String.valueOf(page.getId()))}">
                <div class="mb-3">
                    <label for="name" class="form-label">Название:</label>
                    <input type="text" id="name" name="name" class="form-control" value="${page.getName()}" required />
                    @if(page.getErrors() != null && page.getErrors().containsKey("name"))
                        <div class="text-danger">
                            ${page.getErrors().get("name").get(0).getMessage()}
                        </div>
                    @endif
                </div>

                <div class="mb-3">
                    <label for="body" class="form-label">Содержимое:</label>
                    <textarea id="body" name="body" class="form-control" required>${page.getBody()}</textarea>
                    @if(page.getErrors() != null && page.getErrors().containsKey("body"))
                        <div class="text-danger">
                            ${page.getErrors().get("body").get(0).getMessage()}
                        </div>
                    @endif
                </div>

                <button type="submit" class="btn btn-primary">Обновить пост</button>
            </form>
        </div>
    </main>
`
)