<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1>Lista statusów przesyłek</h1>
            <a href="<c:url value="/shipment/status/add"/>" class="btn btn-success"><i class="fa fa-plus-square"></i>
                Nowy status przesyłki</a>
            <table class="table table-hover table-stripped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Nazwa</th>
                    <th>Opis</th>
                    <th></th>
                </tr>
                </thead>
                <c:forEach var="shipmentStatus" items="${shipmentStatuses}">
                    <tr>
                        <td>${shipmentStatus.id}</td>
                        <td>${shipmentStatus.name}</td>
                        <td>${shipmentStatus.description}</td>
                        <td>
                            <div>
                                <c:url var="editUrl" value="/shipment/status/edit">
                                    <c:param name="shipmentStatusId" value="${shipmentStatus.id}"/>
                                </c:url>
                                <a href="${editUrl}" class="btn btn-info"><i class="fa fa-edit"></i> Edytuj</a>
                                <c:url var="deleteUrl" value="/shipment/status/delete">
                                    <c:param name="shipmentStatusId" value="${shipmentStatus.id}"/>
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