package kz.narxoz.servlets;

import kz.narxoz.db.DBConnection;
import kz.narxoz.db.Item;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/deleteitem")
public class DeleteItemServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String redirect = "/";

        Long id = Long.parseLong(request.getParameter("id"));

        Item item = DBConnection.getItem(id);

        if (item != null) {

            DBConnection.deleteItem(item);

        }

        response.sendRedirect(redirect);

    }

}
