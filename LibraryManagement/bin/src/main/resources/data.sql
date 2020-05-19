INSERT IGNORE  INTO role(role_id,role_name) VALUES
 	(1,'Admin'),
	(2,'Librarian');

	
INSERT IGNORE INTO users(user_id,address,email,name,password)VALUES
	(1,'Bangalore','admin@aroha.co.in','Admin','admin'),
	(2,'Bangalore','librarian@aroha.co.in','Librarian','librarian');
	
INSERT  IGNORE INTO user_roles(user_id,role_id)VALUES
	(1,1),
	(2,2);

INSERT IGNORE INTO book_type(id,bookgener) VALUES
	(1,'Action and adventure'),
	(2,'Comic book'),
	(3,'Science fiction'),
	(4,'Science'),
	(5,'Textbook'),
	(6,'History'),
	(7,'Health'),
	(8,'Math'),
	(9,'Anthology'),
	(10,'Mystery'),
	(11,'Fantasy'),
	(12,'Drama');
	
