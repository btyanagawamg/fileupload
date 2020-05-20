<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>
<body>
    <div id="wrapper">
        <h1>Hello world!</h1>
        <p>The time on the server is ${serverTime}.</p>
    </div>
    <form:form
        action="${pageContext.request.contextPath}/article/upload/with/validation" method="post"
        modelAttribute="fileUploadWithValidationForm" enctype="multipart/form-data"> <!-- (1) (2) -->
        <table>
          <tr>
            <th width="35%">File to upload</th>
            <td width="65%">
              <form:input type="file" path="file" /> <!-- (3) -->
              <form:errors path="file" />
            </td>
          </tr>
          <tr>
            <th width="35%">Description</th>
            <td width="65%">
              <form:input path="description" />
              <form:errors path="description" />
            </td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td><form:button>Upload(With Validation)</form:button></td>
          </tr>
        </table>
      </form:form>
    <form:form
        action="${pageContext.request.contextPath}/article/upload/without/validation" method="post"
        modelAttribute="fileUploadWithoutValidationForm" enctype="multipart/form-data"> <!-- (1) (2) -->
        <table>
          <tr>
            <th width="35%">File to upload</th>
            <td width="65%">
              <form:input type="file" path="file" /> <!-- (3) -->
              <form:errors path="file" />
            </td>
          </tr>
          <tr>
            <th width="35%">Description</th>
            <td width="65%">
              <form:input path="description" />
              <form:errors path="description" />
            </td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td><form:button>Upload(Without Validation)</form:button></td>
          </tr>
        </table>
      </form:form>
</body>
</html>
