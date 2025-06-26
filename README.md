🌐 wiki_media
🚀 Project Overview
wiki_media is a real-time data streaming project built using the Microservices architecture. The goal is to consume live edit events from Wikimedia, process them through a Kafka pipeline, and store the structured data into a MySQL database for further analysis or exploration.

This project showcases an end-to-end implementation of Apache Kafka, Spring Boot Microservices, and database integration, with hands-on handling of event producers and consumers.

🎯 Project Goal
Read real-time edit stream data from Wikimedia Event Stream

Process the data using Kafka Producer-Consumer Model

Persist the events into a MySQL database

🧱 Project Structure
This project follows a Parent-Child Maven Project structure:

Parent Project: wiki_media (Maven multi-module)

M1 Service (Producer):

Connects to Wikimedia API

Streams the event data

Sends data to Kafka Topic

M2 Service (Consumer):

Subscribes to Kafka Topic

Reads event data

Stores the information into MySQL DB

🔧 Tech Stack & Tools Used
<p align="left"> <img src="https://img.shields.io/badge/Microservices-Architecture-blue?logo=appveyor" /> <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat&logo=spring-boot&logoColor=white" /> <img src="https://img.shields.io/badge/Apache_Kafka-231F20?style=flat&logo=apache-kafka&logoColor=white" /> <img src="https://img.shields.io/badge/MySQL-00758F?style=flat&logo=mysql&logoColor=white" /> <img src="https://img.shields.io/badge/Postman-FF6C37?style=flat&logo=postman&logoColor=white" /> <img src="https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white" /> <img src="https://img.shields.io/badge/Maven-C71A36?style=flat&logo=apache-maven&logoColor=white" /> </p>
✅ Features & Work Done
🔗 Kafka Integration: Configured Kafka Producer to fetch live data from Wikimedia stream and Kafka Consumer to process it.

🛠️ Topic Creation: Created and configured Kafka topic to enable communication between services.

🔄 Microservices Communication: Independent microservices use the same Kafka topic to ensure seamless data flow.

🔧 Property Externalization: Configured services to read configuration dynamically using application.properties.

🗃️ Database Integration: Successfully stored real-time event data into MySQL for persistent storage and retrieval.

📝 Key Learning & Notes
Each microservice must share the same Kafka topic name for smooth communication.

Externalizing Kafka & database configurations makes the services more flexible and maintainable.

Leveraged Postman for endpoint testing and response validation.

