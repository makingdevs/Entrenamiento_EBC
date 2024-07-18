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
								<div class="card text-white bg-danger mb-3" style="max-width: 18rem;">
									<div class="card-header">NOT FOUND</div>
									<div class="card-body">
										<h5 class="card-title">Error: Page Not Found (404)</h5>
										<p class="card-text">Path: ${request.forwardURI}</p>
									</div>
								</div>
            </section>
        </div>
    </div>
    </body>
</html>
