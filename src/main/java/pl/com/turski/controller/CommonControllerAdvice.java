package pl.com.turski.controller;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import pl.com.turski.editor.ShipmentStatusEnumEditor;
import pl.com.turski.model.domain.shipment.ShipmentStatusEnum;

import javax.servlet.http.HttpServletRequest;

/**
 * User: Adam
 */
//@ControllerAdvice
public class CommonControllerAdvice {
    @InitBinder
    public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.registerCustomEditor(ShipmentStatusEnum.class, new ShipmentStatusEnumEditor());

    }
}
