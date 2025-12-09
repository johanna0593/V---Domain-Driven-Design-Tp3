package com.petfriends.petfriends_tp3.command;

import java.util.UUID;

public abstract class CommandBase {
    private final String requestId;
    private final String causationId;
    private final String aggregateId;

    protected CommandBase(String aggregateId) {
        this.requestId = UUID.randomUUID().toString();
        this.causationId = null;
        this.aggregateId = aggregateId;
    }

    protected CommandBase(String aggregateId, String causationId) {
        this.requestId = UUID.randomUUID().toString();
        this.causationId = causationId;
        this.aggregateId = aggregateId;
    }

    public String getRequestId() { return requestId; }
    public String getCausationId() { return causationId; }
    public String getAggregateId() { return aggregateId; }
}
