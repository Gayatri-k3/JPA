package com.xworkz.railways.controller;

import com.xworkz.railways.dto.RailwayDTO;
import com.xworkz.railways.service.RailwayService;
import javafx.geometry.Pos;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")

public class RailwayController {
    public RailwayController(){
        System.out.println("RailwayController loaded");
    }
    @Autowired
    private RailwayService railwayService;

    @GetMapping("/getIndex")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/redirectToForm")
    public String redirectToForm(){
        return "RailwayBooking";
    }

    @PostMapping("/booking")
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

    @GetMapping("/getAll")
    public String getAll(Model model){
        System.out.println("getAll in controller");
        List<RailwayDTO> list=railwayService.getAll();
        list.forEach(System.out::println);
        model.addAttribute("listOfDto",list);
        return "getList";
    }
}
