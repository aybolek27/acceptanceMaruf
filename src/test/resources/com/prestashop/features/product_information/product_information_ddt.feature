Feature: Verify product information 

#Scenario Outline: Verify item name 
#	Given the user is on the home page 
#	When the user selects "<product>" 
#	Then product page title should contain "<product>" 
#	And product name should be "<product>" 

#	Examples: 
#		|product		|
#		|Printed Summer Dress|
#		|Printed Chiffon Dress|


Scenario Outline: Verify item name 
	Given the user is on the home page 
	When the user selects "<product>" 
	Then product name should be "<product>" 
	And the price should be "<price>" 
	And correct default count should be 1 
	
	Examples: 
		|product		      |price	|
		|Printed Summer Dress |$28.98	|
		|Printed Dress		  |$26.00	|
		|Printed Chiffon Dress|$16.40	|
		
		
		
Scenario Outline: Verify usernames 
	Given the user is on the login page 
	When I login using username "<username>" and password "<password>" 
	Then users full name "<firstname>" "<lastname>" should be displayed 
	
	Examples: 
		|firstname |lastname  	|username		      				|password |    
		|John      |Smith     	|nitoyey@dumoac.net   				|password |  
		|Geraldine |Whitehead   |lectus@sociisnatoquepenatibus.org	|password |	
		
		
Scenario Outline: Product details with map and outline 
	Given the user is on the home page 
	When the user selects "<product>" 
	Then the system should display the product information: 
		|name		|<product>		|		
		|count		|1				|		
		|condition	|New			|		
		|size		|S				|		
		|price		|<price>		|		
		
	Examples: 
		|price		|product				|
		|$28.98		|Printed Summer Dress	|
		|$26.00		|Printed Dress			| 
		|$16.40		|Printed Chiffon Dress	| 
		
 
Scenario Outline: verify page title 
	When the user is on the <page> 
	Then the title and url should be : 
		|Title		|<title>	|
		|Url		|<url>		|
		
	Examples:
	|page			|title				|url																			   |	
	|home page 		|My Store 	    	|http://automationpractice.com/index.php										   |
	|login page		|Login - My Store	|http://automationpractice.com/index.php?controller=authentication&back=my-account |	
		
			
	
		
		
		
		
		
