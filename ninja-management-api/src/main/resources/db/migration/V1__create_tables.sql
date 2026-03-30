CREATE TABLE tb_missions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    difficult VARCHAR(255)
);

CREATE TABLE tb_register (
    id INT AUTO_INCREMENT PRIMARY KEY,
    years_old INT,
    name VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    mission_id INT,
    CONSTRAINT fk_ninja_mission
        FOREIGN KEY (mission_id)
        REFERENCES tb_missions(id)
);