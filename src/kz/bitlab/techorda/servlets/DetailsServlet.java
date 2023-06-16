package kz.bitlab.techorda.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import kz.bitlab.techorda.db.DBManager;
import kz.bitlab.techorda.db.Task;

import java.io.IOException;

@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Long id = Long.parseLong(request.getParameter("id"));
        Task task = DBManager.getTask(id);
        if(task!=null)
        {
            request.setAttribute("zadacha",task);
            request.getRequestDispatcher("/details.jsp").forward(request,response);
        }
        else
        {
            request.getRequestDispatcher("/404.jsp").forward(request,response);
        }
    }
}
