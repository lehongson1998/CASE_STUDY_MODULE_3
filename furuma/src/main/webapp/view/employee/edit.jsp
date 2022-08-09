<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit contract</title>
    <link rel="stylesheet" href="/bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap5.min.css"/>
</head>
<body>
<%@include file="../include/header.jsp"%>
<div>
    <div class="col-md-5 bg-light mt-5 p-3" style="margin: auto">
        <h3>Edit Employee</h3>
        <form action="/employee?action=edit_employee" method="post">
            <div class="mb-3 row">
                <label for="id" class="col-sm-4 col-form-label">Id</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="id" name="id">
                </div>
            </div>
            <div class="mb-3 row">
                <label for="name" class="col-sm-4 col-form-label">name</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="name" name="name">
                </div>
            </div>
            <div class="mb-3 row">
                <label for="date" class="col-sm-4 col-form-label">Date of birth</label>
                <div class="col-sm-8">
                    <input type="date" class="form-control" id="date" name="date-of-birth">
                </div>
            </div>
            <div class="mb-3 row">
                <label for="id-card" class="col-sm-4 col-form-label">Id card</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="id-card" name="id-card">
                </div>
            </div>
            <div class="mb-3 row">
                <label for="email" class="col-sm-4 col-form-label">Email</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="email">
                </div>
            </div>
            <div class="mb-3 row">
                <label for="edu-id" class="col-sm-4 col-form-label">Education Id</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="edu-id">
                </div>
            </div>
            <div class="mb-3 row">
                <label for="position-id" class="col-sm-4 col-form-label">Position id</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="position-id">
                </div>
            </div>
            <div class="mb-3 row">
                <label for="salary" class="col-sm-4 col-form-label">Salary</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="salary">
                </div>
            </div>
            <div>
                <button class="btn btn-danger" type="button" onclick="location.href='/furuma?action=list_employee'">Cancel</button>
                <button class="btn btn-success" type="submit">Create</button>
            </div>
        </form>
    </div>
</div>
<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap5.min.js"></script>
<script src="https://kit.fontawesome.com/8a4e8d8d08.js" crossorigin="anonymous"></script>
</body>
</html>
