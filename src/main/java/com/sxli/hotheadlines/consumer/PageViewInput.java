package com.sxli.hotheadlines.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * PV
 */
public interface PageViewInput {

    @Input("stream.pageview")
    SubscribableChannel receive();
}
