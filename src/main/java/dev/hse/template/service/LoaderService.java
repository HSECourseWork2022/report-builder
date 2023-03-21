package dev.hse.template.service;

import dev.hse.template.pojo.entity.TemplateRecord;
import dev.hse.template.pojo.TemplateFiltered;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j(topic = "[loader][template][processing]")
@Service
@RequiredArgsConstructor
public class LoaderService {

    public void process(TemplateFiltered templateFiltered) {
        log.info("Processing: {}", templateFiltered);
        TemplateRecord entry = new TemplateRecord();
        entry.setTimestamp(templateFiltered.getTimestamp());
        log.info("Processed: {}", entry);
    }
}
