package t124003.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Raviool on 23.05.2015.
 */
@Deprecated
@Controller
public class LoginController {

    @RequestMapping("login")
    public ModelAndView getLoginForm(@RequestParam(required = false) String authfailed, String logout, String denied) {
        System.out.println(authfailed + " " + logout + " " + denied);
        String message = "";
        if (authfailed != null) {
            message = "Invalid username of password, try again !";
        } else if (logout != null) {
            message = "Logged Out successfully, login again to continue !";
        } else if (denied != null) {
            message = "Access denied for this user !";
        }
        return new ModelAndView("login", "message", message);
    }
}
