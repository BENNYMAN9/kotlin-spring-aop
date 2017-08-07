package com.example.aopdemo

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class AopDemoApplication {

    @Bean
    open fun init(sampleService: SampleService) = CommandLineRunner {
        sampleService.createSample("Clive's sample")
    }
}


fun main(args: Array<String>) {

    SpringApplication.run(AopDemoApplication::class.java, *args)

}
