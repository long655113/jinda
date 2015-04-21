/**
create user ctf_user identified by ctfpwd;
grant resource to ctf_user;
grant connect to ctf_user;
grant create view to ctf_user;
**/

drop table system_regions;
drop table system_region_descriptions;
drop view v_system_regions;
--ϵͳ������Ϣ
create table system_regions (
  id                int                  not null, --����
  parentid               int                  default 0, --�ϼ��ڵ����
  rank              int                  default 0, --���ڼ���
  postcode          varchar2(6)          null        , --����
  seq               int                  default 0, --��ʾ���
  rank1             int                  default 0, --һ������
  rank2             int                  default 0, --��������
  rank3             int                  default 0, --��������
  rank4             int                  default 0, --�ļ�����
  rank5             int                  default 0, --�弶����
  rank6             int                  default 0, --��������
  rank7             int                  default 0, --�߼�����
  rank8             int                  default 0, --�˼�����
  rank9             int                  default 0, --�ż�����
  constraint pk_system_region primary key (id)
);

comment on table system_regions is 'ϵͳ������Ϣ';
comment on column system_regions.id is '����';
comment on column system_regions.parentid is '�ϼ��ڵ����';
comment on column system_regions.rank is '���ڼ���';
comment on column system_regions.postcode is '����';
comment on column system_regions.seq is '��ʾ���';
comment on column system_regions.rank1 is 'һ������';
comment on column system_regions.rank2 is '��������';
comment on column system_regions.rank3 is '��������';
comment on column system_regions.rank4 is '�ļ�����';
comment on column system_regions.rank5 is '�弶����';
comment on column system_regions.rank6 is '��������';
comment on column system_regions.rank7 is '�߼�����';
comment on column system_regions.rank8 is '�˼�����';
comment on column system_regions.rank9 is '�ż�����';

--������Ϣ������
create table system_region_descriptions (
  id                int                  not null, --����
  parent_id         int                  default 0, --������Ϣ
  name              varchar2(32)         null        , --����
  lang              varchar2(5)          null        , --����
  description       varchar2(256)        null        , --����
  constraint pk_system_region_descriptions primary key (id)
);

comment on table system_region_descriptions is '������Ϣ������';
comment on column system_region_descriptions.id is '����';
comment on column system_region_descriptions.parent_id is '������Ϣ';
comment on column system_region_descriptions.name is '����';
comment on column system_region_descriptions.lang is '����';
comment on column system_region_descriptions.description is '����';





insert into system_regions(id,parentid,postcode,seq) values(10000,0,'86',1);
insert into system_region_descriptions(id,parent_id,name,lang) values(100,10000,'�й���½','zh_CN');

insert into system_regions(id,parentid,postid,seq) values(10100,10000,'',1);
insert into system_region_descriptions(id,parent_id,name,lang) values(101,10100,'����','zh_CN');

insert into system_regions(id,parentid,postid,seq) values(12000,10000,'',4);
insert into system_region_descriptions(id,parent_id,name,lang) values(102,12000,'�㶫','zh_CN');

insert into system_regions(id,parentid,postid,seq) values(10200,12000,'',4);
insert into system_region_descriptions(id,parent_id,name,lang) values(103,10200,'����','zh_CN');