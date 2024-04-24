-- galleryDB 2024-04-24

CREATE DATABASE galleryDB2;
USE galleryDB;

CREATE TABLE tbl_gallerys (
    g_id VARCHAR(125) PRIMARY KEY,
    g_date VARCHAR(10) NOT NULL,
    g_time VARCHAR(10) NOT NULL,
    g_auth VARCHAR(20) NOT NULL,
    g_subject VARCHAR(20) NOT NULL,
    g_content VARCHAR(100) NOT NULL,
    g_origin_image VARCHAR(225) NOT NULL,
    g_up_image VARCHAR(225) NOT NULL
);

desc tbl_gallerys;