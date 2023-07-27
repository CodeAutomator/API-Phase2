package runnerfile;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//import org.junit.runner.RunWith;



//import io.cucumber.junit.CucumberOptions;

//import io.cucumber.junit.Cucumber;

//@RunWith(Cucumber.class)
@CucumberOptions(
plugin = {"pretty","html:Report/cucumber-reports.html","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		}, //reporting purpose
			monochrome=false,  //console output color and removes unecessary options
			dryRun=false ,
			//tags=("@Postbatchcreate"),
			//tags=("@1CreateDataP"),// ifid tue then that means all the steps in feature have been defined or not
			//features = {".\\src\\test\\resources\\Features\\AssignmentPositiveScenarios.feature"},
				features = {"src\\test\\resources\\Features"
//						"src\\test\\resources\\Features\\2ProgramNegative.feature"
////						"src\\test\\resources\\Features\\2PositiveScenariosForUser.feature",
////						"src\\test\\resources\\Features\\3AssignmentPositiveScenarios.feature",
////						"src\\test\\resources\\Features\\4postsubassignment.feature",
////						"src\\test\\resources\\Features\\Delete.feature"
						},
			glue= "stepdefinitions")

public class Testrunner extends AbstractTestNGCucumberTests {
	@DataProvider(parallel = false)
	public Object[][] scenarios() {

		return super.scenarios();
	}
	}
//AssignmentPositiveScenarios.feature
//postsubassignment.feature
//@1CreateDataP
//@assign
//@assignid- showing not found   id for already created assginment id-get grades