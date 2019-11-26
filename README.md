# Ecommerce-Assignment

# Spring boot App comes with in built Tomcat.  
# This app uses maven build. To compile and build the jar file open comand promt and navigate to application folder. Execute steps in the following order - 
  # 1. Build application using - mvnw clean package. This will compile and create a jar file (demo-0.0.1-SNAPSHOT.jar) in the application folder.
  # 2. Run Application on inbuilt tomcat using - java -jar target\demo-0.0.1-SNAPSHOT.jar
  # 3. To debug the rest service, run the application using - java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n -jar target\demo-0.0.1-SNAPSHOT.jar.
  # 4. Create a debug configuration in eclipse Run--> Debug Configurations --> Remote Java Application --> New --> select your project and set the port as 8000 (as mentioned in step 3) --> Apply
  # 5. Set debug points and start debugging.
  # 6. Use apps like POSTMAN, SoapUI, AdvancedRestCLient to send json request to your Rest web service.
  # 7. I am working on the JQuery AJAX call sample to call this service from jsp. Once done i'll upload. 
  # 8. The idea is we will create rest resources in the web service for each of the scenario like, getSales, getOrders, getEmployees, getUser, getProductDesc, getProducts, getInventory, updateInventory, postCheckout, updateUserAccount, createUser etc.
  
