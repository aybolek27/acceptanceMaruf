Feature: User account information 

#Scenario: verify account info
#	Given the user is on the login page
#	And I login using username "vel.quam@Donec.org" and password "password"
#	When the user clicks on the my personal information button
#	Then the system should display the user's account information
#	|First Name   |Last Name   |Email                    |Password      |
#	|Inigo        |Montoya     |vel.quam@Donec.org       |password      |



Scenario Outline: verify account info 
	Given the user is on the login page 
	And I login using username "<username>" and password "<password>" 
	When the user clicks on the my personal information button 
	Then the system should display the user's account information 
		|First Name   |Last Name   |Email                    |Password      |
		|<firstname>  |<lastname>  |<username>       		 |<password>    |
		
		Examples:
		|firstname		|lastname			|username							|password		|
		|John 			|Smith				|nitoyey@dumoac.net 				|password		|
		|Geraldine		|Whitehead			|lectus@sociisnatoquepenatibus.org 	|password		|
		|Inigo 			|Montoya			|vel.quam@Donec.org				    |password		|
		|Elija			|Baker				|mollis.nec@quama.org				|password		|
		