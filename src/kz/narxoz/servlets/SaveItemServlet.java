package kz.narxoz.servlets;

import kz.narxoz.db.DBConnection;
import kz.narxoz.db.Item;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/saveitem")
public class SaveItemServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String redirect = "/";

        Long id = Long.parseLong(request.getParameter("id"));

        String name = request.getParameter("item_name");
        String model = request.getParameter("item_model");
        String price = request.getParameter("item_price");

        int priceValue = Integer.parseInt(price);

        Item item = DBConnection.getItem(id);

        if (item != null) {

            item.setName(name);
            item.setModel(model);
            item.setPrice(priceValue);

            DBConnection.updateItem(item);
            redirect = "/details?id="+id+"&success";

        }

        response.sendRedirect(redirect);

    }

}
