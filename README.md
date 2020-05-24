# multi-threaded-rest

Running Instructions:

It is the Spring Boot Application based on a Rest API to wrap the DNE Online Calculator SOAP service.

To run and test the API, just navigate to the build\libs directory under the repository and run the following command from the command prompt on Windows or the terminal on Linux or MacOS OSs:

java -jar multi-threaded-rest.jar

Now, the rest service is up and running. The port used is 8021, use it while testing. The app url link after running is as follows:

http://localhost:8021/multi-threaded-rest

Here, I specified localhost as a host considering the app is running locally. However, if it is running on a different host, then the hostname or ip address of that host should be specified as the host.

API methods to test are as below:

/add      (to perform addition of two integers)
/subtract (to perform subtraction of two integers)
/multiply (to perform multiplication of two integers)
/divide   (to perform division of two integers)

Complete link:
http://localhost:8021/multi-threaded-rest/{operation}
(where {operation} is one of the API methods mentioned above, i.e., add, subtract, multiply, divide)
http://localhost:8021/multi-threaded-rest/add       (to test addition)
http://localhost:8021/multi-threaded-rest/subtract  (to test subtraction)
http://localhost:8021/multi-threaded-rest/multiply  (to test multiplication)
http://localhost:8021/multi-threaded-rest/divide    (to test division)

Swagger API is also connected to the service. To test using Swagger, browse the link below:
http://localhost:8021/multi-threaded-rest/swagger-ui.html

That's all about it. Enjoy testing.
