<!DOCTYPE html>
<html lang="en">
<head>
  <meta name="layout" content="main" />
  <title>Employee And Address</title>
</head>
<body>
  <h1>Employees and Address</h1>
  <g:if test="${flash.message}">
    <div class="message" role="status">${flash.message}</div>
  </g:if>

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
    <g:form name="address" action="saveAddress" method="POST">
      <g:hiddenField name="employeeId" value="${e.id}"/>
      <table>
        <thead>
          <tr>
            <th>Street</th>
            <th>External Number</th>
            <th>Zip Code</th>
            <th>&nbsp;</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td><g:textField name="street"/></td>
            <td><g:textField name="externalNumber"/></td>
            <td><g:textField name="zipCode"/></td>
            <td><g:submitButton name="save" value="Save"/></td>
          </tr>
        </tbody>
      </table>
    </g:form>
  </g:each>


</body>
</html>
