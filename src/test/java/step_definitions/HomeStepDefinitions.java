package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import utils.Operator;

public class HomeStepDefinitions {
    HomePage homePage = new HomePage();

    @Given("I add {int} and {int}")
    public void i_add_and(Integer int1, Integer int2) {
        homePage.getDigit(int1).click();
        homePage.click(Operator.PLUS);
        homePage.getDigit(int2).click();
    }

    @Then("the result should be {int}")
    public void the_result_should_be(Integer int1) {
        homePage.click(Operator.EQUALS);
        String actualResult = homePage.getResult().getText();
        Assert.assertEquals(int1 + "", actualResult);
    }
}
