<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>Lista de Empleados</h1>

    <a href="${pageContext.request.contextPath}/empleado/create">
        Nuevo Empleado
    </a>
    &nbsp; | &nbsp;
    <a href="${pageContext.request.contextPath}/empleado/export">
       Exportar lista de empleados
    </a>
    <br>
    <br>

    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Nombre</th>
          <th>Paterno</th>
          <th>Materno</th>
          <th>Acciones</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="e" items="${empleados}">
        <tr>
          <td>
            <a href="${pageContext.request.contextPath}/empleado/show/${e.trab_id}">
              ${e.trab_id}
            </a>
          </td>
          <td>${e.nombre}</td>
          <td>${e.paterno}</td>
          <td>${e.materno}</td>
          <td>
            <a href="${pageContext.request.contextPath}/empleado/update?id=${e.trab_id}">
              Editar
            </a>
          </td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
</body>
</html>
