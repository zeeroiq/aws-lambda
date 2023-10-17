# AWS lambda projects using SAM CLI

## Pre-Requisite
1. AWS CLI
2. AWS SAM CLI
3. JDK

Open up terminal and follow below steps
1. Change directory where project needs to be created or create and change directory to created DIR
    ```bash
    mkdir sam-lambda-handson
    cd sam-lambda-handson
    ```
2. Execute **sam init** command to initialize project, further choose the option for setting up runtime and respective options as needed
    ```bash
    sam init
    ```
3. Once project is created follow README.md for next step or execute below command
```bash
sam build # to build project
sam deploy # to deploy project
# sam local invoke <lambda name> --event <event.json file for testing, could be found within event/>
# example
sam local invoke HelloWorldFunction --event events/event.json
```
local invoke command would require to have docker installed and running cause it will need to download lambda runtime image for running lambda functions locally.
-- -
#### SAMPLE INPUT AND OUTPUT OF THE ABOVE COMMANDS

```
user@Zs-Mac aws-learning % mkdir sam-lambda-handson
user@Zs-Mac aws-learning % cd sam-lambda-handson 
user@Zs-Mac sam-lambda-handson % ls
user@Zs-Mac sam-lambda-handson % sam init

You can preselect a particular runtime or package type when using the `sam init` experience.
Call `sam init --help` to learn more.

Which template source would you like to use?
	1 - AWS Quick Start Templates
	2 - Custom Template Location
Choice: 1

Choose an AWS Quick Start application template
	1 - Hello World Example
	2 - Data processing
	3 - Hello World Example with Powertools for AWS Lambda
	4 - Multi-step workflow
	5 - Scheduled task
	6 - Standalone function
	7 - Serverless API
	8 - Infrastructure event management
	9 - Lambda Response Streaming
	10 - Serverless Connector Hello World Example
	11 - Multi-step workflow with Connectors
	12 - GraphQLApi Hello World Example
	13 - Full Stack
	14 - Lambda EFS example
	15 - Hello World Example With Powertools for AWS Lambda
	16 - DynamoDB Example
	17 - Machine Learning
Template: 1

Use the most popular runtime and package type? (Python and zip) [y/N]: N

Which runtime would you like to use?
	1 - aot.dotnet7 (provided.al2)
	2 - dotnet6
	3 - go1.x
	4 - go (provided.al2)
	5 - graalvm.java11 (provided.al2)
	6 - graalvm.java17 (provided.al2)
	7 - java17
	8 - java11
	9 - java8.al2
	10 - java8
	11 - nodejs18.x
	12 - nodejs16.x
	13 - nodejs14.x
	14 - python3.9
	15 - python3.8
	16 - python3.7
	17 - python3.11
	18 - python3.10
	19 - ruby3.2
	20 - ruby2.7
	21 - rust (provided.al2)
Runtime: 7 
Error: '7 ' is not one of '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21'.
Runtime: 7

What package type would you like to use?
	1 - Zip
	2 - Image
Package type: 1

Which dependency manager would you like to use?
	1 - gradle
	2 - maven
Dependency manager: 1

Would you like to enable X-Ray tracing on the function(s) in your application?  [y/N]: N

Would you like to enable monitoring using CloudWatch Application Insights?
For more info, please view https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/cloudwatch-application-insights.html [y/N]: y
AppInsights monitoring may incur additional cost. View https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/appinsights-what-is.html#appinsights-pricing for more details

Project name [sam-app]: sam-test-lambda

    -----------------------
    Generating application:
    -----------------------
    Name: sam-test-lambda
    Runtime: java17
    Architectures: x86_64
    Dependency Manager: gradle
    Application Template: hello-world
    Output Directory: .
    Configuration file: sam-test-lambda/samconfig.toml
    
    Next steps can be found in the README file at sam-test-lambda/README.md
        

Commands you can use next
=========================
[*] Create pipeline: cd sam-test-lambda && sam pipeline init --bootstrap
[*] Validate SAM template: cd sam-test-lambda && sam validate
[*] Test Function in the Cloud: cd sam-test-lambda && sam sync --stack-name {stack-name} --watch

user@Zs-Mac sam-lambda-handson % ls
sam-test-lambda
user@Zs-Mac sam-lambda-handson % cd sam-test-lambda 
user@Zs-Mac sam-test-lambda % ls
HelloWorldFunction	README.md		events			samconfig.toml		template.yaml
user@Zs-Mac sam-test-lambda % ls -ll
total 32
drwxr-xr-x  7 user  staff   224 Oct 18 01:41 HelloWorldFunction
-rw-r--r--  1 user  staff  8153 Oct 18 01:41 README.md
drwxr-xr-x  3 user  staff    96 Oct 18 01:41 events
-rw-r--r--  1 user  staff   687 Oct 18 01:41 samconfig.toml
-rw-r--r--  1 user  staff  2337 Oct 18 01:41 template.yaml
user@Zs-Mac sam-test-lambda % 
```