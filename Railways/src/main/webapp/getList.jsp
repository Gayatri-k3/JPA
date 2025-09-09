<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html lang="en" xmlns:c="http://java.sun.com/jsp/jstl/core">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Railways</title>
</head>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Railways</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="nav nav-underline">
                <li class="nav-item">
                    <a class="nav-link" href="getIndex">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="redirectToForm">Book Ticket</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="getAll">Booked Tickets</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div align="center">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Age</th>
            <th scope="col">Journey Date</th>
            <th scope="col">Source</th>
            <th scope="col">Destination</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="ref" items="${listOfDto}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${ref.name}</td>
                <td>${ref.email}</td>
                <td>${ref.age}</td>
                <td>${ref.journeyDate}</td>
                <td>${ref.source}</td>
                <td>${ref.destination}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>