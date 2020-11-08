# Requirements
- Java 11
- Maven

# Build
- Execute `mvn clean install` in root directory

# Run
## Algorithms
- `java -jar algorithm/target/algorithm-0.0.1-SNAPSHOT.jar n-pairs` for assignment 1
- `java -jar algorithm/target/algorithm-0.0.1-SNAPSHOT.jar polish` for assignment 2
## REST API
- `java -jar rest-service/target/rest-service-0.0.1-SNAPSHOT-spring-boot.jar` to start http server at localhost:8080
- Call endpoint at http://localhost:8080/eval. Use query parameter to **expression** for polish notation expression. 
- Example: `http://localhost:8080/eval?expression=%2B%201%202&expression=%2B%201%203`
