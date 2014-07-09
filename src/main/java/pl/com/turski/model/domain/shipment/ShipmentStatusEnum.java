package pl.com.turski.model.domain.shipment;

/**
 * User: Adam
 */
public enum ShipmentStatusEnum {
    ACCEPTED("Przyjęta"), ON_THE_WAY("W drodze"), IN_STATION("Na stacji"), IN_SERVICE("W obsłudze"), DELIVERED("Dostarczona");

    private String text;

    ShipmentStatusEnum(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
