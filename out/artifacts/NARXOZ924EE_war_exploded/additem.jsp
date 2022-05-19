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
                <div class="col-6 mx-auto">
                    <%
                        String success = request.getParameter("success");
                        if(success!=null){
                    %>
                        <div class="alert alert-success alert-dismissible fade show mt-2" role="alert">
                            Item added successfully!
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                    <%
                        }
                    %>
                    <form action="/additem" method="post">
                        <div class="row mt-3">
                            <div class="col-12">
                                <label>NAME: </label>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-12">
                                <input type="text" name="item_name" class="form-control" required placeholder="Insert name">
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-12">
                                <label>ITEM MODEL: </label>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-12">
                                <input type="text" name="item_model" class="form-control" required placeholder="Insert model">
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-12">
                                <label>ITEM PRICE: </label>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-12">
                                <input type="number" value="0" name="item_price" class="form-control" required placeholder="Insert price">
                            </div>
                        </div>
                        <div class="row mt-4">
                            <div class="col-12">
                                <button class="btn btn-success">ADD ITEM</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
