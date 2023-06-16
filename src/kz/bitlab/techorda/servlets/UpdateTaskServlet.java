package kz.bitlab.techorda.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import kz.bitlab.techorda.db.DBManager;

import java.io.IOException;

@WebServlet(value = "/updatetask")
public class UpdateTaskServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Long id = Long.parseLong(request.getParameter("pop"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String date = request.getParameter("date");
        String condition = request.getParameter("condition");
        DBManager.updateTask(id,name,description,date,condition);
        response.sendRedirect("/");
    }
}
