package com.dio.gerenciador.entity;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class BlockEntity {

    private Long id;
    private OffsetDateTime blockedAt;
    private OffsetDateTime blockReason;
    private OffsetDateTime unblockedAt;
    private String unblockReason;
}
