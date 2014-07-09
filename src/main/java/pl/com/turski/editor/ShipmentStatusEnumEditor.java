package pl.com.turski.editor;

import pl.com.turski.model.domain.shipment.ShipmentStatusEnum;

import java.beans.PropertyEditorSupport;

/**
 * User: Adam
 */
public class ShipmentStatusEnumEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        return getValue() == null ? "" : ((ShipmentStatusEnum) getValue()).name();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.trim().isEmpty()) {
            setValue(null);
            return;
        }
        setValue(ShipmentStatusEnum.valueOf(text.trim()));
    }
}
