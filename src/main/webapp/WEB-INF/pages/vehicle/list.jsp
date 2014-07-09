<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1>Lista pojazdów</h1>
            <a href="<c:url value="/vehicle/create"/>" class="btn btn-success"><i class="fa fa-plus-square"></i> Nowy
                pojazd</a>
            <table class="table table-hover table-stripped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Nazwa</th>
                    <th>Opis</th>
                    <th></th>
                </tr>
                </thead>
                <c:forEach var="vehicle" items="${vehicles}">
                    <tr>
                        <td>${vehicle.id}</td>
                        <td>${vehicle.name}</td>
                        <td>${vehicle.description}</td>
                        <td>
                            <div>
                                <c:url var="editUrl" value="/vehicle/edit">
                                    <c:param name="vehicleId" value="${vehicle.id}"/>
                                </c:url>
                                <a href="${editUrl}" class="btn btn-info"><i class="fa fa-edit"></i> Edytuj</a>
                                <c:url var="deleteUrl" value="/station/delete">
                                    <c:param name="vehicleId" value="${vehicle.id}"/>
                                </c:url>
                                <a href="${deleteUrl}" class="btn btn-danger"><i class="fa fa-times"></i> Usuń</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>