<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create</title>
    <link rel="stylesheet" href="/bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap5.min.css"/>
</head>
<body>
<%@include file="../include/header.jsp"%>

<div class="container w-50 mt-2 p-2 bg-light" style="border: 1px solid grey; border-radius: 15px">
    <h3 align="center">Add New Facility</h3>
    <form class="row g-3" action="/furuma?action=insert_facility" method="post">
        <div class="col-md-12">
            <label class="form-label">Facility type</label>
            <select name="create"  class="form-select" onchange="showServiceInput(this)">
                <option value="None" >Select Facility</option>
                <option value="1" >Villa</option>
                <option value="2" >House</option>
                <option value="3" >Room</option>
            </select>
        </div>
        <div class="col-md-12">
            <label for="id" class="form-label">Facility id</label>
            <input type="text" class="form-control" id="id" name="id">
        </div>
        <div class="col-md-12">
            <label for="name" class="form-label">Facility Name</label>
            <input type="text" class="form-control" id="name" name="name">
            <c:if test="${mapError != null}">
                <p class="text-danger">${mapError.get("name")}</p>
            </c:if>
        </div>
        <div class="col-md-12">
            <label for="area" class="form-label">Area</label>
            <input type="text" class="form-control" id="area" name="area">
        </div>
        <div class="col-md-12">
            <label for="cost" class="form-label">Deposit</label>
            <input type="text" class="form-control" id="cost"  name="cost" >
            <c:if test="${mapError != null}">
                <p class="text-danger">${mapError.get("deposit")}</p>
            </c:if>
        </div>
        <div class="col-md-12">
            <label for="inputAddress2" class="form-label">Max people</label>
            <input type="text" class="form-control" id="inputAddress2"  name="max_people" >
        </div>
        <div class="col-md-12">
            <label for="inputCity" class="form-label">Rent Type</label>
            <input type="text" class="form-control" id="inputCity" name="rent_type_id">
        </div>
        <div class="col-md-12 " id="s1" style="display: none">
            <label for="standard_room" class="form-label">Standard Room</label>
            <input type="text" class="form-control" id="standard_room" name="standard_room">
        </div>

        <div class="col-md-12 " id="s2" style="display: none">
            <label for="description_other_convenience" class="form-label">Description</label>
            <input type="text" class="form-control" id="description_other_convenience" name="description_other_convenience">
        </div>

        <div class="col-md-12 " id="s3" style="display: none">
            <label for="pool_area" class="form-label">Pool Area</label>
            <input type="text" class="form-control" id="pool_area" name="pool_area">
        </div>

        <div class="col-md-12" id="s4" style="display: none">
            <label for="number_of_floors" class="form-label">Number Floor</label>
            <input type="text" class="form-control" id="number_of_floors" name="number_of_floors">
            <c:if test="${mapError != null}">
                <p class="text-danger">${mapError.get("number")}</p>
            </c:if>
        </div>

        <div class="col-md-12 " id="s5" style="display: none">
            <label for="facility_free" class="form-label">Facility Free</label>
            <input type="text" class="form-control" id="facility_free" name="facility_free">
        </div>

        <div class="col-12 ">
            <button type="button" class="btn btn-danger" onclick="location.href='/furuma?action=list_facility'">Back</button>
            <button type="submit" class="btn btn-success">Create</button>
        </div>
    </form>
    <c:if test="${message != null}">
        <h4>${message}</h4>
    </c:if>
</div>
<script>

    function showServiceInput(value) {
        let v = value.value;
        switch (v) {
            case 'None':
                document.getElementById("s1").style.display="none";
                document.getElementById("s2").style.display="none";
                document.getElementById("s3").style.display="none";
                document.getElementById("s4").style.display="none";
                document.getElementById("s5").style.display="none";
                break;
            case "1":
                document.getElementById("s1").style.display="block";
                document.getElementById("s2").style.display="block";
                document.getElementById("s3").style.display="block";
                document.getElementById("s4").style.display="block";
                document.getElementById("s5").style.display="none";
                break;
            case "2":
                document.getElementById("s1").style.display="block";
                document.getElementById("s2").style.display="block";
                document.getElementById("s4").style.display="block";
                document.getElementById("s5").style.display="none";
                document.getElementById("s3").style.display="none";
                break;
            case "3":
                document.getElementById("s1").style.display="none";
                document.getElementById("s2").style.display="none";
                document.getElementById("s3").style.display="none";
                document.getElementById("s4").style.display="none";
                document.getElementById("s5").style.display="block";
                break;
        }
    }
</script>
<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap5.min.js"></script>
<script src="https://kit.fontawesome.com/8a4e8d8d08.js" crossorigin="anonymous"></script>
</body>
</html>
