package com.example.testassessment;

import com.example.testassessment.controller.AdController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
*   The only reason of this class existence is "only the command line will be used to launch this component"
 */
public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            return;
        }
        ApplicationContext context = new ClassPathXmlApplicationContext("/application-context.xml");
        AdController adController = (AdController) context.getBean("adController");
        String response = adController.serveAd(args[0]);
        System.out.println(response);
    }
}
