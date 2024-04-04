-- iolist

CREATE DATABASE iolistDB2;
use iolistDB2;
CREATE TABLE tbl_iolist (
    io_seq   INT PRIMARY KEY AUTO_INCREMENT,
    io_date  VARCHAR(10) NOT NULL,
    io_time  VARCHAR(10) NOT NULL,
    io_input VARCHAR(1) NOT NULL,
    io_pname VARCHAR(30) NOT NULL,
    io_price INT NOT NULL,
    io_quan  INT NOT NULL,
    io_total INT
);

DESC tbl_iolist;

drop table tbl_iolist;