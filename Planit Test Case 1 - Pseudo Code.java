public class ValidateMandatoryFields
{
	@Test
	public static void main (String[] args)
	{
		//Setup Browser
		System.setProperty("<webdriver name>", "<webdriver location>");
		WebDriver driver = new <Driver Name>();
		driver.get("URL for Planit Homepage");
		driver.manage().window().maximize();
		
		//Navigate to Contact Page
		driver.findElement(By.id("nav-contact")).click();
		
		//Click submit button
		driver.findElement(By.className("btn-contact btn btn-primary")).click();
		
		//Verify Required Field Error Messages
		driver.findElement(By.id("forename-err")).isDisplayed();
		driver.findElement(By.id("email-err")).isDisplayed();
		driver.findElement(By.id("message-err")).isDisplayed();

		//Populate Mandatory Fields
  		driver.findElement(By.id("forename")).sendKeys("Sample Name");
		driver.findElement(By.id("email")).sendKeys("sample_email@gmail.com");
		driver.findElement(By.id("message")).sendKeys("Sample Message");

		//Validate Errors are no longer Displayed
		Assert.assertEquals(driver.findElement(By.id("forename-err")).isDisplayed(), false);
		Assert.assertEquals(driver.findElement(By.id("email-err")).isDisplayed(), false);
		Assert.assertEquals(driver.findElement(By.id("message-err")).isDisplayed(), false);
	}
}					

