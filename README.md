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

**Technologies Used:**
- IDE - Intellij Idea;
- JDK - 1.8 or later;
- Spring Web - 2.7;
- Spring Data Jpa;
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


# **The run of the building jar file**
![jar build](https://github.com/xadidja03/express-bank/assets/116426512/d9220b7d-131e-42a6-820a-9a6b9b3c371b)


Feel free to explore the codebase, contribute, or fork the project if you find it beneficial. If you have any inquiries, suggestions, or collaboration opportunities, please don't hesitate to get in touch. Thank you for exploring the Commerce Platform repository!


  
