<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1>Edycja stacji</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-6">
            <form:form method="post" action="/station/add" modelAttribute="station" cssClass="form-horizontal">
                <form:hidden path="id"/>
                <form:hidden path="address.id"/>
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
                <div class="form-group">
                    <form:label path="address.street">Ulica</form:label>
                    <form:input path="address.street" cssClass="form-control"/>
                    <form:errors path="address.street" cssClass="help-block"/>
                </div>
                <div class="form-group">
                    <form:label path="address.house">Nr domu</form:label>
                    <form:input path="address.house" cssClass="form-control"/>
                    <form:errors path="address.house" cssClass="help-block"/>
                </div>
                <div class="form-group">
                    <form:label path="address.flat">Nr mieszkania</form:label>
                    <form:input path="address.flat" cssClass="form-control"/>
                    <form:errors path="address.flat" cssClass="help-block"/>
                </div>
                <div class="form-group">
                    <form:label path="address.postcode">Poczta</form:label>
                    <form:input path="address.postcode" cssClass="form-control"/>
                    <form:errors path="address.postcode" cssClass="help-block"/>
                </div>
                <div class="form-group">
                    <form:label path="address.city">Miasto</form:label>
                    <form:input path="address.city" cssClass="form-control"/>
                    <form:errors path="address.city" cssClass="help-block"/>
                </div>
                <div class="form-group">
                    <form:label path="address.state">Województwo</form:label>
                    <form:input path="address.state" cssClass="form-control"/>
                    <form:errors path="address.state" cssClass="help-block"/>
                </div>
                <div class="form-group">
                    <form:label path="address.country">Kraj</form:label>
                    <form:input path="address.country" cssClass="form-control"/>
                    <form:errors path="address.country" cssClass="help-block"/>
                </div>

                <button type="submit" class="btn btn-primary">Zapisz</button>
                <a href="<c:url value="/station/list"/>" class="btn btn-default">Anuluj</a>
            </form:form>
        </div>
    </div>
</div>