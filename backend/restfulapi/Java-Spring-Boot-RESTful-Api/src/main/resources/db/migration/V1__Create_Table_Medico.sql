DROP TABLE IF EXISTS `MEDICO`;

CREATE TABLE MEDICO (
    `id_medico` bigint NOT NULL AUTO_INCREMENT,
    `id_crm` INT NOT NULL,
    `limite` DECIMAL(10,2),
    `nome` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id_medico`)
);
