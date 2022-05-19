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
                <div class="col-6 mx-auto">
                    <%
                        Item item = (Item)request.getAttribute("tovar");
                        if(item!=null){
                    %>
                    <%
                        String success = request.getParameter("success");
                        if(success!=null){
                    %>
                    <div class="alert alert-success alert-dismissible fade show mt-2" role="alert">
                        Item saved successfully!
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                    <%
                        }
                    %>
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>NAME: </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <input type="text" name="item_name" class="form-control" value="<%=item.getName()%>" readonly>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>ITEM MODEL: </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <input type="text" name="item_model" class="form-control" value="<%=item.getModel()%>" readonly>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>ITEM PRICE: </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <input type="text" name="item_price" class="form-control" value="<%=item.getPrice()%>" readonly>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>ITEM CATEGORY: </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <input type="text" name="item_price" class="form-control" value="<%=item.getCategory()%>" readonly>
                        </div>
                    </div>
                    <div class="row mt-4">
                        <div class="col-12">
                            <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#editItemModal">
                                EDIT ITEM
                            </button>
                            <button type="button" class="btn btn-danger ms-1" data-bs-toggle="modal" data-bs-target="#deleteModal">
                                DELETE ITEM
                            </button>
                        </div>
                    </div>
                    <div class="modal fade" id="editItemModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <form action="/saveitem" method="post">
                                    <input type="hidden" name="id" value="<%=item.getId()%>">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="staticBackdropLabel">Edit Item</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <div class="row">
                                            <div class="col-12">
                                                <label>NAME: </label>
                                            </div>
                                        </div>
                                        <div class="row mt-2">
                                            <div class="col-12">
                                                <input type="text" name="item_name" class="form-control" required placeholder="Insert name" value="<%=item.getName()%>" >
                                            </div>
                                        </div>
                                        <div class="row mt-3">
                                            <div class="col-12">
                                                <label>ITEM MODEL: </label>
                                            </div>
                                        </div>
                                        <div class="row mt-2">
                                            <div class="col-12">
                                                <input type="text" name="item_model" class="form-control" required placeholder="Insert model" value="<%=item.getModel()%>" >
                                            </div>
                                        </div>
                                        <div class="row mt-3">
                                            <div class="col-12">
                                                <label>ITEM PRICE: </label>
                                            </div>
                                        </div>
                                        <div class="row mt-2">
                                            <div class="col-12">
                                                <input type="number" name="item_price" class="form-control" required placeholder="Insert price" value="<%=item.getPrice()%>" >
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">CANCEL</button>
                                        <button type="submit" class="btn btn-success">UPDATE</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="modal fade" id="deleteModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-hidden="true">
                        <div class="modal-dialog">
                            <form action="/deleteitem" method="post">
                                <input type="hidden" name="id" value="<%=item.getId()%>">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title">Confirm Delete</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        Are you sure?
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">NO</button>
                                        <button class="btn btn-danger">YES</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
