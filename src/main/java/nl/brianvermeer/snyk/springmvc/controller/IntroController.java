package nl.brianvermeer.snyk.springmvc.controller;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class IntroController {

    @RequestMapping(value = "/intro", method = RequestMethod.POST)
    public void introduction(HttpServletResponse response, @RequestParam("user") String userName) throws IOException {
        PrintWriter pw = response.getWriter();
        pw.println( "Hello " + userName);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        System.out.println("here");
        return "index";
    }
}
