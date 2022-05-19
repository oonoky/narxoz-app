package kz.narxoz.servlets;

import kz.narxoz.db.DBConnection;
import kz.narxoz.db.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Long id = Long.parseLong(request.getParameter("id"));
        Item item = DBConnection.getItem(id);
        request.setAttribute("tovar", item);
        request.getRequestDispatcher("/details.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


    }

}
