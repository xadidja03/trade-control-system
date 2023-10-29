# trade-control-system-security

![structure](https://github.com/xadidja03/express-bank/assets/116426512/36d4a16d-691f-4893-8912-b7ad460b9264)


**Welcome to the my application✨**

**Description:**
Welcome to the Trade Control System with security README. This document provides an overview of the Commerce control application, its features, installation instructions, and usage guidelines.
This project encompasses a Spring Boot application designed to manage product, category, and supplier-related operations in a PostgreSQL database. 
The application provides a comprehensive set of features to facilitate effective management of various aspects of your business:

**Key Features:**
- Product: Empowers users to control every aspect of their products. Easily list, update, and delete products, aiding businesses in organizing inventory.
- Category: Users can add, modify, and delete product categories. Each product can belong to one or multiple categories, simplifying filtering and searching.
- Supplier: Organize supplier relationships. Add, update, or remove suppliers as needed. Associate products with suppliers for quick access to supplier details.
- Data Integrity and Validation: Ensures data integrity with custom validation rules. Prevents errors, like negative prices, and enforces category-specific rules, enhancing data quality.
- Database Relationship Management: Effectively manages relationships between database objects. Easily specify product-category or product-supplier associations for improved data organization.

**User Authentication and Security:**
- User Sign-up: Users can register and create an account using the `/register` endpoint. After registration, an email confirmation link is sent to the user's email address.
- Email Confirmation: Users must click the confirmation link in the email to verify their email address and activate their account.
- User Login: Registered users can log in using the `/login` endpoint, which provides them with a JWT token for authentication.
- JWT Token: JSON Web Tokens are used for secure authentication and authorization. The token is provided upon login and must be included in the headers of authenticated requests.
- Token Refresh: To maintain security and session longevity, users can use the `/refresh` endpoint to get a new access token without re-entering credentials.

**Technologies Used:**
- IDE - Intellij Idea;
- JDK - 1.8 or later;
- Spring Web - 2.7;
- Spring Data Jpa;
- Spring Security
- Jwt
- Java Mail Sender
- PostgreSql
- Lombok
- Validation
- JUnit5
- Swagger

 **Endpoints and description**
![category controller](https://github.com/xadidja03/express-bank/assets/116426512/8352fcea-ab4b-4845-9cb6-5b289aad8288)

- POST /commerce/categories/registration
- GET /commerce/categories/showing
- Description: 1st endpoint allows you to create a new category. 2nd endpoint allows you to retrieve a list of all available categories. 

![supplier controller](https://github.com/xadidja03/express-bank/assets/116426512/155e780f-0bbe-440a-8cd2-01443e85f400)

- POST /commerce/suppliers/registration
- GET /commerce/suppliers/showing
- Description: 1st endpoint allows you to create a new suppliers. 2nd endpoint allows you to retrieve a list of all available suppliers.

![product-controller](https://github.com/xadidja03/express-bank/assets/116426512/546214c8-1698-49be-b3b2-137cc2e61e96)

- POST /commerce/products/registration <br>**allows you to create a new products.**
- GET /commerce/products/showing       <br>**allows you to retrieve a list of all available products.**
- PUT/commerce/products/{id}           <br>**allows you to update an existing product by specifying its ID in the URL.**
- DELETE/commerce/products/{id}        <br>**allows you to delete a product by specifying its ID in the URL.**
- GET/commerce/products/{id}           <br>**allows you to retrieve details about a specific product by specifying its ID in the URL.**

### Register user
POST http://localhost:8088/commerce/user/registration
![register](https://github.com/xadidja03/trade-control-system-security/assets/116426512/0209dc65-b601-4317-90b7-1920ecea0534)

### Login user
POST http://localhost:8088/commerce/user/login
![login](https://github.com/xadidja03/trade-control-system-security/assets/116426512/eb1a43eb-43cb-4cfc-9d6c-f643e5409b4c)
### Confirm account with mail
![mail](https://github.com/xadidja03/trade-control-system-security/assets/116426512/74c8206d-bc7b-4ddc-b323-1a18dd4e1a9f)

![mailconfirm](https://github.com/xadidja03/trade-control-system-security/assets/116426512/6aa28fec-c381-46c0-8b8d-968dc458102c)

### Refresh token
GET http://localhost:8088/commerce/user/refreshing-token
![refrestoken](https://github.com/xadidja03/trade-control-system-security/assets/116426512/7a2ef10c-6492-4180-adaf-ee175272956e)

### Database postgres

![datagrip](https://github.com/xadidja03/trade-control-system-security/assets/116426512/096f8337-2277-464f-be4e-5e6c15836f7a)
![db](https://github.com/xadidja03/trade-control-system-security/assets/116426512/543a6541-b8b6-4d8b-bda7-a15f635fc0da)

# **The run of the building jar file**
![jar build](https://github.com/xadidja03/express-bank/assets/116426512/d9220b7d-131e-42a6-820a-9a6b9b3c371b)


Feel free to explore the codebase, contribute, or fork the project if you find it beneficial. If you have any inquiries, suggestions, or collaboration opportunities, please don't hesitate to get in touch. Thank you for exploring the Commerce Platform repository!


  
