1. Eureka Server (Service Discovery) - 8761
This Service acts as a Service Registry, where every other services will register themselves as a client service(though they are not technically clients but just another services).
So this service will have the list of all other active services. Eventually if a service needs information about other service, then it needs to talk to this service (Eureka Server) to get the information.

We need to start this service first than any other service. By default this service runs on port 8761

Visit (after service started) http://localhost:8761

2. Config Server - 8888
This is Spring Cloud Config Server Service, which maintains the configuration details (if any) what other services need. This service get the configuration details from any git repository. In our case microservices-configuration.git
When other services start, they will automatically connect to this Config Server and get the configurations they need.

We will be starting this service after Eureka Server, so that this will also get registered with Eureka Server.
This runs on port 8888

Visit (after service started) http://localhost:8888

3. Zuul Service (Client API Gateway) - 9000
This acts as a Gateway for all other services. Any requests from client will be first given to the Zuul and the Zuul proxy re-directs it to the actual business.
This runs on port 9000

Visit (after service started) http://localhost:9000

4. Product Catalog Microservice
This is a plain Spring Boot Microservice, which offers the below functionalities internally using H2 Embedded Database.

Note: This will run on random port number which will be determined dynamically, so we have multiple instances running simultaneously with changing any properties.

GET /products -- returns all the products
GET /products/{product_id} -- return the product with the matching id
GET /products/{product_name} -- returns the products with the matching name
GET /products/{product_type} -- returns the products with the matching type
GET /products/{product_id}/users -- returns the users related to the product id (This in turn communicate with the Users Microservice to get the user details)
POST /products/ -- add a new product
DELETE /products/{product_id} -- delete the matching product
PUT /products/{productId} -- update the matching product with new details

5. Users Microservice
This is a plain Spring Boot Microservice, which offers the below functionalities internally using H2 Embedded Database.

Note: This will run on random port number which will be determined dynamically, so we have multiple instances running simultaneously with changing any properties.

GET /users -- returns all the users
GET /users/{userId} -- return the user with the matching id
GET /users/{userName} -- returns the users with the matching name
GET /products/product_id} -- returns the users with the matching product id
POST /users/ -- add a new user
DELETE /users/{user_id} -- delete the matching user
PUT /users/{user_id} -- update the matching user with new details


The below are few sample microservices, just added as examples.
6. Employee Producer Microservice
7. Employee Consumer Microservice
8. Config Client Microservice
9. Eureka Client Microservice