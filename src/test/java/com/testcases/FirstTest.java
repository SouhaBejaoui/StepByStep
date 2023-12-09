package com.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
	
	private WebDriver driver;
	
	@BeforeSuite	
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(priority = 0)
	public void openHome() {
		driver.get("https://automationexercise.com/");
		assertEquals(driver.getTitle(), "Automation Exercise", "It's not the home page");
	}
	
	@Test(priority = 1)
	public void signUpMenu() {
		WebElement signUpLink = driver.findElement(By.linkText("Signup / Login"));
		signUpLink.click();
		WebElement signUpHeader = driver.findElement(By.xpath("//h2[contains(text(), 'New User Signup!')]"));
		assertEquals(signUpHeader.isDisplayed(), true, "It's not displayed");
	}
	
	@Test(priority = 2)
	public void signUp() {
		WebElement nameInput = driver.findElement(By.xpath("//input[@data-qa = 'signup-name']"));
		WebElement emailInput = driver.findElement(By.xpath("//input[@data-qa = 'signup-email']"));
		WebElement signUpButton = driver.findElement(By.xpath("//button[@data-qa = 'signup-button']"));
		String username = "admin";
		String email = "admin@localhost.dev";
		nameInput.sendKeys(username);
	    emailInput.sendKeys(email);
	    signUpButton.click();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
