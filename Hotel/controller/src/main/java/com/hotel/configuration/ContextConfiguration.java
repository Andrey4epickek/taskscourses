package com.hotel.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan({"com.hotel.dao","com.hotel.service","com.hotel.controller","com.hotel.configuration"})
@EnableTransactionManagement
public class ContextConfiguration {

}
