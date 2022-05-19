<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.narxoz.db.Item" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <%@include file="head.jsp"%>
    </head>
    <body>
        <%@include file="navbar.jsp"%>
        <div class="container">
            <div class="row mt-2">
                <div class="col-12">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>ID </th>
                                <th>NAME </th>
                                <th>MODEL </th>
                                <th>PRICE </th>
                                <th>CATEGORY </th>
                                <th width="7%">DETAILS </th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ArrayList<Item> items = (ArrayList<Item>) request.getAttribute("tovarlar");
                                if(items!=null){
                                    for(Item it : items){
                            %>
                                <tr>
                                    <td><%=it.getId()%></td>
                                    <td><%=it.getName()%></td>
                                    <td><%=it.getModel()%></td>
                                    <td><%=it.getPrice()%></td>
                                    <td><%=it.getCategory()%></td>
                                    <td><a href="/details?id=<%=it.getId()%>" class="btn btn-primary btn-sm">DETAILS</a></td>
                                </tr>
                            <%
                                    }
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
