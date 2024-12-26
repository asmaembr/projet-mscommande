package com.batch.springbatch.reader;

import com.batch.springbatch.dto.InputData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Slf4j
public class BatchReader  extends MultiResourceItemReader<InputData> {
    Logger log = Logger.getLogger(BatchReader.class.getName());

    public BatchReader(String workDirPath) {
        log.info(workDirPath);
        this.setResources(getInputRessources(workDirPath));
        this.setDelegate(readOneFile());
    }

    private ResourceAwareItemReaderItemStream<? extends InputData> readOneFile() {
    }

    private FileSystemResource[] getInputRessources(String workDirPath) {
        File inputDir = new File(workDirPath);
        File[] files = inputDir.listFiles();
        List<FileSystemResource> inputResources =
    }
}
