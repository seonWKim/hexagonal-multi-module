package org.example.adapter.port.out;

import org.example.adapter.order.CompletedOrderProcessor;
import org.example.adapter.order.CompletedOrderReader;
import org.example.adapter.order.CompletedOrderWriter;
import org.example.domain.order.CompletedOrderHistory;
import org.example.domain.order.Order;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class CompletedOrderMigrationJob {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager platformTransactionManager;

    private final CompletedOrderReader reader;
    private final CompletedOrderProcessor processor;
    private final CompletedOrderWriter writer;

    @Bean("completedHistoryMigrationJob")
    public Job job() {
        return new JobBuilder("completedHistoryMigrationJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step())
                .build();
    }

    @Bean
    @JobScope
    public Step step() {
        return new StepBuilder("completedHistoryMigrationStep", jobRepository)
                .<Order, CompletedOrderHistory>chunk(10, platformTransactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}
