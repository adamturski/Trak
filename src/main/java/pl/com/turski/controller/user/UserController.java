package pl.com.turski.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.com.turski.model.domain.user.Role;
import pl.com.turski.model.domain.user.User;
import pl.com.turski.repository.user.UserRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * User: Adam
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("userRoles", Role.values());
        return "user/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user/add";
        }

        userRepository.save(user);

        return "redirect:/user/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEdit(@NotNull @RequestParam(value = "userId", required = true) Long userId, Model model) {
        User user = userRepository.findOne(userId);
        model.addAttribute("user", user);
        model.addAttribute("userRoles", Role.values());
        return "user/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("user") User user, Model model, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("userRoles", Role.values());

            return "user/edit";
        }

        userRepository.save(user);

        return "redirect:/user/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@NotNull @RequestParam(value = "userId", required = true) Long userId) {
        userRepository.delete(userId);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(ModelMap model) {
        List<User> users = userRepository.findAll();
        model.put("users", users);
        return "user/list";
    }
}
