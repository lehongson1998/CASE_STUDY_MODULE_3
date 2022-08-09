<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit contract</title>
    <link rel="stylesheet" href="/bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap5.min.css"/></head>
<body>
<%@include file="../include/header.jsp"%>
<form action="/Customer?action=editCustomer" method="post">
    <div class="modal-dialog">
        <c:if test="${cus != null}">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Edit Customer</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3 row">
                        <label for="editId" class="col-sm-4 col-form-label">Id</label>
                        <div class="col-sm-8">
                            <input type="text" readonly class="form-control-plaintext" id="editId" name="id" value="<c:out value='${cus.id}' />">
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="inputTypeId" class="col-sm-4 col-form-label">Type id</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="inputTypeId" name="typeId" value="<c:out value='${cus.typeCustomerId}' />">
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="static-name" class="col-sm-4 col-form-label">Name</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="static-name" name="name" value="<c:out value='${cus.name}' />">
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="staticDate" class="col-sm-4 col-form-label">Date of birth</label>
                        <div class="col-sm-8">
                            <input type="date" class="form-control" id="staticDate" name="date" value="<c:out value='${cus.dateOfBirth}' />">
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="gender" class="col-sm-4 col-form-label">Gender</label>
                        <div class="col-sm-8">
                            <div class="form-check" id="gender">
                                <input class="form-check-input" type="radio" name="gender" value="1" id="flexRadioDefault1">
                                <label class="form-check-label" for="flexRadioDefault1">
                                    Male
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="gender" value="0" id="flexRadioDefault2" checked>
                                <label class="form-check-label" for="flexRadioDefault2">
                                    Female
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="id-card" class="col-sm-4 col-form-label">id Card</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="id-card" name="idCard" value="<c:out value='${cus.idCard}' />">
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="phone" class="col-sm-4 col-form-label">Phone number</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="phone" name="phone" value="<c:out value='${cus.phoneNumber}' />">
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="email" class="col-sm-4 col-form-label">Email</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="email" name="email" value="<c:out value='${cus.email}' />">
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="address" class="col-sm-4 col-form-label">Address</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="address" name="address" value="<c:out value='${cus.address}' />">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" onclick="location.href='/Customer?action=listCustomer'">Cancel</button>
                    <button type="submit" class="btn btn-primary">Edit Customer</button>
                </div>
            </div>
        </c:if>
    </div>
</form>
<c:if test="${message != null}">
    <div class="col-md-5 bg-light mt-5 p-3 text-center" style="margin: auto">
        <h1>${message}</h1>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" onclick="location.href='/Customer?action=listCustomer'">Back</button>
    </div>
</c:if>
<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap5.min.js"></script>
<script src="https://kit.fontawesome.com/8a4e8d8d08.js" crossorigin="anonymous"></script>
</body>
</html>
