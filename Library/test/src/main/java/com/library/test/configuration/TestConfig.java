package com.library.test.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.library.dao","com.library.service"})
public class TestConfig {
}
