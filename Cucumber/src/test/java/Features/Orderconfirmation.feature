
Feature: SwagLabs Testing



  Scenario Outline: Order confirmation Using Cucumber
    Given Launch the browser and navigate to the Application
    When Login into Application using <username> and <password> and Validate Title
    And Add the product to cart if product name contains <ProductName>
    And Continue checkout process by clicking on the cart
    And Fill the user details like <FirstName> , <LastName> and <Zipcode>
    And continue the checkout process
    And Confirm the Purchase
    Then Verify the <Confirmation_message>

    Examples: 
      | username  | password | ProductName  | FirstName | LastName | Zipcode | Confirmation_message |
      |  standard_user | secret_sauce | Jacket | Hemanathan | Appu | 560058 | Thank 1you for your order! |
	
