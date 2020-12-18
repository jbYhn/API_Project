package com.kede.frontoffice;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
@CrossOrigin
public class SurveyController {

    public String paramJson(String paramIn) {
        paramIn = paramIn.replaceAll("=", "\":\"");
        paramIn = paramIn.replaceAll("&", "\",\"");
        return "{\"" + paramIn + "\"}";
    }

    @GetMapping("/survey")
    public String showSurvey(Model model) {
        return "survey";
    }


    @GetMapping("/addsurvey")
    public String addSurvey() {
        return "addSurvey";
    }

    @PostMapping("/addsurvey")
    public String submitSurvey(@RequestBody String payload, HttpServletRequest req2) {
//        String uri = "http://localhost:9191/addSurvey";
//        RestTemplate rest = new RestTemplate();
//        String req = paramJson(payload);
//        // JSONObject jsonObject = new JSONObject(req);
//
//        System.out.println("====================================" + req);
//        HttpHeaders headers = new HttpHeaders();
//
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<String> entity = new HttpEntity<String>(req, headers);
//
//        String response = rest.postForObject(uri, entity, String.class);
//        System.out.println(response);
//
//        JsonObject convertedObject = new Gson().fromJson(response, JsonObject.class);
//
//        Cookie id = WebUtils.getCookie(req2, "id");
//        Cookie token = WebUtils.getCookie(req2, "token");






        return "/success";
    }

}
