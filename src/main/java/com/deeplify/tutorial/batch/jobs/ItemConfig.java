package com.deeplify.tutorial.batch.jobs;

import com.deeplify.tutorial.batch.tasklets.ItemTasklet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ItemConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job itemJob() {
        return jobBuilderFactory.get("itemJob")
                .start(itemJobStep())  // Step 설정
                .build();
    }

    @Bean
    public Step itemJobStep() {
        return stepBuilderFactory.get("itemJobStep")
                .tasklet(new ItemTasklet()) // Tasklet 설정
                .build();
    }
}
