<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit contract</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container w-50 mt-2 p-2 bg-light" style="border: 1px solid grey; border-radius: 15px">
    <h3 align="center">Add New Facility</h3>
    <form class="row g-3" action="/furuma?action=edit_facility" method="post">
        <div class="col-md-12">
            <label class="form-label">Facility type</label>
            <select name="create"  class="form-select" onchange="showServiceInput(this)">
                <option value="None" disabled >Select Facility</option>
                <c:forEach items="${facilityType}" var="serviceTypes">
                    <c:choose>
                        <c:when test="${serviceTypes.id == facility1.facilityType}">
                            <option value="${serviceTypes.id}" selected>${serviceTypes.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${serviceTypes.id}">${serviceTypes.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-12">
            <label for="id" class="form-label">Facility id</label>
            <input type="text" readonly class="form-control" id="id" name="id" value="${facility1.id}">
        </div>
        <div class="col-md-12">
            <label for="name" class="form-label">Facility Name</label>
            <input type="text" class="form-control" id="name" name="name" value="${facility1.name}">
        </div>
        <div class="col-md-12">
            <label for="area" class="form-label">Area</label>
            <input type="text" class="form-control" id="area" name="area" value="${facility1.area}">
        </div>
        <div class="col-md-12">
            <label for="cost" class="form-label">Deposit</label>
            <input type="text" class="form-control" id="cost"  name="cost" value="${facility1.deposit}">
        </div>
        <div class="col-md-12">
            <label for="inputAddress2" class="form-label">Max people</label>
            <input type="text" class="form-control" id="inputAddress2"  name="max_people" value="${facility1.maxPeople}">
        </div>
        <div class="col-md-12">
            <label  class="form-label">Kiểu thuê</label>
            <select name="rent_type_id"  class="form-select">
                <option value="None" disabled selected>Chọn kiểu thuê</option>
                <c:forEach items="${rentType}" var="rentalTypeList">
                    <c:choose >
                        <c:when test="${rentalTypeList.id == facility.rentTypeId}">
                            <option value="${rentalTypeList.id}"selected >${rentalTypeList.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${rentalTypeList.id}">${rentalTypeList.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-12 " id="s1" style="display: none">
            <label for="standard_room" class="form-label">Standard Room</label>
            <input type="text" class="form-control" id="standard_room" name="standard_room" value="${facility1.standardRoom}">
        </div>

        <div class="col-md-12 " id="s2" style="display: none">
            <label for="description_other_convenience" class="form-label">Description</label>
            <input type="text" class="form-control" id="description_other_convenience" name="description_other_convenience" value="${facility1.description}">
        </div>

        <div class="col-md-12 " id="s3" style="display: none">
            <label for="pool_area" class="form-label">Pool Area</label>
            <input type="text" class="form-control" id="pool_area" name="pool_area" value="${facility1.poolArea}">
        </div>

        <div class="col-md-12" id="s4" style="display: none">
            <label for="number_of_floors" class="form-label">Number Floor</label>
            <input type="text" class="form-control" id="number_of_floors" name="number_of_floors" value="${facility1.numberFloor}">
        </div>

        <div class="col-md-12 " id="s5" style="display: none">
            <label for="facility_free" class="form-label">Facility Free</label>
            <input type="text" class="form-control" id="facility_free" name="facility_free" value="${facility1.facilityFree}">
        </div>

        <div class="col-12 ">
            <button type="button" class="btn btn-danger">Back</button>
            <button type="submit" class="btn btn-success">Edit</button>
        </div>
    </form>
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

<script src="https://kit.fontawesome.com/8a4e8d8d08.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
</body>
</html>
