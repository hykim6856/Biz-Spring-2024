-- gallerydb3
CREATE DATABASE galleryDB3;
use galleryDB3;

show tables;
drop table tbl_gallerys; 
drop table tbl_images;

desc tbl_gallerys;
desc tbl_images;

select * from tbl_gallerys;
select * from tbl_images;

select * 
from tbl_gallerys G
	JOIN tbl_images I
		ON G.g_id = I.i_gid;