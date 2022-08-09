<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <<link rel="stylesheet" href="/bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap5.min.css"/></head>
<body>
<%@include file="../include/header.jsp"%>

    <div class="container text-center pd-5 table-responsive">
        <h2>LIST CUSTOMER</h2>
                    <button class="btn btn-info text-light" onclick="location.href='/Customer?action=showCreateCustomer'">
                        Add new Customer
                    </button>
                    <form class="d-flex col-md-5" action="/Customer?action=findByNameCustomer" method="post">
                        <input class="form-control me-1" type="search" placeholder="Search" aria-label="Search" name="name">
                        <button class="btn btn-outline-info text-light bg-success" type="submit">Search</button>
                    </form>
        <table class="table table-striped table-bordered table-hover table-sm border-success" id="tableCustomer">
            <thead>
            <tr class="bg-secondary bg-gradient text-light text-center">
                <th>Id</th>
                <th>Name</th>
                <th>Date of birth</th>
                <th>gender</th>
                <th>Id card</th>
                <th>Phone number</th>
                <th>Email</th>
                <th>Type id</th>
                <th>Address</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="cus" items="${customer}">
                <tr class="bg-light bg-gradient">
                    <td>${cus.id}</td>
                    <td>${cus.name}</td>
                    <td>${cus.dateOfBirth}</td>
                    <c:choose>
                        <c:when test="${cus.gender==1}">
                            <td>Male</td>
                        </c:when>
                        <c:when test="${cus.gender==0}">
                            <td>Female</td>
                        </c:when>
                    </c:choose>
                    <td>${cus.idCard}</td>
                    <td>${cus.phoneNumber}</td>
                    <td>${cus.email}</td>
                    <td>${cus.typeCustomerId}</td>
                    <td>${cus.address}</td>
                    <td>
                        <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#edit-modal" onclick="location.href='/Customer?action=showEditCustomer&id=${cus.id}'">
                            Edit
                        </button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal" onclick="removeCustomer(${cus.id})">
                            Delete
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <form action="/Customer?action=deleteCustomer" method="post">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Delete Customer</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" id="deleteId" name="id" class="form-control-plaintext">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </div>
        </div>
    </form>
</div>
<%@include file="../include/footer.jsp"%>
<script>
    function removeCustomer(id){
        document.getElementById("deleteId").value = id;
    }
</script>

<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap5.min.js"></script>
<script src="https://kit.fontawesome.com/8a4e8d8d08.js" crossorigin="anonymous"></script>
<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>
</html>
