package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.Operator;

public class HomePage {
    @AndroidFindBy(accessibility = "sum")
    private MobileElement sum;

    @AndroidFindBy(accessibility = "plus")
    private MobileElement plus;

    @AndroidFindBy(accessibility = "divide")
    private MobileElement divide;

    @AndroidFindBy(accessibility = "minus")
    private MobileElement minus;

    @AndroidFindBy(id = "com.google.android.calculator:id/result_final")
    private MobileElement result;

    //in Appium, we have wrap Driver with AppiumFieldDecorator class to enable @MobileBy annotations
    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    public MobileElement getDigit(int digit) {
        return Driver.getDriver().findElementById("com.google.android.calculator:id/digit_" + digit);
    }

    public MobileElement getSum() {
        return this.sum;
    }

    public void click(Operator operator) {
        switch (operator){
            case PLUS:
                this.plus.click();
                break;
            case MINUS:
                this.minus.click();
                break;
        }
    }

}
