public class ValidateCart
{
	Map<String, Double> item = new HashMap<>();	
	
	@Test
	public static void main (String[] args)
	{
		Double price;
		//Setup Browser
		System.setProperty("<webdriver name>", "<webdriver location>");
		WebDriver driver = new <Driver Name>();
		driver.get("URL for Planit Homepage");
		driver.manage().window().maximize();

		//Navigate to Shop Page
		driver.findElement(By.id("nav-shop")).click();

		//Add Item to Cart
		item.put("Stuffed Frog", addToCart("Stuffed Frog", 2));
		item.put("Fluffy Bunny", addToCart("Fluffy Bunny", 5));
		item.put("Valentine Bear", addToCart("Valentine Bear", 3));

		//Go to Cart
		driver.findElement(By.id("nav-cart")).click();		

		//Verify test Steps 2-5
		verifyCartDetails();	
	}
	
	
	public double addToCart(String itemName, int itemQuantity)
	{
		String itemID;
		double itemPrice;
		switch(itemName)
		{
			case "Teddy Bear":
				itemID="product-1";
				break;
			case "Stuffed Frog":
				itemID="product-2";
				break;
			case "Handmade Doll":
				itemID="product-3";
				break;
			case "Fluffy Bunny":
				itemID="product-4";
				break;
			case "Smiley Bear":
				itemID="product-5";
				break;
			case "Funny Cow":
				itemID="product-6";
				break;
			case "Valentine Bear":
				itemID="product-7";
				break;
			case "Smiley Face":
				itemID="product-8";
				break;
		}

		WebElement itemDetails = driver.findElement(By.id(itemID));
		
		for (int quantity=0;quantity<itemQuantity;quantity++)
		{
			itemDetails.findElement(By.className("btn btn-success")).click();
		}
		itemPrice = Double.parseDouble(itemDetails.findElement(By.className("product-price ng-binding").getText()));
		return itemPrice;
	}

	public void verifyCartDetails()
	{
		double cartTotal = 0;
		List<WebElement> cartItems = driver.findElements(By.className("cart-item ng-scope"));
		for (WebElement cartItem: cartItems)
		{
			List<WebElement> ItemDetails = cartItem.findElements(By.tagName("td"));
			String itemName = ItemDetails.get(0).getText();
			double itemPrice = Double.parseDouble(ItemDetails.get(1).getText().replace("$", ""));
			int itemQuantity = Interger.parseInt(ItemDetails.get(2).getText());
			double itemSubtotal = Double.parseDouble(ItemDetails.get(3).getText().replace("$", ""));

			//compute and compare subtotal
			double subtotal = itemPrice * itemQuantity;
			Assert.assertEquals(itemSubtotal, subtotal);
			
			//compare price
			Assert.assertEquals(item.get(itemName),itemPrice);
			
			//get cart total
			cartTotal+=itemSubtotal;
		}
		Assert.assertequals(cartTotal, Double.parseDouble(driver.findElement(By.className("total ng-binding")).getText()));
	}
}
