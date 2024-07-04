<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Crea Empleado</title>
</head>
<body>
    <h1>Nuevo empleado</h1>
    <form:form modelAttribute="empleado" method="post">
        <form:label path="nombre">Nombre</form:label>
        <form:input path="nombre"/> <br><br>
        <form:label path="paterno">Paterno</form:label>
        <form:input path="paterno"/> <br><br>
        <form:label path="materno">Materno</form:label>
        <form:input path="materno"/> <br><br>
        <input type="submit" value="Guardar"/>
    </form:form>
    <br> <br> <br>
    <a href="${pageContext.request.contextPath}/empleado">
      Regresar a la lista
    </a>
</body>
</html>