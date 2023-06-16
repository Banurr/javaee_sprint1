<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.techorda.db.Task" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task Manager</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body>
<%@include file="vendor/navbar.jsp"%>
<form action="/addtask" method="post">
<button type="button" class="btn btn-primary mt-4 ml-4 mb-2" data-toggle="modal" data-target="#exampleModal" style="background-color: rgb(23,15,79)"> + Добавить задание</button>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Новое задание</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label">Наименование :</label>
                        <input type="text" class="form-control" id="recipient-name" name="name">
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Описание :</label>
                        <textarea class="form-control" id="message-text" name="description" rows="5"></textarea>
                    </div>
                    <label for="datepicker" class="col-form-label" >Крайний срок :</label>
                    <input id="datepicker" width="400" name="date">
                    <script>
                        $('#datepicker').datepicker({
                            uiLibrary: 'bootstrap4'
                        });
                    </script>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                <button class="btn btn-primary">Добавить</button>
            </div>
        </div>
    </div>
</div>
</form>
<table class="table" style="width: 97%;margin: auto auto">
    <thead class="thead-dark">
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Наименование</th>
        <th scope="col">Крайний Срок</th>
        <th scope="col">Выполнено</th>
        <th scope="col">Детали</th>
    </tr>
    </thead>
    <tbody>
    <%
        ArrayList<Task> tasks = (ArrayList<Task>) request.getAttribute("zadachi");
        if(tasks!=null)
        {
            for(Task i : tasks)
            {
                %>
    <tr>
        <th scope="row"><%=i.getId()%></th>
        <td><%=i.getName()%></td>
        <td><%=i.getDeadlineDate().replace("/",".")%></td>
        <td><%=i.getCondition()%></td>

        <th><form action="/details" method="post">
            <input type="hidden" name="id" value="<%=i.getId()%>"><button class="btn btn-info btn-sm">Детали</button></form></th>

    </tr>
    <%
        }
        }
    %>
    </tbody>
</table>
</body>
</html>
