use ssafy;

create table ssafy_session(
	tour_info_nm varchar(300),
    tour_location_nm varchar(300),
    sido varchar(300),
    sigugun varchar(300),
    off_day varchar(300),
    tel varchar(300),
    addr_road varchar(300),
    addr_no varchar(300),
    ssafy_id varchar(300),
    reg_dt DATETIME  DEFault current_timestamp
);


select * from ssafy_session;

update ssafy_session
set ssafy_id = "0825492";