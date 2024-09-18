@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page
<meta charset="utf-8">

@template.layout.page(
content = @`
    <div class="container">
        <h1 class="mb-4">Создать статью</h1>

        <form action="/articles" method="post">
            <div class="mb-3">
                <label for="title" class="form-label">Название</label>
                <input type="text" class="form-control ${page.getErrors().containsKey("title") ? "is-invalid" : ""}"
                       id="title" name="title" value="${page.getTitle() != null ? page.getTitle() : ""}" required>
                @if(page.getErrors().containsKey("title"))
                    <div class="invalid-feedback">
                        @for(var error : page.getErrors().get("title"))
                            ${error.getMessage()}
                        @endfor
                    </div>
                @endif
            </div>

            <div class="mb-3">
                <label for="content" class="form-label">Содержание</label>
                <textarea class="form-control ${page.getErrors().containsKey("content") ? "is-invalid" : ""}"
                          id="content" name="content" rows="3" required>${page.getContent() != null ? page.getContent() : ""}</textarea>
                @if(page.getErrors().containsKey("content"))
                    <div class="invalid-feedback">
                        @for(var error : page.getErrors().get("content"))
                            ${error.getMessage()}
                        @endfor
                    </div>
                @endif
            </div>

            <button type="submit" class="btn btn-primary">Создать</button>
        </form>
    </div>
`))