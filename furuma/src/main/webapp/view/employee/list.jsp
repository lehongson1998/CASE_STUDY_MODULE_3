
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list employee</title>
    <link rel="stylesheet" href="/bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap5.min.css"/>
</head>
<body>
<%@include file="../include/header.jsp"%>

<div class="container text-center pd-5">
    <h2>LIST EMPLOYEE</h2>
    <table class="table">
        <tr class="bg-light bg-gradient">
            <th>Name</th>
            <th>Date of birth</th>
            <th>Id card</th>
            <th>Email</th>
            <th>Education id</th>
            <th>Position id</th>
            <th>Salary</th>
            <th colspan="2">Action</th>
        </tr>
            <tr>
                <td>Lê hồng sơn</td>
                <td>06/08/1998</td>
                <td>187592899</td>
                <td>lhongson2909@gmail.com</td>
                <td>Đại học</td>
                <td>Giám đốc</td>
                <td>2000$</td>
                <td>
                    <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#edit-modal" onclick="editEmployee(${emp.id})">
                        Edit
                    </button>
                </td>
                <td>
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal" onclick="removeFacility(${emp.id})">
                        Delete
                    </button>
                </td>
            </tr>
    </table>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <form action="/furuma?action=delete">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Delete Employee</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" readonly id="deleteId" class="form-control-plaintext">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </div>
        </div>
    </form>
</div>

<div class="modal fade" id="edit-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <form action="/employee?action=edit_employee">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Edit Employee</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                        <div class="mb-3 row">
                            <label for="editId" class="col-sm-4 col-form-label">Id</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="editId" name="id">
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
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-primary">Edit</button>
                </div>
            </div>
        </div>
    </form>
</div>

<script>
    function editEmployee(id){
        document.getElementById("editId").value = id;
    }
    function removeEmployee(id){
        document.getElementById("deleteId").value = id;
    }
</script>
<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap5.min.js"></script>
<script src="https://kit.fontawesome.com/8a4e8d8d08.js" crossorigin="anonymous"></script>
</body>
</html>
