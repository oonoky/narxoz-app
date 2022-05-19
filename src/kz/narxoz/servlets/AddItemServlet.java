package kz.narxoz.servlets;

import kz.narxoz.db.DBConnection;
import kz.narxoz.db.DBManager;
import kz.narxoz.db.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/additem")
public class AddItemServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("/additem.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{

        String name = request.getParameter("item_name");
        String model = request.getParameter("item_model");
        String price = request.getParameter("item_price");

        int priceValue = Integer.parseInt(price);

        Item item = new Item();
        item.setName(name);
        item.setModel(model);
        item.setPrice(priceValue);

        DBConnection.addItem(item);

        response.sendRedirect("/additem?success");

    }

}
