package kz.bitlab.techorda.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import kz.bitlab.techorda.db.DBManager;
import kz.bitlab.techorda.db.Task;

import java.io.IOException;

@WebServlet(value = "/addtask")
public class AddTaskServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String date = request.getParameter("date");
        Task task = new Task(null,name,description,date,"Нет");
        DBManager.addTask(task);
        response.sendRedirect("/");
    }
}
