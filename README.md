# JavaSchool2020
Project for the Java School 2020

Command List for running it: 

1.  Under the project folder execute the following command "./mvnw package"

2.  "docker build -t shipping-app ."
    This command creates an image for the project. 
 
3. "docker run -p 8080:8080 shipping-app" 
    This command run a container for the project using the image created on step 1. 

