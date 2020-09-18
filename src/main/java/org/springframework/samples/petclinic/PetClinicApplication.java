package org.springframework.samples.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;

/**
 * PetClinic Spring Boot Application.
 * 
 * In the following implementation we are using
 * - Java 11 (LTS)
 * - Webflux to expose endpoints over HTTP
 * - Swagger3+ (OpenApi) to provide documentation and test client
 * - DataStax v4 driver with reactive support
 * 
 * The API uses a relational-style objects layer (owner->pet->visit), but the underlying data model
 * follows Cassandra best practices. (denormalization).
 *
 * We did not change the API specification in order to match existing spring-petclinic-angular project.
 * 
 * Specially, it would be more relevant to look for pets based on an owner ID - and not only the pet Id.
 * As such the resources would have look like.
 * - /owners/{ownerId}/pets/
 * - /owners/{ownerId}/pets/
 * - /owners/{ownerId}/pets/{petId}/visits
 * - /owners/{ownerId}/pets/{petId}/visits/{visitId}
 * 
 * We exclude {@link CassandraAutoConfiguration} to setup the Datastax driver
 * the easiest way without spring-data limitations.
 * 
 * @author Cedrick Lunven (@clunven)
 */
@SpringBootApplication(exclude = CassandraAutoConfiguration.class)
public class PetClinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetClinicApplication.class, args);
    }
  
}
