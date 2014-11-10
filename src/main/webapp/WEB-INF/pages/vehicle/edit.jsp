<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1>Edycja pojazdu</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-6">
            <form:form method="post" action="/vehicle/edit" modelAttribute="vehicle" cssClass="form-horizontal">
                <form:hidden path="id"/>
                <div class="form-group">
                    <form:label path="registrationNumber">Numer rejstracyjny</form:label>
                    <form:input path="registrationNumber" cssClass="form-control"/>
                    <form:errors path="registrationNumber" cssClass="help-block"/>
                </div>
                <div class="form-group">
                    <form:label path="gpsLocator">Lokalizator GPS</form:label>
                    <form:input path="gpsLocator" cssClass="form-control"/>
                    <form:errors path="gpsLocator" cssClass="help-block"/>
                </div>

                <button type="submit" class="btn btn-primary">Zapisz</button>
                <a href="<c:url value="/vehicle/list"/>" class="btn btn-default">Anuluj</a>
            </form:form>
        </div>
    </div>
</div>