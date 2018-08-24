Feature: Sorting options on the search result page 


#Scenario: Sort by
#	Given the user is on the home page
#	And the user clicks on link Dresses
#	When user sorts by "Price: Lowest first"
#	Then following product should be displayed on top
#	|name	|Printed Chiffon Dress	|
#	|price	|$16.40					|




Scenario Outline: Sort by <option> 
	Given the user is on the home page 
	And the user clicks on link Dresses 
	When user sorts by "<option>" 
	Then following product should be displayed on top 
		|name	|<name>			|
		|price	|<price>		|
		
	Examples: 
		|option 					|name						|price		|
		|Price: Lowest first		|Printed Chiffon Dress		|$16.40		|
		|Price: Highest first		|Printed Chiffon Dress		|$16.40		|
		|Product Name: A to Z		|Printed Chiffon Dress		|$16.40		|
		|Product Name: Z to A		|Printed Chiffon Dress		|$16.40		|
		|In stock					|Printed Dress				|$50.99		|
		|Reference: Lowest first	|Printed Dress				|$26.00		|
		|Reference: Highest first	|Printed Dress				|$26.00		|
		
		
@temp 
Scenario: Test sort by dropdown 
	Given the user is on the home page 
	When the user clicks on link Dresses 
	Then the user should be able to sort results 
	
	#mvn verify -Dcucumber.options="--tags @temp"
	
	
	
	
	