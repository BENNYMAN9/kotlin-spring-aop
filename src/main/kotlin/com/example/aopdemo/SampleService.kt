package com.example.aopdemo

import org.springframework.stereotype.Service

@Service
class SampleService {

    fun createSample(sampleName: String): Sample {

        return Sample(sampleName)

    }

    fun sample() {

    }

    fun somethingElse() {

    }

}