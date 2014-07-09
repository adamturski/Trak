<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1>Lista użytkowników</h1>
            <a href="<c:url value="/user/add"/>" class="btn btn-success"><i class="fa fa-plus-square"></i> Nowy
                użytkownik</a>
            <table class="table table-hover table-stripped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Email</th>
                    <th>Nazwa użytkownika</th>
                    <th>Konto aktywne</th>
                    <th>Rola</th>
                    <th>Adres</th>
                    <th></th>
                </tr>
                </thead>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.email}</td>
                        <td>${user.name} ${user.surname}</td>
                        <td>${user.enabled}</td>
                        <td>${user.role}</td>
                        <td>
                            <c:if test="${user.address!=null}">
                                ${user.address.street}, ${user.address.house}
                                <c:if test="${not empty user.address.flat}"> m. ${user.address.flat}</c:if>
                                , ${user.address.postcode} ${user.address.city}
                            </c:if>
                        </td>
                        <td>
                            <div>
                                <c:url var="editUrl" value="/user/edit">
                                    <c:param name="userId" value="${user.id}"/>
                                </c:url>
                                <a href="${editUrl}" class="btn btn-danger"><i class="fa fa-edit"></i> Edytuj</a>
                                <c:url var="deleteUrl" value="/user/delete">
                                    <c:param name="userId" value="${user.id}"/>
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