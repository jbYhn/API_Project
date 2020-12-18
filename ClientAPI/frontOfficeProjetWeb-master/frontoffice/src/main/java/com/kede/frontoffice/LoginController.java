package com.kede.frontoffice;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.WebUtils;

@Controller
@CrossOrigin
public class LoginController {

    @GetMapping("/login")
    public String showSurvey(HttpServletRequest req) {
        try {
            Cookie id = WebUtils.getCookie(req, "id");
            Cookie token = WebUtils.getCookie(req, "token");
            if (id.getValue() != null & token.getValue() != null) {
                return "redirect:/home";
            }
        } catch (Exception e) {
            return "login";
        }

        return "login";
    }
}
