package t124003.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import t124003.backend.service.BufferService;
import t124003.backend.service.sessionmanagement.CustomUserDetails;

/**
 * Created by Raviool on 26.05.2015.
 */
@Controller
public class HeaderController {

    @Autowired
    BufferService bufferService;

    @RequestMapping("/clearbuffer")
    public String clearBuffer() {
        bufferService.emptyBuffer((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "header";
    }

}
