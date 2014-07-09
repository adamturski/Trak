<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1>Nowy status przesyłki</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-6">
            <form:form method="post" action="/shipment/status/add" modelAttribute="shipmentStatus"
                       cssClass="form-horizontal">
                <div class="form-group">
                    <form:label path="name">Nazwa</form:label>
                    <form:input path="name" cssClass="form-control"/>
                    <form:errors path="name" cssClass="help-block"/>
                </div>
                <div class="form-group">
                    <form:label path="description">Opis</form:label>
                    <form:input path="description" cssClass="form-control"/>
                    <form:errors path="description" cssClass="help-block"/>
                </div>

                <button type="submit" class="btn btn-primary">Zapisz</button>
                <a href="<c:url value="/shipment/status/list"/>" class="btn btn-default">Anuluj</a>
            </form:form>
        </div>
    </div>
</div>
