package com.example.demo.controller;

import com.example.demo.BowlingGame;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Set;

@Controller()
@RequestMapping("/")
public class MainController {
    private int[] dafaultValues = {1,4,4,5,6,4,5,5,10,0,0,1,7,3,6,4,10,0,2,8,6};
    @GetMapping
    public String main(Model model) {
        for (int i = 0; i < dafaultValues.length; i++) {
            model.addAttribute("val"+i, dafaultValues[i]);
        }
        return "main";
    }

    @PostMapping
    public String getResult(@RequestParam Map<String, String> allRequestParams, Model model) {
        int[] request = new int[21];
        int[] result = null;
        try {
            for (Map.Entry<String, String> entry :
                    allRequestParams.entrySet()) {
                request[Integer.parseInt(entry.getKey())] = Integer.parseInt(entry.getValue());

            }
        } catch (NumberFormatException e) {
            model.addAttribute("message", "Wrong number format. Try again.");
        }
        try {
            result = BowlingGame.getResult(request);
            for (int i = 0; i < result.length; i++) {
                model.addAttribute("res"+i, result[i]);
            }
        }catch (IllegalArgumentException e)
        {
            model.addAttribute("message", e.getMessage());
        }

        for (int i = 0; i < request.length; i++) {
            model.addAttribute("val"+i, request[i]);
        }
        return "main";
    }

}
