drop table if exists `friend` CASCADE ;
CREATE TABLE friend (
    id BIGINT AUTO_INCREMENT,
    alias VARCHAR(255),
    email VARCHAR(255),
    friend_code VARCHAR(255) NOT NULL,
    name VARCHAR(255),
    phone VARCHAR(255),
    PRIMARY KEY (id)
);
