CREATE TABLE IF NOT EXISTS Users (
    useridpk VARCHAR(16) NOT NULL,
    firstname VARCHAR(64) NOT NULL,
    lastname VARCHAR(64) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(8) NOT NULL,
    PRIMARY KEY (useridpk)
);

CREATE TABLE IF NOT EXISTS Run(
	id INT NOT NULL,
	title varchar(256) NOT NULL,
	started_on timestamp NOT NULL,
	completed_on timestamp NOT NULL,
	miles INT NOT NULL,
	location varchar(32) NOT NULL,
	useridpk VARCHAR(16) NOT NULL,
	PRIMARY KEY (id)
);