# trade-control-system-security

![structure](https://github.com/xadidja03/express-bank/assets/116426512/36d4a16d-691f-4893-8912-b7ad460b9264)


**Welcome to the my application✨**

**Description:**
Welcome to the Trade Control System with security README. This document provides an overview of the Commerce control application, its features, installation instructions, and usage guidelines.
This project encompasses a Spring Boot application with jwt security designed to manage product, category, and supplier-related operations in a PostgreSQL database. 

**Key Features:**
- Product: Empowers users to control every aspect of their products. Easily list, update, and delete products, aiding businesses in organizing inventory.
- Category: Users can add, modify, and delete product categories. Each product can belong to one or multiple categories, simplifying filtering and searching.
- Supplier: Organize supplier relationships. Add, update, or remove suppliers as needed. Associate products with suppliers for quick access to supplier details.
- Data Integrity and Validation: Ensures data integrity with custom validation rules. Prevents errors, like negative prices, and enforces category-specific rules, enhancing data quality.

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
- Postman

 **Endpoints and description**
- POST /commerce/categories/registration
  ![registercategory](https://github.com/xadidja03/trade-control-system-security/assets/116426512/a8ed0cda-308f-4f4b-86c7-b78bb3a478f8)

- GET /commerce/categories/showing
  ![showcategory](https://github.com/xadidja03/trade-control-system-security/assets/116426512/fb0a1dd0-29f9-40c8-92a0-78e5ef5ae533)

- POST /commerce/suppliers/registration
  ![registersupplier](https://github.com/xadidja03/trade-control-system-security/assets/116426512/19189287-5ac2-498c-bd2b-ba13fd0ddfb1)

- GET /commerce/suppliers/showing
  ![showsupplier](https://github.com/xadidja03/trade-control-system-security/assets/116426512/30fb6b30-7949-40b5-a35f-c31276386714)


- POST /commerce/products/registration
  ![productregister](https://github.com/xadidja03/trade-control-system-security/assets/116426512/e495d38e-cc74-4b7e-bd2c-ef4af5c0c40b)
  ![productregister2](https://github.com/xadidja03/trade-control-system-security/assets/116426512/795eb969-7576-4266-9155-f20a85dcad9d)


- PUT/commerce/products/{id}
  ![productsupdate](https://github.com/xadidja03/trade-control-system-security/assets/116426512/68d68e20-6b68-4d9a-9e30-0a11365ed625)

- DELETE/commerce/products/{id}
  ![delete](https://github.com/xadidja03/trade-control-system-security/assets/116426512/a18be56c-81b9-4dca-b857-d790790f86fd)

- GET/commerce/products/{id}
  ![findbyid](https://github.com/xadidja03/trade-control-system-security/assets/116426512/e6c9e7bf-aa3b-48e9-9f0b-e630d2d18f6b)
  
- GET /commerce/products/showing
![image](https://github.com/xadidja03/trade-control-system-security/assets/116426512/be6bccae-c53d-4cdf-8a39-402a3f503c17)

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



# **The run of the building jar file**

![jar build](https://github.com/xadidja03/trade-control-system-security/assets/116426512/f92ff90f-57e5-41cd-a3f8-6e00cfcaf3cb)


Feel free to explore the codebase, contribute, or fork the project if you find it beneficial. If you have any inquiries, suggestions, or collaboration opportunities, please don't hesitate to get in touch. Thank you for exploring the Commerce Platform repository!


  
