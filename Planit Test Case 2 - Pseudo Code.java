public class ValidateSuccessfulSubmissionMessage
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

		for (int runCount=0; runCount<5; runCount++)
		{		
			//Populate Mandatory Fields
  			driver.findElement(By.id("forename")).sendKeys("Sample Name");
			driver.findElement(By.id("email")).sendKeys("sample_email@gmail.com");
			driver.findElement(By.id("message")).sendKeys("Sample Message");

			//Click submit button
			driver.findElement(By.className("btn-contact btn btn-primary")).click();

			//Verify Required Field Error Messages
			driver.findElement(By.class("alert alert-success")).isDisplayed();
			
			//Navigate Back to Contact Page
			driver.findElement(By.id("nav-contact")).click();
		}
	}
}			
