package com.kede.frontoffice;

import java.util.Collections;
import java.util.Map;

import javax.print.attribute.standard.Media;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.apache.catalina.connector.Response;
// import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.WebUtils;

@Controller
@CrossOrigin
public class SignUpController {

    @GetMapping("/signup")
    public String showSignup(HttpServletRequest req) {
        try {
            Cookie id = WebUtils.getCookie(req, "id");
            Cookie token = WebUtils.getCookie(req, "token");
            if (id.getValue() != null & token.getValue() != null) {
                return "redirect:/home";
            }
        } catch (Exception e) {
            return "signup";
        }

        return "signup";
    }

    public String paramJson(String paramIn) {
        paramIn = paramIn.replaceAll("=", "\":\"");
        paramIn = paramIn.replaceAll("&", "\",\"");
        return "{\"" + paramIn + "\"}";
    }

    @PostMapping("/signUp")
    public String createAccount(@RequestBody String payload, HttpServletResponse resp) {
        String uri = "http://localhost:9191/addUser";
        RestTemplate rest = new RestTemplate();
        String req = paramJson(payload);
        // JSONObject jsonObject = new JSONObject(req);

        System.out.println("====================================" + req);
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(req, headers);

        String response = rest.postForObject(uri, entity, String.class);
        System.out.println(response);

        JsonObject convertedObject = new Gson().fromJson(response, JsonObject.class);

        String id = convertedObject.get("id").toString();
        String token = convertedObject.get("token").toString();

        resp.addCookie(new Cookie("id", id));
        resp.addCookie(new Cookie("token", token));

        return "redirect:/home";

    }
}
