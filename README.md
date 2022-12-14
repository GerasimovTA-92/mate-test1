# mate-test1

## **Contents**
1. [Task](#Task)
2. [Features](#Features)
3. [Project structure](#Project-structure)
4. [Technologies](#Technologies)
5. [How to run project](#How-to-run-project)
____


## **Task**

 Create REST API to manage DB entities - Book, Author (via Hibernate)

[:arrow_up:Contents](#Contents)
____

## **Features**

* create/update/delete book
* create/update/delete author
* show all books by author name
* show most selling book
* show most published book
* show list of most selling book by author name
* show list of most published book by author name
* show list of most successful book by author name
* show most successful author

[:arrow_up:Contents](#Contents)
____

## **Project structure**

### Project built on 3-tier architecture:
1. Data access layer (DAO).
2. Application layer (service).
3. Presentation layer (controllers).

Entities relation: Many to One (Book - Author)

[:arrow_up:Contents](#Contents)
____

## **Technologies**
* Java 8
* Spring Boot
* Spring Data
* Apache Maven
* H2 DB

[:arrow_up:Contents](#Contents)
____

## **How to run project**

### Tools to run project:
* IntelliJ Idea Ultimate

### How to run
1. Clone this project
2. To test the functionality you can use the collection in [Postman](src/main/resources/mate.postman_collection.json)

[:arrow_up:Contents](#Contents)
____