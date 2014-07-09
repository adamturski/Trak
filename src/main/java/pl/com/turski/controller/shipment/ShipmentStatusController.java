package pl.com.turski.controller.shipment;

import com.google.appengine.repackaged.com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.com.turski.model.domain.shipment.ShipmentStatus;
import pl.com.turski.repository.shipment.ShipmentStatusRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * User: Adam
 */
@Controller
@RequestMapping("/shipment/status")
public class ShipmentStatusController {

    @Autowired
    private ShipmentStatusRepository shipmentStatusRepository;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
        model.addAttribute("shipmentStatus", new ShipmentStatus());
        return "shipment/status/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid @ModelAttribute("shipmentStatus") ShipmentStatus shipmentStatus, BindingResult result) {
        if (result.hasErrors()) {
            return "shipment/status/add";
        }

        shipmentStatusRepository.save(shipmentStatus);

        return "redirect:/shipment/status/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEdit(@NotNull @RequestParam(value = "shipmentStatusId", required = true) Long shipmentStatusId, Model model) {
        ShipmentStatus shipmentStatus = shipmentStatusRepository.findOne(shipmentStatusId);
        model.addAttribute("shipmentStatus", shipmentStatus);
        return "shipment/status/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("shipmentStatus") ShipmentStatus shipmentStatus, BindingResult result) {
        if (result.hasErrors()) {
            return "shipment/status/edit";
        }

        shipmentStatusRepository.save(shipmentStatus);

        return "redirect:/shipment/status/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@NotNull @RequestParam(value = "shipmentStatusId", required = true) Long shipmentStatusId) {
        shipmentStatusRepository.delete(shipmentStatusId);
        return "redirect:/shipment/status/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(ModelMap model) {
        List<ShipmentStatus> shipmentStatuses = Lists.newArrayList(shipmentStatusRepository.findAll());
        model.put("shipmentStatuses", shipmentStatuses);
        return "shipment/status/list";
    }
}
