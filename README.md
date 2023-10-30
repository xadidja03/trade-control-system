# Commerce Control System
**Welcome to the my application✨**

![structure](https://github.com/xadidja03/trade-control-system/assets/116426512/9e60147c-4f43-4c90-aa38-8adc42841b28)


**Description:**
Welcome to the Commerce Control System README. This document provides an overview of the Commerce control application, its features, installation instructions, and usage guidelines.
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
 
![category controller](https://github.com/xadidja03/trade-control-system/assets/116426512/f0b32e2a-3a2f-42f0-bb1f-dee8b2fa766f)

- POST /commerce/categories/registration
- GET /commerce/categories/showing
- Description: 1st endpoint allows you to create a new category. 2nd endpoint allows you to retrieve a list of all available categories. 

![supplier controller](https://github.com/xadidja03/trade-control-system/assets/116426512/68cae95a-f85e-470d-a20e-fe21a2b90269)


- POST /commerce/suppliers/registration
- GET /commerce/suppliers/showing
- Description: 1st endpoint allows you to create a new suppliers. 2nd endpoint allows you to retrieve a list of all available suppliers.

![product-controller](https://github.com/xadidja03/trade-control-system/assets/116426512/4d12412f-10a6-4845-a940-e0dd1c50175f)


- POST /commerce/products/registration <br>**allows you to create a new products.**
- GET /commerce/products/showing       <br>**allows you to retrieve a list of all available products.**
- PUT/commerce/products/{id}           <br>**allows you to update an existing product by specifying its ID in the URL.**
- DELETE/commerce/products/{id}        <br>**allows you to delete a product by specifying its ID in the URL.**
- GET/commerce/products/{id}           <br>**allows you to retrieve details about a specific product by specifying its ID in the URL.**


# **The run of the building jar file**

![jar build](https://github.com/xadidja03/trade-control-system/assets/116426512/0dd97147-f86e-46ab-ad4e-94b5b612fa21)

Feel free to explore the codebase, contribute, or fork the project if you find it beneficial. If you have any inquiries, suggestions, or collaboration opportunities, please don't hesitate to get in touch. Thank you for exploring the Commerce Platform repository!


  
