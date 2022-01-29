package com.acadefella.acadefellabackend.integration;

import com.acadefella.acadefellabackend.config.EmbeddedMongoDBTestSetup;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@Tag("integrationTest")
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class StudentIntegrationTest extends EmbeddedMongoDBTestSetup {}
