# Template Loader Application

Ready to kick-start loader microservice template
* Java: 17
* Spring Boot: 2.7.5

# What do you need to update?
1. Rename `TemplateLoaderApplication` in `dev.hse.template` package to `{{ Subtheme }}LoaderApplication`
2. Under `src/main/java` rename `dev.hse.template` package to your preferred one
3. Change `artifactId` in pom from `template-loader-ms` to your project's `{{ subtheme }}-loader-ms`
4. Change POJO models
   1. `TemplateFiltered` to your filtered model (be careful with LocalDateTime format) `{{ Subtheme }}Filtered`
   2. `TemplateRecord` to your record model (be careful with LocalDateTime format) `{{ Subtheme }}Record`
5. Change serialization classes according to your models
   1. `TemplateFilteredDeserializer` to your `{{ Subtheme }}FilteredDeserializer`
6. Update `docker-compose.yml`
   1. Change application service name `template-loader` to `{{ subtheme }}-loader`
   2. Change container name `template-loader-container` to `{{ subtheme }}-loader-container`
   3. Change environment variables of application
      1. `SPRING_KAFKA_CONSUMER_GROUP-ID` to your consumer group name
      2. `LOADER.SUBTHEME` to your loader's subtheme (example: `cryptocurrency`)
      3. `SPRING_DATASOURCE_URL` to your JDBC-ish url (don't forget about postgres in the bottom of compose, you may or may not turn it off)
      4. `SPRING_DATASOURCE_USERNAME`
      5. `SPRING_DATASOURCE_PASSWORD`
7. Make your repositories in `dev.hse.template.repository` package
8. Make your entities in `dev.hse.template.pojo.entity` package

# How to run

```bash
./mvnw clean
./mvnw package -Dmaven.test.skip
docker compose up
```

* kafka-ui on `localhost:8080`