package com.experiments.bdd.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Runner for all feature tests
 * @author meherm01
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "html:target/cucumber" },
				glue = "com.experiments.bdd.steps",
				features = "classpath:cucumber",
				tags = {"@FunctionalTest,@MetaDataTest" })
public class RunRestTest {
}
