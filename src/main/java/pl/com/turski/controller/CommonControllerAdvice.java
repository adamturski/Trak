package pl.com.turski.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;
import pl.com.turski.editor.ShipmentStatusEnumEditor;
import pl.com.turski.exception.BusinessException;
import pl.com.turski.model.domain.shipment.ShipmentStatusEnum;

import javax.servlet.http.HttpServletRequest;

/**
 * User: Adam
 */
@ControllerAdvice
public class CommonControllerAdvice {

    private static final Logger LOG = LoggerFactory.getLogger(CommonControllerAdvice.class);

    @InitBinder
    public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.registerCustomEditor(ShipmentStatusEnum.class, new ShipmentStatusEnumEditor());

    }


    @ExceptionHandler(BusinessException.class)
    public ModelAndView handleBusinessException(HttpServletRequest req, BusinessException exception) {
        LOG.error("Business exception occurred", exception);

        ModelAndView mav = new ModelAndView();
        mav.addObject("message", exception.getErrorCode().name());
        mav.setViewName("error");
        return mav;
    }
}
