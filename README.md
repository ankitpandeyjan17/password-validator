# password-validator

This a Java Application for the password validation for below mentioned Feature :

We like to build code for purposes of password verification. Verification will fail if any one
of the rules mentioned does not pass.
1. Implement the following rules. Each one of these will throw an exception with a
different message of your choice
 - password should be larger than 8 chars
 - password should not be null
 - password should have one uppercase letter at least
 - password should have one lowercase letter at least
 - password should have one number at least
2. Add feature: Password is OK if at least three of the previous conditions is true
3. Add feature: password is never OK if item 1.d is not true.


- Language : JAVA 8 or Java 11
- JUNIT : Junit 5
- Build  : Maven

- To run the application, Run main Method present in PasswordValidatorClient.class
User need to enter the option mentioned as below




=========================================================
 *** Welcome To Password Validator App *** 
=========================================================


Please choose the below Options
1. Validate a password
2. Add validation feature
3. Exit


- In the above step if you will enter 1, then you need to type password as mentioned below

1
Please enter the password to validate:	

- Once User enter the test password it will run the validation logic and User can see different messages based on failure and success

User can also choose the option to add below mentioned feature in this app, apart from base feature mentioned above list at point 1 user can choose these feature also
 - Add feature: Password is OK if at least three of the previous conditions is true
- Add feature: password is never OK if item 1.d is not true.
- On choosing 2 you can add validation feature


2. Add validation feature
3. Exit

- Once user will enter 2 he/she will able to see the feature options


****Select below available Feature
1. Minimum 3 Validations to be applied
2. Lowercase character Mandatory

- User can choose or add both the feature
- If User enter 1 then minimum validation needs to give validation result as successfully validated can will get activated and in our case its 3 i.e if 3 Validation passed then user can see validation successfull message as mentioned below

lease enter the password to validate:	User1234
*** Your Password Verified Successfully


-If user selected as 2 thenlower case character must be there in the password otherwise validation will be failed






