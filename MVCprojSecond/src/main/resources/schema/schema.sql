ȸ�� ���̺� ����
Create table tbl_member(
user_id varchar(10),
user_pw varchar(12),
user_name varchar(10),
user_email varchar(20),
user_regdate DATE DEFAULT sysdate,
user_updatedate DATE DEFAULT sysdate,
primary key(user_id)
);

�Խ��� ���̺� ����
create table tbl_board(
bno number not null,          
title varchar2(200) not null,
content varchar2(4000),        
writer varchar2(50) not null,   
regdate date default sysdate, 
viewcnt number default 0,
show char(1),
primary key(bno)
);

��� ���̺� ����
create table tbl_reply(
rno number not null, 
bno number not null,
replytext varchar2(1000) not null,
replyer varchar2(50),           
regdate date default sysdate, 
updatedate date default sysdate,
secret_reply char(1),
primary key(rno)
);

��� ���̺� ��������(�ܷ�Ű) ����
alter table tbl_reply add constraint bno foreign key(bno) references tbl_board(bno);

������ ���� (�Խ���, ���)
CREATE SEQUENCE seq_board START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE reply_seq START WITH 1 INCREMENT BY 1;

�Խ��� ÷������ ���̺� ����
CREATE TABLE tbl_attach (
  fullname VARCHAR2(150) NOT NULL,
  bno NUMBER NOT NULL,
  regdate DATE DEFAULT SYSDATE,
  PRIMARY KEY(fullname)
);

���� ���̺� ����
CREATE TABLE tbl_user(
    userid VARCHAR2(50) NOT NULL,
    userpw VARCHAR2(50) NOT NULL,
    uname VARCHAR2(100) NOT NULL,
    upoint NUMBER DEFAULT 0,
    PRIMARY KEY(userid)
);

�޼��� ���̺� ����
CREATE TABLE tbl_message(
    mid NUMBER NOT NULL,
    targetid VARCHAR2(50) NOT NULL,
    sender VARCHAR2(50) NOT NULL,
    message VARCHAR2(4000) NOT NULL,
    opendate DATE,
    senddate DATE DEFAULT SYSDATE,
    PRIMARY KEY(mid)
);

�޼��� ���̺� ������ ����
CREATE SEQUENCE message_seq START WITH 1 INCREMENT BY 1;

�޼��� ���̺� ��������(�ܷ�Ű) ����
ALTER TABLE tbl_message ADD CONSTRAINT fk_usertarget FOREIGN KEY (targetid) REFERENCES tbl_user(userid);

�Խ��� ÷������ ���̺� ��������(�ܷ�Ű) ����
ALTER TABLE tbl_attach ADD CONSTRAINT fk_board_attch FOREIGN KEY(bno) REFERENCES tbl_board(bno);

��ǰ ���̺� ����, ��ǰ ��ȣ �⺻Ű ����
CREATE TABLE tbl_product (
product_id NUMBER, 
product_name VARCHAR2(50), 
product_price NUMBER DEFAULT 0,
product_desc VARCHAR2(500),   
product_url VARCHAR2(500),     
PRIMARY KEY(product_id)
);

��ǰ ���ڵ� �Է�
INSERT INTO tbl_product VALUES (1,'����Ű',100000,'����Ű 2017�� �Ż���ǰ�Դϴ�.','nike.jpg');
INSERT INTO tbl_product VALUES (2,'�Ƶ�ٽ�',80000,'�Ƶ�ٽ��� ���׵� ����!','adidas.jpg');
INSERT INTO tbl_product VALUES (3,'���߶���',110000,'���߶����� 2016�� �ְ��� �Ź�','newbalance.jpg');
INSERT INTO tbl_product VALUES (4,'Ǫ��',98000,'Ǫ�� 30���� Ư������ ��ǰ�Դϴ�.','puma.jpg');
INSERT INTO tbl_product VALUES (5,'��������',150000,'�������� ���׵� ����! Ư������ ���Դϴ�.','timberland.png');
INSERT INTO tbl_product VALUES (6,'����Ʈ',99000,'����� ���� ����Ʈ�Դϴ�.','rockport.jpg');
INSERT INTO tbl_product VALUES (7,'����',120000,'2017 �Ż� ǻ�� �԰�Ǿ����ϴ�.','reebok.jpg');
INSERT INTO tbl_product VALUES (8,'������',60000,'������ Ư������ ���Դϴ�.','converse.jpg');

��ǰ ���̺� ������ ����
CREATE SEQUENCE seq_product START WiTH 9 INCREMENT BY 1;

��ٱ��� ���̺� ����
CREATE TABLE tbl_cart(
cart_id NUMBER NOT NULL PRIMARY KEY,
user_id VARCHAR2(50) NOT NULL,
product_id NUMBER NOT NULL,
amount NUMBER DEFAULT 0
);

��ٱ��� ���̺� ������ ����
CREATE SEQUENCE seq_cart START WiTH 10 INCREMENT BY 1;

��ٱ��� ���̺� ��������(�ܷ�Ű) ����
ALTER TABLE tbl_cart ADD CONSTRAINT cart_userid_fk FOREIGN KEY(user_id) REFERENCES tbl_member(user_id);
ALTER TABLE tbl_cart ADD CONSTRAINT cart_product_fk FOREIGN KEY(product_id) REFERENCES tbl_product(product_id);

������ ���̺� ����
CREATE TABLE tbl_admin (
    user_id VARCHAR(50) NOT NULL,
    user_pw VARCHAR(50) NOT NULL,
    user_name VARCHAR(50) NOT NULL,
    user_email VARCHAR(100),
    user_regdate DATE DEFAULT SYSDATE,
    user_updatedate DATE DEFAULT SYSDATE,
    PRIMARY KEY(user_id)
);