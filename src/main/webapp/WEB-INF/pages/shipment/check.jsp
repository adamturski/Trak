<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1>Historia przesyłki</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-6">
            <form:form method="post" action="/shipment/check" modelAttribute="shipmentCheck" cssClass="form-horizontal">
                <div class="form-group">
                    <form:label path="id">Id przesyłki</form:label>
                    <form:input path="id" cssClass="form-control"/>
                    <form:errors path="id" cssClass="help-block"/>
                </div>
                <button type="submit" class="btn btn-primary">Sprawdź</button>
                <a href="<c:url value="/station/list"/>" class="btn btn-default">Anuluj</a>
            </form:form>
        </div>
    </div>
</div>