package com.example.demo.controller;

import com.example.demo.aspera.FilesAPI;
import org.springframework.stereotype.Controller;

/**
 * @Created 26 / 03 / 2020 - 10:47 AM
 * @project demo
 * @Author Hamdamboy
 */
@Controller
public class ControllerFilesAPI {
     //
    private FilesAPI filesAPI;

      @RequestMapping("/hello")
    public String TestFile() {
        return "Coming data is going";
    }

}
