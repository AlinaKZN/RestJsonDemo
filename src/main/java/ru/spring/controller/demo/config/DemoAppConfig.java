package ru.spring.controller.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Controller
@EnableWebMvc
@ComponentScan("ru.spring.controller.demo")
public class DemoAppConfig {

}
