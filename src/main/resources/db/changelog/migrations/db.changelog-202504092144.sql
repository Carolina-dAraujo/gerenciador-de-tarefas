--liquibase formatted sql
--changeset carol:202504092124
--comment: boards_columns table create

CREATE TABLE BOARD_COLUMNS(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    'order' int NOTNULL,
    kind VARCHAR(7),
    board_column_id BIGINT NOTNULL,
    CONSTRAINT boards_columns__cards_fk FOREIGN KEY (board_column_id) REFERENCES BOARDS_COLUMNS(id) ON DELETE CASCADE,
) ENGINE=InnoDB

--rollback DROP TABLE BOARDS_COLUMNS