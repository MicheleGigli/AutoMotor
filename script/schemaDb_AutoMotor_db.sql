--
-- Database: `automotor_db`
--

CREATE DATABASE IF NOT EXISTS `automotor_db`;
USE `automotor_db`;


-- ENTITIES

--
-- Struttura della tabella `auto`
--

CREATE TABLE IF NOT EXISTS `auto` (
	`cc` varchar(40) ,
	`colore` varchar(40) ,
	`proprietario` int ,
	`tipo` varchar(40)  NOT NULL,
	
	-- RELAZIONI

	`_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT 

);





--
-- Struttura della tabella `persona`
--

CREATE TABLE IF NOT EXISTS `persona` (
	`cognome` varchar(40)  NOT NULL,
	`eta` numeric ,
	`mail` varchar(40) ,
	`nome` varchar(40)  NOT NULL,
	
	-- RELAZIONI
	`FK_PEROSNA_AUTO` int(11)  REFERENCES auto(_id),

	`_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT 

);






