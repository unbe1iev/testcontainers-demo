package com.unbe1iev.testcontainersdemo;

import com.github.dockerjava.api.command.CreateContainerCmd;
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.containers.wait.strategy.WaitAllStrategy;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.time.Duration;
import java.util.function.Consumer;
//@Testcontainers
public class TestSetup {

//    protected static Network network = Network.newNetwork();
//
//    // docker run -e MYSQL_USERNAME=... -e MYSQL_PASSWORD=... mysql:latest
//    @Container
    protected static MySQLContainer mySQLContainer = (MySQLContainer) new MySQLContainer(DockerImageName.parse("mysql:latest"))

//            .setDockerImageName("my-testcontainer-image")
//
//            .withDatabaseName("database")
//            .withUsername("root")
//            .withPassword("password")
//
            .withLabel("label-key", "label-value")
//            .withNetwork(network)
//            .withEnv("env-key", "env-value")
//            .waitingFor(Wait.forLogMessage("Awaiting connection.*", 1))
//            .withStartupTimeout(Duration.ofSeconds(120))
//            .withAccessToHost(true)
//          .withExposedPorts(8081) // it tells testcontainers please poll the port until it's available (mechanism)
            .withReuse(true); // just reuse the existing one container ex. per class (it still contains data) when we stop containers after class test, it doesn't restart anymore
//            // we can avoid container restart time... the container is lying around
//            // in your ~ directory you have a .testcontainers.properties - there is a reuse property... you need to set it up (put the line there: testcontainers.reuse.enable=true)
//            // but we have to get rid of @Testcontainers & @Container annotations to avoid shutting down a container anyway... (removing JUNIT support - just use containers manually)

    @DynamicPropertySource
    private static void overrideProps(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", mySQLContainer::getUsername);
        registry.add("spring.datasource.password", mySQLContainer::getPassword);
    }

// For MongoDB dataSet:
//    @DynamicPropertySource
//    static void setProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
//    }

//    @Container
//	private static RabbitMQContainer rabbitMQContainer = new RabbitMQContainer("rabbitmq:latest")
//		.withBinding()
//		.withExchange()
//		.withSSL()
//			;

//	@Container
//	private static GenericContainer genericContainer = new GenericContainer<>("image-restservice:mytag")
//    public static GenericContainer mongoGenericContainer = new GenericContainer(DockerImageName.parse("mongo:latest"))
//            .withEnv("API_TOKEN", "foo")
//            .withNetwork("yey")
// 		.withNetworkAlias()
//		.withNetworkMode()
//		.withExposedPorts(9000)
//		.withLogConsumer(new Slf4jLogConsumer(LOGGER))
//			;

//    protected static GenericContainer<?> helloWorld1 = new GenericContainer<>("hello-world:latest")
//            .withNetwork(network)
//            .withNetworkAliases("testHelloWorld")
//            .withCommand(
//                    "/bin/sh", "-c", "while true ; do printf 'HTTP/1.1 200 OK\\n\\nyay' | nc -l -p 8080; done");
//
//    protected static GenericContainer<?> helloWorld2 = new GenericContainer<>("hello-world:latest")
//            .withNetwork(network)
//            .withNetworkAliases("testHelloWorld")
//            .withCommand("top");

//    @Override
//    public void afterAll(ExtensionContext extensionContext) throws Exception {
//
//    }
//
//    @Override
//    public void beforeAll(ExtensionContext extensionContext) throws Exception {
//        // we can start containers by default callback implementations
//    }

    @BeforeAll
    public static void setup() {
//        Testcontainers.exposeHostPorts(9000);
        mySQLContainer.start();
//        helloWorld1.start();
//        helloWorld2.start();
    }
}
