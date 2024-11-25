package com.google.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
        },

        features = "src/test/resources/features",     //business layer
        glue = "com/google/step_definitions",   //implementation layer
        dryRun = false,  //true: it will run only feature file
        tags = "@calculator",
        publish = true  //generation a report with public link


)

public class CukesRunner {
}
