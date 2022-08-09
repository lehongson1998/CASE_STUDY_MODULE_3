<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit contract</title>
    <link rel="stylesheet" href="/bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap5.min.css"/>
</head>
<body>

<div class="col-md-5 bg-light mt-5 p-3" style="margin: auto">
    <h3>Create Contract</h3>
    <form action="/furuma?action=edit_contract" method="post">
        <div class="mb-3 row">
            <label for="contract-id" class="col-sm-4 col-form-label">Id</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="contract-id" name="id">
            </div>
        </div>
        <div class="mb-3 row">
            <label for="facility" class="col-sm-4 col-form-label">Facility Name</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="facility" name="facility_name">
            </div>
        </div>
        <div class="mb-3 row">
            <label for="cus-name" class="col-sm-4 col-form-label">Customer Name</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="cus-name" name="cus-name">
            </div>
        </div>
        <div class="mb-3 row">
            <label for="start-date" class="col-sm-4 col-form-label">Start Date</label>
            <div class="col-sm-8">
                <input type="date" class="form-control" id="start-date">
            </div>
        </div>
        <div class="mb-3 row">
            <label for="end-date" class="col-sm-4 col-form-label">End Date</label>
            <div class="col-sm-8">
                <input type="date" class="form-control" id="end-date">
            </div>
        </div>
        <div class="mb-3 row">
            <label for="deposit" class="col-sm-4 col-form-label">Deposit</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="deposit" name="deposit">
            </div>
        </div>
        <div class="mb-3 row">
            <label for="total-money" class="col-sm-4 col-form-label">Total Money</label>
            <div class="col-sm-8">
                <input type="text" readonly class="form-control" id="total-money" name="total-money">
            </div>
        </div>
        <div class="mb-3 row">
            <label for="attach" class="col-sm-4 col-form-label">Attach Facility</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="attach" name="attach">
            </div>
        </div>
        <div>
            <button class="btn btn-danger" type="button" onclick="location.href='/furuma?action=list_contract'">Cancel</button>
            <button class="btn btn-success" type="submit">Edit</button>
        </div>
    </form>
</div>
<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap5.min.js"></script>
<script src="https://kit.fontawesome.com/8a4e8d8d08.js" crossorigin="anonymous"></script>
</body>
</html>
