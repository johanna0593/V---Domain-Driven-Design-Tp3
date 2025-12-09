package com.petfriends.petfriends_tp3.event;

import java.time.Instant;
import java.util.UUID;

public abstract class EventBase {
    private final String eventId;
    private final String aggregateId;
    private final Instant occurredOn;
    private final int payloadVersion;

    protected EventBase(String aggregateId, int payloadVersion) {
        this.eventId = UUID.randomUUID().toString();
        this.aggregateId = aggregateId;
        this.occurredOn = Instant.now();
        this.payloadVersion = payloadVersion;
    }

    public String getEventId() { return eventId; }
    public String getAggregateId() { return aggregateId; }
    public Instant getOccurredOn() { return occurredOn; }
    public int getPayloadVersion() { return payloadVersion; }
}
