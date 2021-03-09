package nl.brianvermeer.snyk.springmvc.controller;

import nl.brianvermeer.snyk.springmvc.controller.util.CookieUtil;
import nl.brianvermeer.snyk.springmvc.model.Message;
import nl.brianvermeer.snyk.springmvc.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@Controller
public class MessageController {

    @Autowired
    MessageRepo repo;

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String messages(Model model) {
        model.addAttribute("messages", repo.findAllMessages());
        return "messages";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchMessages(Model model, @RequestParam("text") String searchText) {
        model.addAttribute("messages", repo.searchMessage(searchText));
        return "messages";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String newMessages(HttpServletResponse response, Model model, @RequestParam("text") String messageText, @CookieValue(value="userId", required=false) String userID) {
        if (userID == null) {
           userID = CookieUtil.createUserCookie(response);
        }
        repo.insertMessage(new Message(messageText, userID));
        model.addAttribute("messages", repo.findAllMessages());
        return "messages";
    }
    //public String submit(HttpServletResponse response, @RequestParam("file") MultipartFile file, ModelMap modelMap, @CookieValue(value="userId", required=false) String userID)


}
