package com.candemirhan.controller;

import com.candemirhan.dto.request.SoruEklemeRequestDto;
import com.candemirhan.service.SorularService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/sorular")
@RequiredArgsConstructor
public class SorularController {

    private final SorularService sorularService;

    @GetMapping("/soruekle")
    public ModelAndView soruEkleme(){
        ModelAndView model = new ModelAndView();
        model.addObject("userid",1);
        model.setViewName("soruolusturma");
        return model;
    }

    @CrossOrigin
    @PostMapping(value = "/soruekle")
    public ModelAndView soruEkleme(@RequestBody SoruEklemeRequestDto dto){
        sorularService.soruEkle(dto);
        return new ModelAndView("redirect:soruekle");
    }

}
