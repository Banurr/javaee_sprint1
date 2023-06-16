package kz.bitlab.techorda.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import kz.bitlab.techorda.db.DBManager;

import java.io.IOException;

@WebServlet(value = "/deletetask")
public class DeleteItemServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Long id = Long.parseLong(request.getParameter("id"));
        DBManager.deleteTask(id);
        response.sendRedirect("/");
    }
}
