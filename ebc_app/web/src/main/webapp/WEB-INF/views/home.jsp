<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hola</title>
</head>
<body>
    <h1>Hola mundo</h1>
    <h2>
        ${mensaje}
    </h2>

    <ul>
        <c:forEach var="c" items="${campuses}">
            <li>${c.stvcampCode} - ${c.stvcampDesc}</li>
        </c:forEach>
    </ul>

    <form method="post" >
    <label>Campo 1:</label>
    <input type="text" name="campo"/>
    <button type="submit">Enviar</button>
    </form>
</body>
</html>