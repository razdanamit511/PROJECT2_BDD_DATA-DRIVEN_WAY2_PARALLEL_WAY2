Feature: Forgot Password

Background: User is on Forgot Password page
  Given User is on Forgot Password page

Scenario: Verify that title of Forgot Password page is "Forgot Your Password?"
  When User gets the page title
  Then title of the page is "Forgot Your Password?"

Scenario: Verify that user gets below mentioned labels/Fields on "Forgot Password' webpage Labels,"Forgot Password" button,"Please enter your email address below to receive a password reset link.", "Email" ( with *) and "Reset my Password" button
Then Forgot Password label is displayed
And Please enter your email address below to receive a password reset link. label is displayed
And Email label is displayed
And Email textbox is displayed
And Reset My Password button is displayed

Scenario: Verify that "This is a required field." error message is displayed under all Mandatory fields provded user clicks on "Reset my password" button without entering any value in Mandatory field textbox.
When User clicks on "Reset My Password" button
Then "This is a required field." is displayed under Email textbox

Scenario Outline: Verify that "Please enter a valid email address (Ex: johndoe@domain.com)." error message is displayed under Email textbox provided user enters Invalid email address in email textbox and clicks on Reset My Password button
When User enters credentails from "<ExcelFileName>", "<SheetName>" and "<RowNumber>" in forgot password form
And User clicks on "Reset My Password" button
Then User gets error message as "Please enter a valid email address (Ex: johndoe@domain.com)." 
And User gets the page title
And title of the page is "Forgot Your Password?"
Examples: 
 | ExcelFileName | SheetName | RowNumber |
 | TestData2 | Sheet1 | 1 |
 | TestData2 | Sheet1 | 2 |
  
  
Scenario Outline: Verify that "If there is an account associated with <entered email address> you will receive an email with a link to reset your password." message is displayed provided user enters valid email address in email address textbox followed by click on Rest my account button
When User enters credentails from "<ExcelFileName>", "<SheetName>" and "<RowNumber>" in forgot password form
And User clicks on "Reset My Password" button
Then User gets success message as "If there is an account associated with razdanamit51@gmail.com you will receive an email with a link to reset your password." 
And User gets the page title
And title of the page is "Customer Login"
Examples: 
 | ExcelFileName | SheetName | RowNumber |
 | TestData2 | Sheet2 | 1 |
 | TestData2 | Sheet2 | 2 |

