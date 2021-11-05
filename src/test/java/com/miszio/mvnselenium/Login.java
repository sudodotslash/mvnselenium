package com.miszio.mvnselenium;
// import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Login {
	WebDriver driver;
	@BeforeTest
	public void setup(){
		ChromeOptions options = new ChromeOptions();
		options.setBinary("/usr/bin/google-chrome-stable");
		options.addArguments("start-maximized"); // open Browser in maximized mode
		// options.addArguments("disable-infobars"); // disabling infobars
		// options.addArguments("--disable-extensions"); // disabling extensions
		// options.addArguments("--disable-gpu"); // applicable to windows os only
		// options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		// options.addArguments("--headless");
		// options.addArguments("--no-sandbox"); // Bypass OS security model
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);
		driver = new ChromeDriver(options);
	}
	@Test
	private void loginTest(){
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String pageTitle = driver.getTitle();
		System.out.println("The title of this page is ===> " +pageTitle);
		assertEquals("OrangeHRM", pageTitle);
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		System.out.println("Successfully logged in");
	}
	@AfterTest
	public void teardown(){
		driver.quit();
	}
}
