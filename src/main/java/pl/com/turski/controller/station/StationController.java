package pl.com.turski.controller.station;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.com.turski.model.domain.station.Station;
import pl.com.turski.repository.station.StationRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * User: Adam
 */
@Controller
@RequestMapping("/station")
public class StationController {

    @Autowired
    private StationRepository stationRepository;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
        model.addAttribute("station", new Station());
        return "station/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid @ModelAttribute("station") Station station, BindingResult result) {
        if (result.hasErrors()) {
            return "station/add";
        }

        stationRepository.save(station);

        return "redirect:/station/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEdit(@NotNull @RequestParam(value = "stationId", required = true) Long stationId, Model model) {
        Station station = stationRepository.findOne(stationId);
        model.addAttribute("station", station);
        return "station/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("station") Station station, BindingResult result) {
        if (result.hasErrors()) {
            return "station/edit";
        }

        stationRepository.save(station);

        return "redirect:/station/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@NotNull @RequestParam(value = "stationId", required = true) Long stationId) {
        stationRepository.delete(stationId);
        return "redirect:/station/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(ModelMap model) {
        List<Station> stations = stationRepository.findAll();
        model.put("stations", stations);
        return "station/list";
    }
}
