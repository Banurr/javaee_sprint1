package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.techorda.db.DBManager;
import kz.bitlab.techorda.db.Task;

import java.io.IOException;
import java.util.ArrayList;


@WebServlet(value = "/home.html")
public class HomeServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ArrayList<Task> tasks = DBManager.allTasks();
        request.setAttribute("zadachi",tasks);
        request.getRequestDispatcher("/home.jsp").forward(request,response);

    }
}
