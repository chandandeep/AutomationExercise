# AutomationExercise
# Execution Instructions

This framework has been created as automation exercise:


In order to exeute the test cases, 
1. Clone the project in your local drive
2. Download maven and set up the path
3. Download java 1.8 and set up the path

Maven commands:
  1. mvn test -> In order to execute with defaule browser mentioned in configuration properties
  2. mvn test -Dbrowser={#browserName0} -> In order to over-ride the default browser use this command, supported browser names that can be                                             used are "firefox", "chrome", "IE"
  
  Note: 1. If you are using IE >= 10 make sure that "Enable Protected Mode" is same for all zones and zomm level is set to 100%
        2. No need to download the drivers as we are using webdrivermanager for the same
