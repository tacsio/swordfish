package com.swordfish.bdd;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty" }, junit= {"--filename-compatible-names"}, features = "src/test/resources", strict = true)
public class CucumberTests {

}
