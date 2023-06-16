
<%@ page import="kz.bitlab.techorda.db.Task" %><%--
  Created by IntelliJ IDEA.
  User: nurbolyermagambetov
  Date: 14.06.2023
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="vendor/head.jsp"%>
    <title>Details</title>
</head>
<body>
<%
    Task task = (Task) request.getAttribute("zadacha");
    String s = task.getCondition();
%>
<%@include file="vendor/navbar.jsp"%>
<form action="/updatetask" method="post">
<div class="modal-body modal-lg" style="margin: auto auto;">

    <div class="form-group">
        <label for="recipient-name" class="col-form-label">Наименование :</label>
        <input type="text" class="form-control" id="recipient-name" name="name" value="<%=task.getName()%>">
    </div>
    <div class="form-group">
        <label for="message-text" class="col-form-label">Описание :</label>
        <textarea class="form-control" id="message-text" name="description" rows="5"><%=task.getDescription()%></textarea>
    </div>

    <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Выполнено</label>
    <select class="custom-select my-1 mr-sm-2 mb-3" id="inlineFormCustomSelectPref" name="condition">
        <%if(s.equals("Да"))
            {%>
        <option selected value="Да">Да</option>
        <option value="Нет">Нет</option>
    <%}else
        {%>
    <option selected value="Нет">Нет</option>
    <option value="Да">Да</option>
    <%}%>
    </select>
    <label for="datepicker" class="col-form-label" >Крайний срок :</label>
    <input class="mb-3" id="datepicker" width="767" name="date" value="<%=task.getDeadlineDate()%>">
    <script>
        $('#datepicker').datepicker({
            uiLibrary: 'bootstrap4'
        });
    </script>
    <input name="pop" type="hidden" value="<%=task.getId()%>">
    <button class="btn btn-success mr-2">Сохранить</button>
<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModalCenter">
    Удалить
</button>

</div>
</form>
    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Вы собираетесь удалить эту задачу</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Вы уверены?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                    <form method="post" action="/deletetask">
                        <input name="id" type="hidden" value="<%=task.getId()%>">
                    <button class="btn btn-danger">Удалить</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
