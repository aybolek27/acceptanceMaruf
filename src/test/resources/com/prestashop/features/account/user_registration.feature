Feature: User should be able to login 


Scenario: User registration 
	Given the user is on the login page 
	And the user enters a random email 
	And the user enters personal information 
		|First Name	|Kunnka		|
		|Last Name	|Admiral	|
		|City		|Anytown	|
		|Address	|123 Main st|
		|Company	|Volvo		|
		 
Scenario: Costum User registration 
	Given the user is on the login page 
	And the user enters a random email 
	And the user enters user information 
		|First Name	 |Last Name	|Company |Address       |City	  |
		|Admiral	 |Kunnka	|Volva   |123 Main st   |Anytown|
		|Adam	 	 |James	    |BMW     |13100 Main st |New York|
		
		
Scenario: user info 
	Then correct user info should be displayed 
	Given the user is on the login page 
		|First Name	 |Last Name	|Company |Address       |City	  |
		|Admiral	 |Kunnka	|Volva   |123 Main st   |Anytown|
		|Adam	 	 |James	    |BMW     |13100 Main st |New York|
		|Adam	 	 |James	    |BMW     |13100 Main st |New York|
	And I login as this user 
		|First Name	 |Last Name	|	
		|Admiral	 |Kunnka	|
	And I order these 
		|name 	|count  |size|
		|dress	|123	| s  |
		|dress  |123	| M  |
		|tshirt |1		| M  |
		
		
		