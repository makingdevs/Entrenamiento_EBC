<!DOCTYPE html>
<html lang="en">
<head>
  <meta name="layout" content="main" />
  <title>Employee And Address</title>
</head>
<body>
  <h1>Employees and Address</h1>

  <g:each in="${employees}" var="e">
    <h2>${e.name} ${e.lastName}</h2>
    <g:if test="${e.addresses}">
      <table>
        <thead>
          <tr>
            <th>Street</th>
            <th>External Number</th>
            <th>Zip Code</th>
          </tr>
        </thead>
        <tbody>
          <g:each in="${e.addresses}" var="a">
            <tr>
              <td>${a.street}</td>
              <td>${a.externalNumber}</td>
              <td>${a.zipCode}</td>
            </tr>
          </g:each>
        </tbody>
      </table>
    </g:if>
    <g:else>
      <h3>Sin direcciones</h3>
    </g:else>
  </g:each>

  <table>
    <tr>
      <td>Address</td>
    </tr>
    <tr>
      <td>Address1</td>
    </tr>
    <tr>
      <td>Address2</td>
    </tr>
  </table>

  <h3>Employee 2 </h3>

  <table>
    <tr>
      <td>Address</td>
    </tr>
    <tr>
      <td>Address1</td>
    </tr>
    <tr>
      <td>Address2</td>
    </tr>
  </table>

  <h3>Employee 3 </h3>

  <table>
    <tr>
      <td>Address</td>
    </tr>
    <tr>
      <td>Address1</td>
    </tr>
    <tr>
      <td>Address2</td>
    </tr>
  </table>

</body>
</html>
