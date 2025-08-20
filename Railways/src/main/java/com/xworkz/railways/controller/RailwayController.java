package com.xworkz.railways.controller;

import com.xworkz.railways.dto.RailwayDTO;
import com.xworkz.railways.service.RailwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")

public class RailwayController {
    public RailwayController(){
        System.out.println("RailwayController loaded");
    }
    @Autowired
    private RailwayService railwayService;


    @PostMapping("booking")
    public String save(@Valid RailwayDTO dto, Model model, BindingResult bindingResult) {
        System.out.println("DTO data in save method of controller: " + dto);
        boolean saved = railwayService.validateAndSave(dto);
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(errors -> System.out.println(errors.getField() + " : " + errors.getDefaultMessage()));
            model.addAttribute("dto", dto);
            model.addAttribute("msg", "Invalid Details");
            return "RailwayBooking";
        }
        if (saved) {
            model.addAttribute("msg", "Submitted Successfully");
            return getAll(model);
        }else {
            model.addAttribute("errorMsg","Invalid data");
            model.addAttribute("dto",dto);
        }
        return "RailwayBooking";
    }

    public String getAll(Model model){
        return "";
    }
}
