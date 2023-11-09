# Izaberite Java kao osnovnu sliku
FROM openjdk:17-oracle as build

# Postavite direktorij za rad
WORKDIR /workspace/app

# Kopirajte gradle/maven build fileove i izvorni kod
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Izgradite aplikaciju
RUN ./mvnw install -DskipTests

# Izaberite manju sliku za pokretanje
FROM openjdk:17-oracle

VOLUME /tmp

# Kopirajte izgrađeni jar iz build stage-a
COPY --from=build /workspace/app/target/*.jar app.jar

# Izložite port koji vaša aplikacija koristi
EXPOSE 8080

# Pokrenite Spring Boot aplikaciju
ENTRYPOINT ["java","-jar","/app.jar"]
