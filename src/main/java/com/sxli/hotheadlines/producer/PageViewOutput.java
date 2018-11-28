package com.sxli.hotheadlines.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

/**
 * PV
 */
public interface PageViewOutput {

    @Output("stream.pageview")
    SubscribableChannel sender();
}
