package com.example.aopdemo

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class SampleServiceAspect {

    private val LOGGER = LoggerFactory.getLogger(SampleServiceAspect::class.java)

    @Before("execution(* com.example.aopdemo.SampleService.createSample (java.lang.String)) && args(sampleName)")
    @Throws(IllegalArgumentException::class)
    fun beforeSampleCreation(sampleName: String) {

        if (sampleName.isBlank()) {
            throw IllegalArgumentException("Name must not be blank!")
        }
        LOGGER.info("Request issued for a sample with name $sampleName")
    }

//    @Around("execution(* com.example.aopdemo.SampleService.createSample (java.lang.String)) && args(sampleName)")
    @Throws(Throwable::class)
    fun aroundSampleCreation(proceedingJoinPoint: ProceedingJoinPoint, sampleName: String): Any {

        val newSampleName = sampleName + "wel wel !!!!!"
        LOGGER.info("Setting our sampleName from $sampleName to $newSampleName")

        val sample = proceedingJoinPoint.proceed(arrayOf(sampleName)) as Sample
        sample.name = sample.name.toUpperCase()

        LOGGER.info("Our sample name object is now $sample")
        return sample
    }
}