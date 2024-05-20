-- galleryDB2
-- 30일도 사용.

use galleryDB2;
desc tbl_gallerys;
desc tbl_users;

select * from tbl_gallerys;
select * from tbl_images;
select * from tbl_users;
select * from tbl_roles;

SELECT last_insert_id();

DROP TABLE tbl_images;
DROP TABLE tbl_gallerys;
DROP TABLE tbl_users;
DROP TABLE tbl_roles;

CREATE TABLE tbl_users (
    username VARCHAR(125) PRIMARY KEY,
    password VARCHAR(125) NOT NULL,
    email VARCHAR(125) NOT NULL,
    tel VARCHAR(125) NOT NULL
);
show tables;
CREATE TABLE IF NOT EXISTS tbl_roles (
			r_username VARCHAR(125),
	    	r_role VARCHAR(125) NOT NULL,
            
			CONSTRAINT PK_ROLE
            PRIMARY KEY (r_username, r_role),
            
			CONSTRAINT FK_USER
			FOREIGN KEY (r_username)
			REFERENCES tbl_users(username) ON DELETE CASCADE
		
		);

