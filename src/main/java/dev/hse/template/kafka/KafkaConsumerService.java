package dev.hse.template.kafka;

import dev.hse.template.pojo.TemplateFiltered;
import dev.hse.template.service.LoaderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j(topic = "[loader][template][kafka-consumer]")
@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final LoaderService loaderService;

    @KafkaListener(topicPattern = ".+\\.${loader.subtheme}\\.filters\\.outcome")
    public void consumeTemplateTopic(TemplateFiltered templateFiltered) {
        log.info("Got from kafka: {} ", templateFiltered);
        loaderService.process(templateFiltered);
    }
}
