<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Show Empleado</title>
</head>
<body>
    <h1>Empleado - ${empleado.trab_id}</h1>
    <h2>${empleado.nombre} ${empleado.paterno} ${empleado.materno}</h2>

    <br> <br> <br>
    <a href="${pageContext.request.contextPath}/empleado">
      Regresar a la lista
    </a>
</body>
</html>