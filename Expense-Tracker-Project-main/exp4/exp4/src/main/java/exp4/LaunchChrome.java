package exp4;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.junit.Assert;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
public class LaunchChrome {
	
	
	
	 private WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	        driver = new ChromeDriver();
	    }
	
	@Test(dataProvider = "credentials",priority = 2)
	public void test_login(String scenario, String Username, String Password){
		
//		    WebDriver driver = new ChromeDriver();
            driver.get("http://localhost:3000/Login");
            try {
                Thread.sleep(1000);
                }
                catch(InterruptedException e) {
                	e.printStackTrace();
                }

          
            WebElement usernameInput = driver.findElement(By.name("email"));
            WebElement passwordInput = driver.findElement(By.name("password"));
            WebElement loginButton = driver.findElement(By.name("submit"));

            usernameInput.sendKeys(Username);
            passwordInput.sendKeys(Password);
            loginButton.click();
            try {
                Thread.sleep(1000);
                }
                catch(InterruptedException e) {
                	e.printStackTrace();
                }
            
            if(scenario.equals("bothCorrect")) { 	
            	WebElement account = driver.findElement(By.name("Expenses"));
            	Assert.assertTrue(account.isDisplayed());
            }
            else if(scenario.equals("bothWrong")) {
            	String errorMessage = driver.findElement(By.cssSelector(".message-error ul>li")).getText();
            	Assert.assertEquals(errorMessage,"error");
            }
            
            else if(scenario.equals("correctUserName")) {
            	String errorMessage = driver.findElement(By.cssSelector(".message-error ul>li")).getText();
            	Assert.assertEquals(errorMessage,"errort");
            }
            
            else {
            	String errorMessage = driver.findElement(By.cssSelector(".message-error ul>li")).getText();
            	Assert.assertEquals(errorMessage,"error");
            }
            try {
            Thread.sleep(1000);
            }
            catch(InterruptedException e) {
            	e.printStackTrace();
            }

     


		
	}
	
	@Test(priority=3)
	public void testAddExepense() {
//	 WebDriver driver = new ChromeDriver();
     driver.get("http://localhost:3000/Login");
     try {
         Thread.sleep(1000);
         }
         catch(InterruptedException e) {
         	e.printStackTrace();
         }
    
     
     WebElement usernameInput = driver.findElement(By.name("email"));
     WebElement passwordInput = driver.findElement(By.name("password"));
     WebElement loginButton = driver.findElement(By.name("submit"));

     usernameInput.sendKeys("ljain_be21@thapar.edu");
     passwordInput.sendKeys("test@123");
     loginButton.click();
     try {
         Thread.sleep(1000);
         }
         catch(InterruptedException e) {
         	e.printStackTrace();
         }

		
      WebElement expenseButton = driver.findElement(By.name("Expenses"));
      expenseButton.click();
      
      
      WebElement expenseTitle = driver.findElement(By.name("title"));
      expenseTitle.sendKeys("food");
      
      WebElement expenseAmount = driver.findElement(By.name("amount"));
      expenseAmount.sendKeys("500");
      
      WebElement expenseDate = driver.findElement(By.id("date"));
      expenseDate.sendKeys("2024-02-29");
      
      
      
      WebElement categoryDropdown = driver.findElement(By.id("category"));
      Select categorySelect = new Select(categoryDropdown);
      List<WebElement> options = categorySelect.getOptions();
      int randomIndex = new Random().nextInt(options.size());
      categorySelect.selectByIndex(randomIndex);
      
      WebElement expenseDescription = driver.findElement(By.id("description"));
      expenseDescription.sendKeys("hellooo");
      
      
      WebElement submitButton = driver.findElement(By.className("submit-btn"));
      submitButton.click();
      try {
          Thread.sleep(1000);
          }
          catch(InterruptedException e) {
          	e.printStackTrace();
          }
		
	}
	
	
	@Test(dataProvider = "credentials1",priority = 1)
	public void testRegister(String Username,String Email ,String Password) {
//		 WebDriver driver = new ChromeDriver();
		 try {
	         Thread.sleep(1000);
	         }
	         catch(InterruptedException e) {
	         	e.printStackTrace();
	         }
         driver.get("http://localhost:3000/Register");
         WebElement usernameName = driver.findElement(By.name("name"));
         WebElement usernameInput = driver.findElement(By.name("email"));
         WebElement passwordInput = driver.findElement(By.name("password"));
         WebElement registerButton = driver.findElement(By.className("submit"));
         
         usernameName.sendKeys(Username);
         usernameInput.sendKeys(Email);
         passwordInput.sendKeys(Password);
         registerButton.click();
         try {
             Thread.sleep(1000);
             }
             catch(InterruptedException e) {
             	e.printStackTrace();
             }
         
         WebElement loginBox = driver.findElement(By.className("login-box"));
         assert loginBox.isDisplayed();
         
         try {
         Thread.sleep(1000);
         }
         catch(InterruptedException e) {
         	e.printStackTrace();
         }
		
	}
	
	@Test(dataProvider = "incomeTestData", priority = 4)
	public void IncomeTest(String title, String amount, String date, String category, String description){
		try {
	         Thread.sleep(1000);
	         }
	         catch(InterruptedException e) {
	         	e.printStackTrace();
	         }
	    
//	  
////	        WebDriver driver = new ChromeDriver(options);
//
//	        // Navigate to the React app
	        driver.get("http://localhost:3000/Dashboard");
//
//	        // Wait for the form to load
	        WebElement incomeButton = driver.findElement(By.name("Income"));
	        incomeButton.click();
//
//	        // Fill form fields
	        WebElement titleInput = driver.findElement(By.name("title"));
	        titleInput.sendKeys(title);
//
	        WebElement amountInput = driver.findElement(By.name("amount"));
	        amountInput.sendKeys(amount);
//
	        WebElement dateInput = driver.findElement(By.id("date"));
	        dateInput.sendKeys(date); // Enter date in the format expected by the date picker

	        WebElement categorySelect = driver.findElement(By.id("category"));
	        categorySelect.sendKeys(category);

	        WebElement incomeDescription = driver.findElement(By.id("description"));
	        incomeDescription.sendKeys(description);

	        // Submit the form
	        WebElement submitBtn = driver.findElement(By.className("submit-btn"));
	        submitBtn.click();
	        try {
		         Thread.sleep(1000);
		         }
		         catch(InterruptedException e) {
		         	e.printStackTrace();
		         }
//	        driver.quit();
	    }
	
	
	@DataProvider(name = "credentials")
	public Object[][] getData(){
		
		return new Object[][] {
			{"bothCorrect","ljain_be21@thapar.edu","test@123"},
			{"bothWrong","lakshya@gamil.com","snabsjb123"},
			{"correctUserName","ljain_be21@thapar.edu","jkscjn"},
			{"correctPassword","lakshaya@gmail.com","test@123"}
		
	};
	}
	
	
	@DataProvider(name = "credentials1")
	public Object[][] getData1(){
		
		return new Object[][] {
			 { "John Doe", "john.doe@example.com", "password123" },
			  { "Jane Smith", "jane.smith@example.com", "securePass456" },
			  // Invalid data (short name)
			  { "Bob", "bob.invalid@example.com", "invalid123" },
			  // Invalid data (missing space in name)
			  { "AliceInvalid", "alice.invalid@example.com", "invalidPass789" },
			  // Invalid data (invalid email format)
			  { "Eva Martinez", "invalid-email", "invalidP@ssword" },
			  // Invalid data (short password)
			  { "Michael Brown", "michael.brown@example.com", "short" },
			  // Invalid data (missing @ in email)
			  { "Olivia Davis", "olivia.davis.example.com", "invalidPass789" },
			  // Valid data
			  { "William Turner", "william.turner@example.com", "willT123" },
			  // Invalid data (short name and missing space)
			  { "ShortName", "shortname@example.com", "invalidPassword" },
			  // Invalid data (password with spaces)
			  { "Liam Wilson", "liam.wilson@example.com", "pass with spaces" },
		
	};

}
	
	@DataProvider(name = "incomeTestData")
	public Object[][] incomeTestData() {
	    return new Object[][]{
	            // Correct test data
	            {"Test Income 1", "1000", "2024-04-30", "Salary", "Income description 1"},
	            {"Test Income 2", "2000", "2024-05-01", "Freelancing", "Income description 2"},
	            {"Test Income 3", "1500", "2024-05-02", "Investments", "Income description 3"},
	            {"Test Income 4", "1800", "2024-05-03", "Stocks", "Income description 4"},
	            {"Test Income 5", "2500", "2024-05-04", "Bitcoin", "Income description 5"},
	            {"Test Income 6", "2200", "2024-05-05", "Bank", "Income description 6"},
	            {"Test Income 7", "3000", "2024-05-06", "Youtube", "Income description 7"},
	            
	            // Incorrect test data
	            {"", "1000", "2024-04-30", "Salary", "Empty title"},
	            {"Test Income", "", "2024-04-30", "Salary", "Empty amount"},
	            {"Test Income 8", "2000", "2024/05/01", "Freelancing", "Incorrect date format"},
	            {"Test Income 9", "1500", "2024-05-02", "", "Empty category"},
	            {"Test Income 10", "1800", "2024-05-03", "Stocks", ""}, // Empty description
	            {"Test Income 11", "Invalid amount", "2024-05-03", "Bank", "Invalid amount format"}
	            // Add more incorrect test data as needed
	    };
	}


}