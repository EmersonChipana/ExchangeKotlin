FROM eclipse-temurin:11
COPY target/*.jar app.jar

ENV POSTGRES_USER "postgres"
ENV POSTGRES_PASSWORD "postgres"
ENV POSTGRES_URL "jdbc:postgresql://localhost:5432/postgres"
ENV API_KEY ""
ENV URL "https://api.apilayer.com/exchangerates_data/convert"

ENTRYPOINT ["java","-jar","/app.jar"]