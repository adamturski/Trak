<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1>Historia przesyłki</h1>

            <div class="toolbar">
                <div class="btn-group">
                    <a class="btn btn-success" onclick="history.go(-1);">
                        <i class="fa fa-chevron-left"></i>
                        Wstecz</a>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div><strong>Id: </strong> ${shipment.id}</div>
            <div><strong>Status: </strong> ${shipment.status.text}</div>
            <div><strong>Data utworzenia: </strong> ${shipment.created}</div>
            <c:if test="${shipment.delivered!=null}">
                <div><strong>Data dostarczenia: </strong> ${shipment.delivered}</div>
            </c:if>
            <c:if test="${shipment.deliverer!=null}">
                <div><strong>Osoba dostarczająca: </strong> ${shipment.deliverer.name} ${shipment.deliverer.surname}
                </div>
            </c:if>
            <div class="col-lg-6">
                <h3>Nadawca:</h3>

                <div><c:if test="${shipment.sender!=null}">
                    <c:if test="${not empty shipment.sender.company}">${shipment.sender.company}
                        <br/></c:if>
                    ${shipment.sender.name} ${shipment.sender.surname}<br/>
                    <c:if test="${shipment.sender.address!=null}">
                        ${shipment.sender.address.street}, ${shipment.sender.address.house}
                        <c:if test="${not empty shipment.sender.address.flat}"> m. ${shipment.sender.address.flat}</c:if>
                        , ${shipment.sender.address.postcode} ${shipment.sender.address.city}
                    </c:if>
                </c:if></div>
            </div>
            <div class="col-lg-6">
                <h3>Odbiorca:</h3>

                <div><c:if test="${shipment.recipient!=null}">
                    <c:if test="${not empty shipment.recipient.company}">${shipment.recipient.company}
                        <br/></c:if>
                    ${shipment.recipient.name} ${shipment.recipient.surname}<br/>
                    <c:if test="${shipment.recipient.address!=null}">
                        ${shipment.recipient.address.street}, ${shipment.recipient.address.house}
                        <c:if test="${not empty shipment.recipient.address.flat}"> m. ${shipment.recipient.address.flat}</c:if>
                        , ${shipment.recipient.address.postcode} ${shipment.recipient.address.city}
                    </c:if>
                </c:if></div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <h3>Historia</h3>
            <table class="table table-hover table-stripped">
                <thead>
                <tr>
                    <th>Stacja</th>
                    <th>Adres</th>
                    <th>Data przyjazdu</th>
                    <th>Data odjazdu</th>
                </tr>
                </thead>
                <c:forEach var="shipmentMovement" items="${shipmentMovements}">
                    <tr>
                        <td>${shipmentMovement.station.name}</td>
                            <c:if test="${not empty shipmentMovement.station.description}">
                                <br/>
                                ${shipmentMovement.station.description}
                            </c:if>
                        </td>
                        <td>
                            <c:if test="${shipmentMovement.station.address!=null}">
                                ${shipmentMovement.station.address.street}, ${shipmentMovement.station.address.house}
                                <c:if test="${not empty shipmentMovement.station.address.flat}"> m. ${shipmentMovement.station.address.flat}</c:if>
                                , ${shipmentMovement.station.address.postcode} ${shipmentMovement.station.address.city}
                            </c:if>
                        </td>
                        <td>${shipmentMovement.arrivalDate}</td>
                        <td>${shipmentMovement.departureDate}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#historyMapPanel">
                                Droga przesyłki
                            </a>
                        </h4>
                    </div>
                    <div id="historyMapPanel" class="panel-collapse collapse in">
                        <div class="panel-body">
                            <div id="historyMap"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript"
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCY-wG3vRLZ6p_w7i78_MLmAegGMMkDizM">
</script>
<script type="text/javascript">

    function initializeHistoryMap() {
        var mapOptions = {
            center: new google.maps.LatLng(51.9222925, 19.6397497),
            zoom: 8
        };
        var map = new google.maps.Map(document.getElementById("historyMap"), mapOptions);
        var locationsCoordinates = [];

        <c:if test="${not empty locations}">
        <c:forEach var="location" items="${locations}">
        locationsCoordinates.push(new google.maps.LatLng(<c:out value="${location.lat}"/>, <c:out value="${location.lng}"/>));

        var marker = new google.maps.Marker({
            position: new google.maps.LatLng(<c:out value="${location.lat}"/>, <c:out value="${location.lng}"/>),
            map: map,
            title: 'Hello World!'
        });
        </c:forEach>
        </c:if>

        var locationPath = new google.maps.Polyline({
            path: locationsCoordinates,
            geodesic: true,
            strokeColor: '#FF0000',
            strokeOpacity: 1.0,
            strokeWeight: 2
        });
        locationPath.setMap(map);
    }
    google.maps.event.addDomListener(window, 'load', initializeHistoryMap);
</script>



