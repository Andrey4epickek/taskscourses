package com.library.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan({"com.library.dao","com.library.service","com.library.controller","com.library.configuration"})
@EnableTransactionManagement
public class ContextConfiguration {

}
