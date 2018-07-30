# CSV file_to_db_convertor
 I have used Spring, Spring boot, JPA, and PostgreSql in this project. This is a simple convertor which get the path of the CSV file, convert them to an Entity, insert them in the PostgreSql, and finally select a record from the Database where its identifier is “10040000”.
 You can run it from command prompt via “java -jar” command, it asks you the path of the CSV file and continues.
 For running this application you should be sure your database connection data is correctly inputted in the application.properties file like below:
spring.datasource.url= jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=1234
spring.jpa.hibernate.ddl-auto=create-drop

 According to above configuration, hibernate.ddl-auto is create-drop which means all data will be lost before you start the application. 
