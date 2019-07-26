package com.bigfishgames.gaeskeleton.metrics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MetricsReporter {
    private static final Logger log = LoggerFactory.getLogger(MetricsReporter.class);
    public MetricsReporter() {
    }

    @Scheduled(fixedDelayString = "${metricsReporter.fixedDelay}")
    public void logMetrics() {
        Runtime runtime = Runtime.getRuntime();
        log.info(String.format("{\"jvmMemoryUsed\":%d}", runtime.totalMemory() - runtime.freeMemory()));
    }
}
