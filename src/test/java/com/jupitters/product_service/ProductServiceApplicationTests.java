package com.jupitters.product_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.mongodb.MongoDBContainer;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class ProductServiceApplicationTests {
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");

	@Test
	void shouldCreateProduct() {
	}

}
