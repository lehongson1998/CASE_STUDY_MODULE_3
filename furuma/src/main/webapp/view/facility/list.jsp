<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap5.min.css"/>
</head>
<body>
<%@include file="../include/header.jsp"%>

<div class="text-center"><h2>LIST FACILITY</h2></div>
<div class="pd-5 container">
    <table class="table table-striped table-bordered table-hover table-sm border-success" id="tableFacility"
           style="width: 100%">
        <thead>
        <tr class="bg-secondary bg-gradient text-light">
            <th>Id</th>
            <th>Name</th>
            <th>Area</th>
            <th>Cost</th>
            <th>Max people</th>
            <th>Rent type</th>
            <th>Facility type</th>
            <th>Standard room</th>
            <th>Description</th>
            <th>Pool area</th>
            <th>Number floor</th>
            <th>Facility free</th>
            <th class="text-center">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="fac" items="${facility}">
            <tr>
                <td>${fac.id}</td>
                <td>${fac.name}</td>
                <td>${fac.area}</td>
                <td>${fac.deposit}</td>
                <td>${fac.maxPeople}</td>
                <td>${fac.rentTypeId}</td>
                <td>${fac.facilityType}</td>
                <td>${fac.standardRoom}</td>
                <td>${fac.description}</td>
                <td>${fac.poolArea}</td>
                <td>${fac.numberFloor}</td>
                <td>${fac.facilityFree}</td>
                <td class="d-flex">
                    <button type="button" class="btn btn-success me-2" data-bs-toggle="modal" data-bs-target="#edit-modal"
                            onclick="location.href='/furuma?action=show_edit_facility&id=${fac.id}'">
                        Edit
                    </button>
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal"
                            onclick="removeFacility(${fac.id})">
                        Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <form action="/furuma?action=delete_facility" method="post">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Delete Facility</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" id="deleteId" class="form-control-plaintext" name="id">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </div>
        </div>
    </form>
</div>

<script>
    function removeFacility(id) {
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
        $('#tableFacility').dataTable({
            // "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>

</body>
</html>
