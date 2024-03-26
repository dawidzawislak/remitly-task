# Remitly Internship 2024 - Coding exercise

## Description

Write a method verifying the input JSON data. Input data format is defined as AWS::IAM::Role Policy. Input JSON might be read from a file.  
  
Method should return logical false if an input JSON Resource field contains a single asterisk and true in any other case.  
  
I chose to write my solution in Java 17 with Maven build system.
  
There are two available functions to test given JSON file. One which reads JSON from file and the other that takes simple String containing JSON.

## Instructions how to run

### Prerequisites
- JDK 17
- Maven

### Clone from github repo:
```
git clone https://github.com/dawidzawislak/remitly-task
```

### Available scripts

To compile, pack into jar and run program use `run.bat` script.
  
`run_test.bat` runs all implemented tests.

`clean.bat` cleans target folder.
  
#### To test methods with other input open project in IDE and edit existing/provide new JSON files or simply put JSON directly with String.