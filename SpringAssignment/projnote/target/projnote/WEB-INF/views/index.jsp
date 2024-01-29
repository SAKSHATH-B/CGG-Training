<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" isELIgnored="false"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"
    />

    <title>KeepNote</title>
  </head>
  <body>
    <h2>Add Note</h2>
    <form action="/savenote" method="post">
      <label for="title">Title:</label><br />
      <input type="text" id="title" name="title" required /><br /><br />
      <label for="content">Content:</label><br />
      <textarea
        id="content"
        name="content"
        rows="4"
        cols="50"
        required
      ></textarea
      ><br /><br />
      <label for="status">Status:</label><br />
      <input type="text" id="status" name="status" required /><br /><br />
      <button type="submit">Add Note</button>
    </form>

    <h2>Existing Notes</h2>
    <table border="1">
      <thead>
        <tr>
          <th>Note ID</th>
          <th>Title</th>
          <th>Content</th>
          <th>Status</th>
          <th>Created Date</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="{notes}" var="note">
          <tr>
            <td>{note.noteId}</td>
            <td>{note.noteTitle}</td>
            <td>{note.noteContent}</td>
            <td>{note.noteStatus}</td>
            <td>{note.createdAt}</td>
            <td>
              <form action="/deletenote" method="post">
                <input type="hidden" name="id" value="{note.noteId}" />
                <button type="submit">Delete</button>
              </form>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <!-- Create a form which will have text boxes for Note ID, title, content and status along with a Send 
		 button. Handle errors like empty fields -->

    <!-- display all existing notes in a tabular structure with Id, Title,Content,Status, Created Date and Action -->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
