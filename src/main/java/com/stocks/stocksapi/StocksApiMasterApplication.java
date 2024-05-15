package com.stocks.stocksapi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
@SpringBootApplication
public class StocksApiMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(StocksApiMasterApplication.class, args);
	}

	
	 @Bean
	 public ThreadPoolTaskExecutor taskExecutor() {
	  ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	  executor.setCorePoolSize(2);
	  executor.setMaxPoolSize(2);
	  executor.setQueueCapacity(500);
	  executor.setThreadNamePrefix("stockdata");
	  executor.initialize();
	  return executor;
	 }
}
