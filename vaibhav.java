// TMT-West1 - Test automation Asserting IoT (To automate the testing the testing of IoT devices in a 5G ready Environment)
// Team Name- IT Elites  (Sanjivani College Of Engineering Kopergaon)
// Team members - 1)Tejas Nagare   2)Vaibhav Lokhande   3)Raviraj Nehul   4)Rahul Kolse  5)Mitusha Pawar


package com.jatayu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class vaibhav {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","E:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Test Case 1: Verify the title of the homepage
        driver.get("http://scoeit.in/");
        String expectedTitle = "Water Level Management System";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Test Case 1 Passed: Homepage title is correct");
        } else {
            System.out.println("Test Case 1 Failed: Homepage title is incorrect");
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Test Case 2: Verify the presence of a specific element
        WebElement element = driver.findElement(By.xpath("//*[@id=\"sec4\"]/div/progress"));
        if (element.isDisplayed()) {
            System.out.println("Test Case 2 Passed: Element is present on the page");
        } else {
            System.out.println("Test Case 2 Failed: Element is not present on the page");
        }
        
        //Test Case 3:The Logos of website are Present or not
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"sec1\"]/table/tbody/tr/td[3]/img"));
        if (element1.isDisplayed()) {
            System.out.println("Test Case 3 Passed:Logo is present on the page");
        } else {
            System.out.println("Test Case 3 Failed: Logo is not present on the page");
        }
      
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //Test Case 4: 
        if(element!= null) {
        	System.out.println("Test Case 4: Passed");
        }
        else {
        	System.out.println("Test Case 4: Failed");
        }
        
        //Test case 5 : Whether the Header is present or not
        
        WebElement headerElement = driver.findElement(By.xpath("//*[@id=\"sec1\"]/table/tbody/tr/td[2]/h3"));
        boolean isHeaderDisplayed = headerElement.isDisplayed();
        if (isHeaderDisplayed) {
            System.out.println("Test case 5:Header is displayed");
        } else {
            System.out.println("Test case 5:Header is not displayed");
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      //Test Case 6 :Check the footer
        WebElement footerElement = driver.findElement(By.xpath("/html/body/center[3]/footer"));
        boolean isFooterDisplayed = footerElement.isDisplayed();
        if (isFooterDisplayed) {
            System.out.println("Test case 6: Footer is displayed");
        } else {
            System.out.println("Test case 6:Footer is not displayed");
        }
        
        
        // Test Case 7: Whether the Website properly Refreshing after 5 minutes
        // Our website is refreshing after every 5 seconds to retrive the data from the my Php server accurately
        // 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get the current URL after 5 seconds
        String currentURL = driver.getCurrentUrl();

        // Check if the URL has changed
        if (currentURL.equals("http://scoeit.in/")) {
            System.out.println("Test case 7:Website is  refreshing automatically after 5 seconds");
        } else {
            System.out.println("Test case 7:Website is not refreshing automatically after 5 seconds ");
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Test 8: Water level Indicator Loaded on the screen or not
        // As the main component of our website is water level indicator
        List<WebElement> imageElements = driver.findElements(By.xpath("//*[@id=\"sec4\"]/div/progress"));

        // Iterate through each image element and check if it is loaded
        for (WebElement imageElement : imageElements) {
            String imageUrl = imageElement.getAttribute("src");

            // Check if the image source is valid
            boolean isImageLoaded = driver.findElements(By.xpath("//*[@id=\"sec4\"]/div/progress")).size() > 0;

            if (isImageLoaded) {
                System.out.println("Test case 8:The Water level indication Loaded Successfully");
            } else {
                System.out.println("Test case 8:The Water level indication failed to Load Successfully");
            }
        }
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The website refreshing 10 times");
        //Test case 9 : Refresh test
        // We are testing that after refreshing site working properly or not.
        for (int i = 0; i < 10; i++) {
            // Refresh the page
            driver.navigate().refresh();
        }

            boolean isBodyLoaded = driver.findElements(By.xpath("/html/body")).size() > 0;

            // Print the result
            if (isBodyLoaded) {
                System.out.println("Test case 9:After Refreshing site for 10 times Website shows the Corect Results");
            } else {
                System.out.println("Test case 9:After Refreshing site for 10 times Website unable to shows the Corect Results");
            }

            
            // Test case for Messaging System
            WebElement messageElement = driver.findElement(By.xpath("/html/body/center[2]"));

            // Get the text of the message
            String messageText = messageElement.getText();
            System.out.println("Message: " + messageText);

            // Perform assertions to validate the message
            if (messageText.contains("Overhead Tank is 100%\r\n"
            		+ "Tank is Full...\r\n"
            		+ "Switch Off the Motor")) {
                System.out.println("Test case 10:Message received successfully.");
            } else {
                System.out.println("Test case 10:Message Not Recieved.");
            }
        
            // Quit the driver
        driver.quit();
    }
}
