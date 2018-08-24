Feature: Product details 

Scenario: verify products on home page 
	Given the user is on the home page 
	Then the user should be to see "Printed Summer Dress" 
	
Scenario: verify products on home page 
	Given the user is on the home page 
	Then the user should be to see "Printed Chiffon Dress" 
	
Scenario: verify products on home page 
	Given the user is on the home page 
	Then the user should be to see following products 
	
		|Printed Summer Dress		|
		|Printed Chiffon Dress		|
		|Blouse						|
		|Printed Dress				|
		|Faded Short Sleeve T-shirts| 
		
		
 
Scenario: verify all sizes 
	Given the user is on the home page 
	When the user selects "Printed Summer Dress" 
	Then the product should be available in the follwing sizes: 
	
		|S|
		|M|
		|L|
	And correct default count size should be displayed 
	
