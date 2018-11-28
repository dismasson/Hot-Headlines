package com.sxli.hotheadlines.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @GetMapping("/hot")
    public List<Long> hotNews() {
        return null;
    }
}
