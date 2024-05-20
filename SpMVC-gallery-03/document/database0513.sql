-- gallerydb2;

USE galleryDB2;

show tables;
DROP TABLE tbl_mygallery;

CREATE TABLE tbl_mygallery(
g_id VARCHAR(125) PRIMARY KEY,
g_date VARCHAR(125),
g_time VARCHAR(125),
g_subject VARCHAR(125),
g_content VARCHAR(125),
g_writer VARCHAR(125),
g_password VARCHAR(125),
g_image VARCHAR(225)

);

CREATE TABLE tbl_myimages(
	i_id VARCHAR(125) PRIMARY KEY,
    i_seq INT,
    i_gid VARCHAR(125) NOT NULL,
    i_origin_image VARCHAR(255),
	i_up_image VARCHAR(255),
    CONSTRAINT FK_imgae
    FOREIGN KEY (i_gid)
    REFERENCES tbl_mygallery(g_id)
    ON DELETE CASCADE
);