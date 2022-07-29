package methods;

import base.BaseProcess;
import base.LogProcess;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Methods extends BaseProcess {


    public WebElement findElement(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        LogProcess.info(by +" Element finded.");
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        LogProcess.info(by+" element's list finded.");
        return driver.findElements(by);
    }

    public int randomPick(int size) {
        Random rand = new Random();
        int minimum = 1;
        int pick = rand.nextInt(size - minimum) + minimum;
        LogProcess.info("Number selected from " + minimum + " to  " +size+ " ---> "+pick);
        return pick;
    }

    public void randomBookPickClick(By by) {

        int a = randomPick(findElements(by).size());
        WebElement element = findElements(by).get(a);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
        LogProcess.info("Ramdonly selected element is clicked...");
    }

    public String getText(By by, String text) {

        wait.until(ExpectedConditions.textToBe(by, text));
        LogProcess.info(by+ " element's text value :  " +text);
        return findElement(by).getText();


    }

    public void assertionTextControl(By by, String text) {

        Assert.assertEquals("Tests is not equal...",text, getText(by, text));

        System.out.println("Compare" + by+ "text with "+ text +" text.");
    }

    public void clickToElement(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
        LogProcess.info(by + " element was clicked");


    }

    public void clearToElement(By by) {

        findElement(by).clear();
        LogProcess.info(by + " element was deleted.");
    }

    public void currentUrlControl(String url) {
        LogProcess.info(driver.getCurrentUrl());
        Assert.assertEquals("The URL of the current site is not the same as the targeted site.", driver.getCurrentUrl(), url);
        LogProcess.info(url + " The site has been verified.");


    }

    public void getUrl(String url) {
        driver.get(url);


    }

    public void sendKey(By by, String key) {
        findElement(by).sendKeys(key);
        LogProcess.info("Text "+by +" is written to "+ key +" element.");
    }

    public void enterKey(By by) {
        findElement(by).sendKeys(Keys.ENTER);
        LogProcess.info("Clicked the Enter.");
    }

    public String csvRead() {
        String csv = "src/test/java/Roman.csv";
        File file = new File(csv);
        String roman = null;
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                roman = sc.next();
            }
            sc.close();
        } catch (FileNotFoundException e) {
            LogProcess.warn("An error was encountered while reading the file.");
        }
        LogProcess.info("*The word " + roman + " was retrieved from the CSV file.*");
        return roman;
    }


}
