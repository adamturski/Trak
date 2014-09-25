<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1>Nowa przesyłka</h1>
        </div>
    </div>
    <form:form method="post" action="/shipment/create" modelAttribute="shipmentCreate"
               cssClass="form-horizontal">
        <div class="row">
            <div class="col-lg-5">
                <h3 class="text-primary">Nadawca:</h3>

                <div class="form-group">
                    <form:label path="senderCompany">Firma</form:label>
                    <form:input path="senderCompany" cssClass="form-control"/>
                    <form:errors path="senderCompany" cssClass="help-block error"/>
                </div>
                <div class="form-group">
                    <form:label path="senderName">Imię</form:label>
                    <form:input path="senderName" cssClass="form-control"/>
                    <form:errors path="senderName" cssClass="help-block error"/>
                </div>
                <div class="form-group">
                    <form:label path="senderSurname">Nazwisko</form:label>
                    <form:input path="senderSurname" cssClass="form-control"/>
                    <form:errors path="senderSurname" cssClass="help-block error"/>
                </div>
                <div class="form-group">
                    <form:label path="senderPhone">Telefon</form:label>
                    <form:input path="senderPhone" cssClass="form-control"/>
                    <form:errors path="senderPhone" cssClass="help-block error"/>
                </div>
                <div class="form-group">
                    <form:label path="senderStreet">Ulica</form:label>
                    <form:input path="senderStreet" cssClass="form-control"/>
                    <form:errors path="senderStreet" cssClass="help-block error"/>
                </div>
                <div class="form-group">
                    <form:label path="senderHouse">Nr domu</form:label>
                    <form:input path="senderHouse" cssClass="form-control"/>
                    <form:errors path="senderHouse" cssClass="help-block error"/>
                </div>
                <div class="form-group">
                    <form:label path="senderFlat">Nr mieszkania</form:label>
                    <form:input path="senderFlat" cssClass="form-control"/>
                    <form:errors path="senderFlat" cssClass="help-block error"/>
                </div>
                <div class="form-group">
                    <form:label path="senderPostcode">Poczta</form:label>
                    <form:input path="senderPostcode" cssClass="form-control"/>
                    <form:errors path="senderPostcode" cssClass="help-block error"/>
                </div>
                <div class="form-group">
                    <form:label path="senderCity">Miasto</form:label>
                    <form:input path="senderCity" cssClass="form-control"/>
                    <form:errors path="senderCity" cssClass="help-block error"/>
                </div>
                <div class="form-group">
                    <form:label path="senderState">Województwo</form:label>
                    <form:input path="senderState" cssClass="form-control"/>
                    <form:errors path="senderState" cssClass="help-block error"/>
                </div>
                <div class="form-group">
                    <form:label path="senderCountry">Kraj</form:label>
                    <form:input path="senderCountry" cssClass="form-control"/>
                    <form:errors path="senderCountry" cssClass="help-block error"/>
                </div>
            </div>
            <div class="col-lg-5 col-lg-offset-2">
                <h3 class="text-primary">Odbiorca:</h3>

                <div class="form-group">
                    <form:label path="recipientCompany">Firma</form:label>
                    <form:input path="recipientCompany" cssClass="form-control"/>
                    <form:errors path="recipientCompany" cssClass="help-block error"/>
                </div>
                <div class="form-group">
                    <form:label path="recipientName">Imię</form:label>
                    <form:input path="recipientName" cssClass="form-control"/>
                    <form:errors path="recipientName" cssClass="help-block error"/>
                </div>
                <div class="form-group">
                    <form:label path="recipientSurname">Nazwisko</form:label>
                    <form:input path="recipientSurname" cssClass="form-control"/>
                    <form:errors path="recipientSurname" cssClass="help-block error"/>
                </div>
                <div class="form-group">
                    <form:label path="recipientPhone">Telefon</form:label>
                    <form:input path="recipientPhone" cssClass="form-control"/>
                    <form:errors path="recipientPhone" cssClass="help-block error"/>
                </div>
                <div class="form-group">
                    <form:label path="recipientStreet">Ulica</form:label>
                    <form:input path="recipientStreet" cssClass="form-control"/>
                    <form:errors path="recipientStreet" cssClass="help-block error"/>
                </div>
                <div class="form-group">
                    <form:label path="recipientHouse">Nr domu</form:label>
                    <form:input path="recipientHouse" cssClass="form-control"/>
                    <form:errors path="recipientHouse" cssClass="help-block error"/>
                </div>
                <div class="form-group">
                    <form:label path="recipientFlat">Nr mieszkania</form:label>
                    <form:input path="recipientFlat" cssClass="form-control"/>
                    <form:errors path="recipientFlat" cssClass="help-block error"/>
                </div>
                <div class="form-group">
                    <form:label path="recipientPostcode">Poczta</form:label>
                    <form:input path="recipientPostcode" cssClass="form-control"/>
                    <form:errors path="recipientPostcode" cssClass="help-block error"/>
                </div>
                <div class="form-group">
                    <form:label path="recipientCity">Miasto</form:label>
                    <form:input path="recipientCity" cssClass="form-control"/>
                    <form:errors path="recipientCity" cssClass="help-block error"/>
                </div>
                <div class="form-group">
                    <form:label path="recipientState">Województwo</form:label>
                    <form:input path="recipientState" cssClass="form-control"/>
                    <form:errors path="recipientState" cssClass="help-block error"/>
                </div>
                <div class="form-group">
                    <form:label path="recipientCountry">Kraj</form:label>
                    <form:input path="recipientCountry" cssClass="form-control"/>
                    <form:errors path="recipientCountry" cssClass="help-block error"/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <button type="submit" class="btn btn-primary">Zapisz</button>
                <a href="<c:url value="/shipment/list"/>" class="btn btn-default">Anuluj</a>
            </div>
        </div>
    </form:form>
</div>
