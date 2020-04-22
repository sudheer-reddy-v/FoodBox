package com.sudheer.foodbox.configuration;

import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.sudheer.foodbox.entity.MenuDetailsPOJO;
import com.sudheer.foodbox.repo.MenuRepository;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    EntityManagerFactory emf;

    @Autowired
    MenuRepository menuRepository;

    private static final Logger log = LoggerFactory.getLogger(BatchConfiguration.class);

    @Bean
    public FlatFileItemReader<MenuDetailsPOJO> reader() {
        FlatFileItemReader<MenuDetailsPOJO> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("MENU_DETAILS.csv"));
        reader.setLinesToSkip(1);

        DefaultLineMapper<MenuDetailsPOJO> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setNames("vendorID", "menuName","menuDesc","price","menuCategory");

        BeanWrapperFieldSetMapper<MenuDetailsPOJO> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(MenuDetailsPOJO.class);

        lineMapper.setFieldSetMapper(fieldSetMapper);
        lineMapper.setLineTokenizer(tokenizer);
        reader.setLineMapper(lineMapper);

        return reader;
    }


    @Bean
    public JpaItemWriter<MenuDetailsPOJO> writer() {
        JpaItemWriter<MenuDetailsPOJO> writer = new JpaItemWriter<MenuDetailsPOJO>();
        writer.setEntityManagerFactory(emf);
        return writer;
    }

//    @Bean
//    public ItemProcessor<MenuDetailsPOJO, MenuDetailsPOJO> processor() {
//        return (item) -> {
//            item.concatenateName();
//            return item;
//        };
//    }

    @Bean
    public Job importUserJob(JobExecutionListener listener) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<MenuDetailsPOJO, MenuDetailsPOJO>chunk(10)
                .reader(reader())
               // .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public JobExecutionListener listener() {
        return new JobExecutionListener() {


            @Override
            public void beforeJob(JobExecution jobExecution) {
                /**
                 * As of now empty but can add some before job conditions
                 */
            }

            @Override
            public void afterJob(JobExecution jobExecution) {
                if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
                    log.info("!!! JOB FINISHED! Time to verify the results");
                    menuRepository.findAll().
                            forEach(menuDetails -> log.info("Found <" + menuDetails + "> in the database."));
                }
            }
        };
    }
}
