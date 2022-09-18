package com.unbe1iev.testcontainersdemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.output.OutputFrame;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class TestcontainersDemoApplicationTests extends TestSetup /* @ExtendWith() is better */ {

	@Autowired
	private CustomerDao customerDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(TestcontainersDemoApplicationTests.class);

	@Test
	void when_using_a_clean_db_this_should_be_empty() /*throws IOException, InterruptedException*/ {
////		// get a file from your class path inside you docker container:
//		mySQLContainer.withClasspathResourceMapping("application.properties", "./application.properties", BindMode.READ_ONLY);
////
////		// docker container can only read from the file: (only example)
//		mySQLContainer.addFileSystemBind("C:\\Users\\oskja\\OneDrive\\Desktop\\testcontainers-demo\\aplication.properties", "/tmp/blablabla.txt", BindMode.READ_ONLY);
////
////		// to run commands with parameters:
//		mySQLContainer.execInContainer("ls", "-la");
////
////		// to examine what goes printed to stand it out:
//		mySQLContainer.getLogs(OutputFrame.OutputType.STDOUT); // get it to specific output
////		// to consume a log and print it to your own like however you have slf4j configured you can input like an slf4j lock consumer (redirecting):
//////		container.withLogConsumer()
////
////		// if you want to know the generated port of a container:
//////		Integer onYourMachine = container.getMappedPort(3306); // 3306 which is MySQL def. internally available on the container
//		String address = mySQLContainer.getHost() + ":" + mySQLContainer.getMappedPort(3306);
//		LOGGER.info("Address: {}", address);
////		// external port is bound to a random one
////		// it is also available in JdbcUrl
////
//		List<String> envVariables = mySQLContainer.getEnv();
//		envVariables.add("affinity:container==" + mySQLContainer);
//		mySQLContainer.setEnv(envVariables);

		List<Customer> customers = customerDao.findAll();
		assertThat(customers).hasSize(2);
	}

//	@Test
//	void testsmth() throws IOException, InterruptedException {
//		String response = helloWorld2.execInContainer("wget", "-O", "-", "http://helloWorld1:8080").getStdout();
//		assertThat(response).as("received response").isEqualTo("yay");
//	}
}
