<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1>Lista przesyłek</h1>

            <div class="toolbar">
                <div class="btn-group">
                    <a href="<c:url value="/shipment/create"/>" class="btn btn-success">
                        <i class="fa fa-plus-square"></i>
                        Nowa przesyłka</a>
                </div>
                <div class="btn-group pull-right">
                    <a class="btn blue dropdown-toggle" data-toggle="dropdown">
                        <c:choose>
                            <c:when test="${statusFilter==null}">Wszystkie</c:when>
                            <c:otherwise>${statusFilter.text}</c:otherwise>
                        </c:choose>
                        <i class="fa fa-angle-down"></i>
                    </a>

                    <ul class="dropdown-menu pull-right">
                        <li>
                            <c:url var="filterListUrl" value="/shipment/list"/>
                            <a href="${filterListUrl}">Wszystkie</a>
                        </li>
                        <c:forEach var="status" items="${statuses}">
                            <li>
                                <c:url var="filterListUrl" value="/shipment/list">
                                    <c:param name="statusFilter" value="${status}"/>
                                </c:url>
                                <a href="${filterListUrl}">${status.text}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <table class="table table-hover table-stripped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Status</th>
                    <th>Nadawca</th>
                    <th>Odbiorca</th>
                    <th>Data utworzenia</th>
                    <th>Osoba tworząca</th>
                    <th>Data dostarczenia</th>
                    <th>Osoba dostarczająca</th>
                    <th></th>
                </tr>
                </thead>
                <c:forEach var="shipment" items="${shipments}">
                    <tr>
                        <td>${shipment.id}</td>
                        <td>${shipment.status.text}</td>
                        <td>
                            <c:if test="${shipment.sender!=null}">
                                <c:if test="${not empty shipment.sender.company}">${shipment.sender.company}
                                    <br/></c:if>
                                ${shipment.sender.name} ${shipment.sender.surname}<br/>
                                <c:if test="${shipment.sender.address!=null}">
                                    ${shipment.sender.address.street}, ${shipment.sender.address.house}
                                    <c:if test="${not empty shipment.sender.address.flat}"> m. ${shipment.sender.address.flat}</c:if>
                                    , ${shipment.sender.address.postcode} ${shipment.sender.address.city}
                                </c:if>
                            </c:if>
                        </td>
                        <td><c:if test="${shipment.recipient!=null}">
                            <c:if test="${not empty shipment.recipient.company}">${shipment.recipient.company}
                                <br/></c:if>
                            ${shipment.recipient.name} ${shipment.recipient.surname}<br/>
                            <c:if test="${shipment.recipient.address!=null}">
                                ${shipment.recipient.address.street}, ${shipment.recipient.address.house}
                                <c:if test="${not empty shipment.recipient.address.flat}"> m. ${shipment.recipient.address.flat}</c:if>
                                , ${shipment.recipient.address.postcode} ${shipment.recipient.address.city}
                            </c:if>
                        </c:if></td>
                        <td>${shipment.created}</td>
                        <td>${shipment.creator.name} ${shipment.creator.surname}</td>
                        <td>${shipment.delivered}</td>
                        <td>${shipment.deliverer.name} ${shipment.deliverer.surname}</td>
                        <td>
                            <div>
                                <c:url var="historyUrl" value="/shipment/history">
                                    <c:param name="id" value="${shipment.id}"/>
                                </c:url>
                                <a href="${historyUrl}" class="btn btn-info"><i class="fa fa-eye"></i> Historia</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>