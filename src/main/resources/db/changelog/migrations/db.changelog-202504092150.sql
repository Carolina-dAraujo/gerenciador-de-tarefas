--liquibase formatted sql
--changeset carol:202504092124
--comment: blocks table create

CREATE TABLE BLOCKS(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    block_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    unblocked_at TIMESTAMP NULL,
    unblocked_reason VARCHAR(255) NOT NULL,
    blocked_reason VARCHAR(255) NOT NULL,
    card_id BIGINT NOTNULL,
    CONSTRAINT cards__blocks_fk FOREIGN KEY (card_id) REFERENCES CARDS(id) ON DELETE CASCADE,
) ENGINE=InnoDB

--rollback DROP TABLE BLOCKS