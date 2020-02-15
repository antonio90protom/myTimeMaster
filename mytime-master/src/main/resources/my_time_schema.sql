-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
-- Tabella per la gestione dei timesheets
-- -- --
CREATE TABLE IF NOT EXISTS mp_time (
	id INT AUTO_INCREMENT PRIMARY KEY,
	owner_user_name VARCHAR(256) NOT NULL COMMENT 'User name del dipendente proprietario del timesheet',
	approver_user_name VARCHAR(256) COMMENT 'User name dell''approvatore del timesheet',
	year YEAR(4) NOT NULL COMMENT 'Anno di riferimento del timesheet',
	month INT NOT NULL COMMENT 'Mese di riferimento del timesheet',
	period INT COMMENT 'Periodo di riferimento per la gestione quindicinale, 0 e 1 per determinarle',
	ins_user_name VARCHAR(256) NOT NULL COMMENT 'User name dell''utente che ha inserito il record',
	ins_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Timestamp in cui è stato inserito il record',
	upd_user_name VARCHAR(256) COMMENT 'User name dell''utente che ha effettuato l''ultima modifica al record',
	upd_date DATETIME COMMENT 'Timestamp in cui è stata effettuata l''ultima modifica al record'
);
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
-- Tabella di dominio con gli stati del timesheet
-- -- --
CREATE TABLE IF NOT EXISTS mp_status (
	id INT AUTO_INCREMENT PRIMARY KEY,
	description VARCHAR(100) NOT NULL COMMENT 'Nome dello stato',
	active boolean NOT NULL DEFAULT true COMMENT 'Determina se lo stato è attivo o meno',
	state_pos INT COMMENT 'Campo per la gestione dell''ordine dei passaggi di stato'
);
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
-- Tabella per la gestione degli stati del timesheet
-- -- --
CREATE TABLE IF NOT EXISTS mp_time_status (
	id INT AUTO_INCREMENT PRIMARY KEY,
	id_mp_time INT NOT NULL COMMENT 'Id del timesheet di riferimento',
	id_mp_status INT NOT NULL COMMENT 'Id dello stato di riferimento',
	date_start DATETIME NOT NULL COMMENT 'Data e ora di inizio',
	date_end DATETIME COMMENT 'Data e ora di fine',
	note VARCHAR(1000) COMMENT 'Eventuali note inserite dall''utente approvatore',
	ins_user_name VARCHAR(256) NOT NULL COMMENT 'User name dell''utente che ha inserito il record',
	ins_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Timestamp in cui è stato inserito il record',
	upd_user_name VARCHAR(256) COMMENT 'User name dell''utente che ha effettuato l''ultima modifica al record',
	upd_date DATETIME COMMENT 'Timestamp in cui è stata effettuata l''ultima modifica al record',
	FOREIGN KEY(id_mp_time) REFERENCES mp_time(id),
	FOREIGN KEY(id_mp_status) REFERENCES mp_status(id)
);
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
-- Tabella per la gestione dei dettagli del timesheet
-- -- --
CREATE TABLE IF NOT EXISTS mp_time_detail (
	id INT AUTO_INCREMENT PRIMARY KEY,
	id_mp_time INT NOT NULL COMMENT 'Id del timesheet di riferimento',
	job_code VARCHAR(100) NOT NULL COMMENT 'Codice della commessa associata',
	task_code VARCHAR(100) COMMENT 'Codice del task di riferimento',
	day DATE NOT NULL COMMENT 'Giorno di riferimento',
	start_time TIME NOT NULL COMMENT 'Orario di inizio',
	end_time TIME NOT NULL COMMENT 'Orario di fine',
	location VARCHAR(100) COMMENT 'Sede in cui si è svolta l''attività',
	detail_group INT COMMENT 'Campo di raggruppamento, servirà a gestire tuple correlate ad esempio lo split di un evento inserito per più giorni',
	ins_user_name VARCHAR(256) NOT NULL COMMENT 'User name dell''utente che ha inserito il record',
	ins_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Timestamp in cui è stato inserito il record',
	upd_user_name VARCHAR(256) COMMENT 'User name dell''utente che ha effettuato l''ultima modifica al record',
	upd_date DATETIME COMMENT 'Timestamp in cui è stata effettuata l''ultima modifica al record',
	FOREIGN KEY(id_mp_time) REFERENCES mp_time(id)
);
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
-- Tabella per la gestione delle richieste
-- -- --
CREATE TABLE IF NOT EXISTS mp_request (
	id INT AUTO_INCREMENT PRIMARY KEY,
	id_mp_time_detail INT NOT NULL COMMENT 'Id del dettaglio timesheet di riferimento',
	note VARCHAR(1000) COMMENT 'Eventuali note inserite dall''utente',
	flg_auto boolean DEFAULT false COMMENT 'Flag per la richiesta auto',
	flg_taxi boolean DEFAULT false COMMENT 'Flag per la richiesta taxi',
	ins_user_name VARCHAR(256) NOT NULL COMMENT 'User name dell''utente che ha inserito il record',
	ins_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Timestamp in cui è stato inserito il record',
	upd_user_name VARCHAR(256) COMMENT 'User name dell''utente che ha effettuato l''ultima modifica al record',
	upd_date DATETIME COMMENT 'Timestamp in cui è stata effettuata l''ultima modifica al record',
	FOREIGN KEY(id_mp_time_detail) REFERENCES mp_time_detail(id)
);
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
-- Tabella per la gestione dello stato delle richieste
-- -- --
CREATE TABLE IF NOT EXISTS mp_request_status (
	id INT AUTO_INCREMENT PRIMARY KEY,
	id_mp_request INT NOT NULL COMMENT 'Id della request di riferimento',
	id_mp_status INT NOT NULL COMMENT 'Id dello stato di riferimento',
	date_start DATETIME NOT NULL COMMENT 'Data e ora di inizio',
	date_end DATETIME COMMENT 'Data e ora di fine',
	note VARCHAR(1000) COMMENT 'Eventuali note inserite dall''utente approvatore',
	ins_user_name VARCHAR(256) NOT NULL COMMENT 'User name dell''utente che ha inserito il record',
	ins_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Timestamp in cui è stato inserito il record',
	upd_user_name VARCHAR(256) COMMENT 'User name dell''utente che ha effettuato l''ultima modifica al record',
	upd_date DATETIME COMMENT 'Timestamp in cui è stata effettuata l''ultima modifica al record',
	FOREIGN KEY(id_mp_request) REFERENCES mp_request(id),
	FOREIGN KEY(id_mp_status) REFERENCES mp_status(id)
);