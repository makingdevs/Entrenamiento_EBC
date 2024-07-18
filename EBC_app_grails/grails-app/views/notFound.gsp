<!doctype html>
<html>
    <head>
        <title>Page Not Found</title>
        <meta name="layout" content="main">
        <g:if env="development"><asset:stylesheet src="errors.css"/></g:if>
    </head>
    <body>
    <div id="content" role="main">
        <div class="container">
            <section class="row">
                <div class="alert alert-danger" role="alert">
                  <strong>NO ENCONTRADO</strong>
                   ${request.forwardURI}
                </div>
            </section>
        </div>
    </div>
    </body>
</html>
