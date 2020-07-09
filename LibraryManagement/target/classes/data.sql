INSERT IGNORE  INTO role(role_id,role_name) VALUES
 	(1,'Admin'),
	(2,'Librarian'),
        (3,'Student');

	
INSERT IGNORE INTO users(user_id,address,email,name,password)VALUES
	(1,'Bangalore','admin@aroha.co.in','Admin','$2a$10$7sFPuv1oAYlgVQSzzCdQwe5fo28SYUJZ7jsIdJJXtMfccghn7sknq'),
	(2,'Pune','librarian@aroha.co.in','Librarian','$2a$10$b5Z8YmXJPM25BOcaM0Ls7OylmXVXxEYg7jvcy2iMj2oZ8aIR22/3i'),
        (3,'Assam','alexa@aroha.co.in','Student','$2a$10$7sFPuv1oAYlgVQSzzCdQwe5fo28SYUJZ7jsIdJJXtMfccghn7sknq');
	
INSERT  IGNORE INTO user_roles(user_id,role_id)VALUES
	(1,1),
	(2,2),
        (3,3);

INSERT IGNORE INTO book_type(id,bookgener) VALUES
	(1,'Science'),
	(2,'Textbook'),
	(3,'History'),
	(4,'Mystery')
	

	
