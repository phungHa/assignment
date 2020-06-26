INSERT into track VALUES (1,'name1','desc1',NOW());
INSERT into track VALUES (2,'name2','desc2',NOW() - INTERVAL 1 DAY);

INSERT into way_point VALUES (1,1,10.10,19.10,'value10','/abc/xyx');

INSERT into way_point VALUES (2,1,11.10,19.11,'value11','/abc/xyx1');

INSERT into way_point VALUES (6,1,12.10,19.12,'value12','/abc/xyx2');

INSERT into way_point VALUES (7,1,13.10,19.13,'value13','/abc/xyx3');

INSERT into way_point VALUES (5,1,14.10,19.14,'value14','/abc/xyx4');

INSERT into way_point VALUES (3,2,10.10,19.10,'value10','/abc/xyx');

INSERT into way_point VALUES (4,2,11.10,19.11,'value11','/abc/xyx1');

INSERT into way_point VALUES (8,2,12.10,19.12,'value12','/abc/xyx2');

INSERT into way_point VALUES (9,2,13.10,19.13,'value13','/abc/xyx3');

INSERT into track_point VALUES (1,1,14.10,19.14,10,NOW());
INSERT into track_point VALUES (7,1,14.10,19.14,11,NOW() - INTERVAL 1 DAY);
INSERT into track_point VALUES (8,1,14.10,19.14,12,NOW() - INTERVAL 2 DAY);
INSERT into track_point VALUES (9,1,14.10,19.14,13,NOW() - INTERVAL 3 DAY);
INSERT into track_point VALUES (5,1,14.10,19.14,14,NOW() - INTERVAL 4 DAY);

INSERT into track_point VALUES (6,2,14.10,19.14,10,NOW());
INSERT into track_point VALUES (2,2,14.10,19.14,11,NOW() - INTERVAL 2 DAY);
INSERT into track_point VALUES (3,2,14.10,19.14,12,NOW() - INTERVAL 3 DAY);
INSERT into track_point VALUES (4,2,14.10,19.14,13,NOW() - INTERVAL 4 DAY);
INSERT into track_point VALUES (10,2,14.10,19.14,14,NOW() - INTERVAL 5 DAY);
