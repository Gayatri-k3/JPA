package com.xworkz.grooving.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("package com.xworkz.grooving")
public class SpringConfig {
    public SpringConfig(){
        System.out.println("SpringConfig loaded");
    }
}
