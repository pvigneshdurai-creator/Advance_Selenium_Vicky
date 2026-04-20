package Com.DemoShop_GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Com.DemoWebShop_POM.HomePage;
import Com.DemoWebShop_POM.LoginPage;
import Com.DemoWebShop_POM.WelcomePage;

public class BaseTest5 {
	
	public WebDriver driver;
	public static WebDriver sDriver;
	public FileUtility fileUtility=new FileUtility();
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;
	public WelcomePage welcomePage;
	public LoginPage loginPage;
	public HomePage homePage;
	public WebDriverUtility webDriverUtility= new WebDriverUtility();
	
	@BeforeSuite
	public void bs() {
		System.out.println("BeforeSuite DataBase Connected");
	}
	
	@BeforeTest
	public void bt() {
		System.out.println("BeforeTest Reports Started");
		spark=new ExtentSparkReporter(FrameWorkConstants.reportsPath);
		reports=new ExtentReports();
		reports.attachReporter(spark);
		test = reports.createTest("Address Module");

	}
	
	@BeforeClass
	public void bc() throws IOException {
		System.out.println("BeforeClass Browser Launched");
		//String browser = fileUtility.readDataFromPropertyFile("browserName");
		//String url=fileUtility.readDataFromPropertyFile("baseUrl");
		String browser = System.getProperty("browserName");   //for mvn test -Dbrowser=edge
		String url = System.getProperty("baseUrl");     //for mvn test -Durl=https://demowebshop.tricentis.com/
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			}else if(browser.equalsIgnoreCase("edge")){
			driver=new EdgeDriver();	
			}else if (browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();	
			}else {
				System.out.println("Enter valid Browser Name");
			}
		sDriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);

	}
	@BeforeMethod
	public void bm() throws IOException {
		System.out.println("@BeforeMethod Login");
		
		welcomePage = new WelcomePage(driver);
		welcomePage.getLoginBtn().click();
		
		loginPage=new LoginPage(driver);
		loginPage.getEmailTextField().sendKeys(fileUtility.readDataFromPropertyFile("emailId"));
		loginPage.getPasswordTextField().sendKeys(fileUtility.readDataFromPropertyFile("password"));
		loginPage.getLoginBtn().click();
		
		homePage=new HomePage(driver);
	}
	@AfterMethod
	public void am() {
		System.out.println("@AfterMethod Logout");
		homePage.getLogoutBtn().click();
	}
	@AfterClass
	public void ac() throws InterruptedException {
		System.out.println("@AfterClass Browser Closed");
		Thread.sleep(3000);
		driver.quit();
	}
	@AfterTest
	public void at() {
		System.out.println("@AfterTest Reports Ended");
		reports.flush();
	}
	@AfterSuite
	public void as() {
		System.out.println("@AfterSuite DataBase DisConnected");
		
	}
	
	
}
