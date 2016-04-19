package no.learning.lars.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * IndexController maps the root URL to the index html file
 * Common convention in Spring MVC to return the string name of the template file without the file extension.
 * The Controller annotation maked this class a Spring component and a Spring MVC controller
 * */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
