package com.mindtree.cucumber;

import org.junit.runner.RunWith;

import com.mindtree.testbase.BaseClass;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import cucumber.api.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/feature",
glue= {"com.mindtree.cucumber.steps"})
public class CountryRunner{

	
}
