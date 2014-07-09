package pl.com.turski.controller.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.com.turski.model.domain.vehicle.Vehicle;
import pl.com.turski.service.vehicle.VehicleService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * User: Adam
 */
@Controller
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getCreate(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "vehicle/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("vehicle") Vehicle vehicle, BindingResult result) {
        if (result.hasErrors()) {
            return "vehicle/create";
        }

        vehicleService.create(vehicle.getName(), vehicle.getDescription());

        return "redirect:/vehicle/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEdit(@NotNull @RequestParam(value = "vehicleId", required = true) Long vehicleId, Model model) {
        Vehicle vehicle = vehicleService.get(vehicleId);
        model.addAttribute("vehicle", vehicle);
        return "vehicle/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("vehicle") Vehicle vehicle, BindingResult result) {
        if (result.hasErrors()) {
            return "vehicle/edit";
        }

        vehicleService.update(vehicle.getId(),vehicle.getName(),vehicle.getDescription());

        return "redirect:/vehicle/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@NotNull @RequestParam(value = "vehicleId", required = true) Long vehicleId) {
        vehicleService.delete(vehicleId);
        return "redirect:/vehicle/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(ModelMap model) {
        List<Vehicle> vehicles = vehicleService.getAll();
        model.put("vehicles", vehicles);
        return "vehicle/list";
    }
}
