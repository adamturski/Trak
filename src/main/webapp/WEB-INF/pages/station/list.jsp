<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1>Lista stacji</h1>
            <a href="<c:url value="/station/add"/>" class="btn btn-success"><i class="fa fa-plus-square"></i> Nowa
                stacja</a>
            <table class="table table-hover table-stripped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Nazwa</th>
                    <th>Opis</th>
                    <th>Adres</th>
                    <th></th>
                </tr>
                </thead>
                <c:forEach var="station" items="${stations}">
                    <tr>
                        <td>${station.id}</td>
                        <td>${station.name}</td>
                        <td>${station.description}</td>
                        <td>
                            <c:if test="${station.address!=null}">
                                ${station.address.street}, ${station.address.house}
                                <c:if test="${not empty station.address.flat}"> m. ${station.address.flat}</c:if>
                                , ${station.address.postcode} ${station.address.city}
                            </c:if>
                        </td>
                        <td>
                            <div>
                                <c:url var="editUrl" value="/station/edit">
                                    <c:param name="stationId" value="${station.id}"/>
                                </c:url>
                                <a href="${editUrl}" class="btn btn-info"><i class="fa fa-edit"></i> Edytuj</a>
                                <c:url var="deleteUrl" value="/station/delete">
                                    <c:param name="stationId" value="${station.id}"/>
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