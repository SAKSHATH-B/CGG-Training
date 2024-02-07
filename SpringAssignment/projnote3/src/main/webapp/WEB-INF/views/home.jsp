<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ page isELIgnored="false" %>

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
    <div class="col-md-3 mt-4 text-center">
      <a href="showform" class="btn btn-dark text-white">ADD NOTE</a>
    </div>
    <c:if test="${test}">
      <div class="container">
        <div class="col-md-6 offset-md-3">
          <h2 class="text-center">Add Note</h2>
          <form action="addnote" method="post">
            <!-- <label class="form-label" for="title">Id:</label>
            <input class="form-control" type="text" id="id" name="id" required /> -->
            <label class="form-label" for="title">Title:</label>
            <input
              class="form-control"
              type="text"
              id="title"
              name="noteTitle"
              required
            />
            <label class="form-label" for="content">Content:</label>
            <textarea
              class="form-control"
              id="content"
              name="noteContent"
              rows="4"
              cols="50"
              required
            ></textarea>
            <label class="form-label" for="status">Status:</label>
            <input
              class="form-control"
              type="text"
              id="status"
              name="noteStatus"
              required
            />
            <div class="text-center">
              <button class="btn btn-outline-primary" type="submit">
                Add Note
              </button>
            </div>
          </form>
        </div>
      </div>
    </c:if>
    <c:if test="${not empty edit}">
      <div class="col-md-6 offset-md-3">
        <form action="updatenote/${editnote.noteId}" method="post">
          <div class="mb-3">
            <label for="noteid" class="form-label">note id</label>
            <input
              type="text"
              class="form-control"
              disabled
              id="noteid"
              name="noteId"
              value="${editnote.noteId}"
            />
            <input
              type="hidden"
              class="form-control"
              id="noteid"
              name="noteId"
              value="${editnote.noteId}"
            />
          </div>
          <div class="mb-3">
            <label for="notetitle" class="form-label">note title</label>
            <input
              type="text"
              name="noteTitle"
              class="form-control"
              id="notetitle"
              value="${editnote.noteTitle}"
            />
          </div>
          <div class="mb-3">
            <label for="notecontent" class="form-label">note content</label>
            <input
              type="text"
              value="${editnote.noteContent}"
              class="form-control"
              name="noteContent"
            />
          </div>
          <div class="mb-3">
            <label for="notestatus" class="form-label">note status</label>
            <input
              type="text"
              value="${editnote.noteStatus}"
              class="form-control"
              name="noteStatus"
            />
          </div>
          <div class="text-center">
            <button type="submit" class="btn btn-dark">Submit</button>
          </div>
        </form>
      </div>
    </c:if>

    <div class="container">
      <h2 class="text-center">Existing Notes</h2>
      <table class="table">
        <thead>
          <tr>
            <th>NoteID</th>
            <th>Title</th>
            <th>Content</th>
            <th>Status</th>
            <th>Created Date</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${notes}" var="note">
            <tr>
              <td>${note.noteId}</td>
              <td>${note.noteTitle}</td>
              <td>${note.noteContent}</td>
              <td>${note.noteStatus}</td>
              <td>${note.createdAt}</td>
              <td>
                <form action="deletenote" method="post">
                  <input type="hidden" name="noteId" value="${note.noteId}" />
                  <button class="btn btn-outline-primary" type="submit">
                    Delete
                  </button>
                </form>
                <form action="updatenoteclick/${note.noteId}" method="post">
                  <input type="hidden" name="noteId" value="${note.noteId}" />
                  <button class="btn btn-outline-primary" type="submit">
                    Update
                  </button>
                </form>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
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
