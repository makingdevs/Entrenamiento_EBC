<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>Lista de Empleados</h1>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Nombre</th>
          <th>Paterno</th>
          <th>Materno</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="e" items="${empleados}">
        <tr>
          <td>${e.trab_id}</td>
          <td>${e.nombre}</td>
          <td>${e.paterno}</td>
          <td>${e.materno}</td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
</body>
</html>
