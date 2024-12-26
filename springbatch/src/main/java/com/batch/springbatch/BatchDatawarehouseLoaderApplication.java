package com.batch.springbatch;

import com.batch.springbatch.batchutils.BatchJobListener;
import com.batch.springbatch.batchutils.BatchStepListener;
import com.batch.springbatch.batchutils.BatchStepSkipper;
import com.batch.springbatch.dto.ConvertedInputData;
import com.batch.springbatch.dto.InputData;
import com.batch.springbatch.processor.BatchProcessor;
import com.batch.springbatch.reader.BatchReader;
import com.batch.springbatch.writer.BatchWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


@SpringBootApplication
@EnableBatchProcessing
@EnableScheduling
public class BatchDatawarehouseLoaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchDatawarehouseLoaderApplication.class, args);
    }

    @Value("${path.to.the.work.dir}")
    private String workDirPath;

    @Autowired
    private DataSource dataSource;
    @Autowired
    PlatformTransactionManager transactionManager;

    @Bean
    public JobRepository jobRepositoryW() throws Exception {
        JobRepositoryFactoryBean jobrepoFactory = new JobRepositoryFactoryBean();
        jobrepoFactory.setDataSource(dataSource);
        jobrepoFactory.setTransactionManager(transactionManager);
        return jobrepoFactory.getObject();
    }

    @Autowired
    JobBuilderFactory jobBuilderFactory;
    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Bean
    public BatchReader batchReader() {
        return new BatchReader(workDirPath);
    }

    @Bean
    public BatchProcessor batchProcessor() {
        return new BatchProcessor();
    }

    @Bean
    public BatchWriter batchWriter() {
        return new BatchWriter();
    }

    @Bean
    public BatchJobListener batchJobListener() {
        return new BatchJobListener();
    }

    @Bean
    public BatchStepListener batchStepListener() {
        return new BatchStepListener();
    }

    @Bean
    public BatchStepSkipper batchStepSkipper() {
        return new BatchStepSkipper();
    }

    @Bean
    public Step batchStep() {
        return stepBuilderFactory.get("stepDatawarehouseLoader").transactionManager(
                        transactionManager
                ).<InputData, ConvertedInputData>chunk(1)
                .reader(batchReader())
                .processor(batchProcessor())
                .writer(batchWriter())
                .faultTolerant().skipPolicy(batchStepSkipper())
                .listener(batchStepListener()).build();
    }

    @Bean
    @Scheduled(cron = "*/2 * * * * * ")
    public Job jobStep() throws Exception {
        return jobBuilderFactory
                .get("stepDatawarehouseLoader")
                .repository(jobRepositoryW())
                .incrementer(new RunIdIncrementer())
                .listener(batchJobListener())
                .flow(batchStep())
                .end()
                .build();
    }
}
