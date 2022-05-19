# SPRING BOOT - CUSTOM FILE VALIDATOR

## Description
File validator in java/spring boot both type and size

## Prerequisites
- Java JDK 13
- Maven

## Installation
Step for installation:
```sh
# Clone this project from gitlab
git clone https://github.com/ThDarkArmy/DarkFileValidator.git

# Clears the target directory and builds the project
mvn clean install
```

## Project Structure
```
.                                           # main directory project 
+-- java
|   +-- validator                           # All the validation codes in this directory
|       +-- annotation                      # Package containing validator interfaces
|           +-- @DarkFileSize               # File size validator interface
|           +-- @DarkFileType               # File type validator interface
|       +-- constrainedvalidator            # Package containing contraint validator implementation classes
|           +-- DarkFileSizeValidator       # Constraint implementation class for DarkFileSize
|           +-- DarkFileTypeValidator       # Constraint implementation class for DarkFileType
|   +-- usecase                             # Implemented example or demo of the DarkFileValidator through Rest API with RestControllerAdvice
|   +-- DarkValidatorApplication.java       # App starting point or main class
+-- resources 
|   +-- application.properties              # Configurations files               
```

## Run Project
You can start this project using
```sh
mvn clean spring-boot:run
```

## Example How to use DarkFilType and DarkFileSize annotations

### @DarkFileType

```sh

@NotNull
@DarkFileType(fileType = {"pdf", "application/vnd.openxmlformats-officedocument.wordprocessingml.document"}, message="File must be a valid pdf or word file")
private MultipartFile resumeFile;
```

Response if not valid pdf or word file
```
{
    "statusCode": 400,
    "errorMessage": "Binding Error",
    "errorBody": [
        {
            "field": "DarkFileType.resumeFile",
            "message": "File must be a valid pdf or word file"
        }
    ]
}
```

### @DarkFileType

```sh

@NotNull
@DarkFileSize(min = "10KB", max = "20MB" , message = "Video size must be between 10KB and 20MB")
private MultipartFile videoFile;
```
Response if the file size is not between 10KB and 20MB
```
{
    "statusCode": 400,
    "errorMessage": "Binding Error",
    "errorBody": [
        {
            "field": "DarkFileSize.videoFile",
            "message": "Video size must be between 10KB and 20MB"
        }
    ]
}
```


### @DarkFileType and @DarkFileSize both at the same time

```sh

@NotNull
@DarkFileType(fileType = {"video/x-matroska","video/webm", "video/mp4"}, message="File must be a valid video in mp4 or mkv or webm format")
@DarkFileSize(min = "10MB", max = "20MB" , message = "Video size must be between 10MB and 20MB")
private MultipartFile videoFile;
```
Response if the file size is not between 10MB and 20MB and file type is not valid video
```
{
    "statusCode": 400,
    "errorMessage": "Binding Error",
    "errorBody": [
        {
            "field": "DarkFileType.videoFile",
            "message": "File must be a valid video in mp4 or mkv or webm format"
        },
        {
            "field": "DarkFileSize.videoFile",
            "message": "Video size must be between 10MB and 20MB"
        }
    ]
}
```



## Author
Created and maintained by thdarkarmy ([@thdarkarmy](https://www.linkedin.com/in/prashant-raj-576719152/)).