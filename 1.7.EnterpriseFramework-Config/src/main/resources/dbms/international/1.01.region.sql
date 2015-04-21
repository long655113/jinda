/**
create user ctf_user identified by ctfpwd;
grant resource to ctf_user;
grant connect to ctf_user;
grant create view to ctf_user;
**/

drop table system_regions;
drop table system_region_descriptions;
drop view v_system_regions;
--系统区域信息
create table system_regions (
  id                int                  not null, --编码
  parentid               int                  default 0, --上级节点编码
  rank              int                  default 0, --所在级别
  postcode          varchar2(6)          null        , --区号
  seq               int                  default 0, --显示序号
  rank1             int                  default 0, --一级编码
  rank2             int                  default 0, --二级编码
  rank3             int                  default 0, --三级编码
  rank4             int                  default 0, --四级编码
  rank5             int                  default 0, --五级编码
  rank6             int                  default 0, --六级编码
  rank7             int                  default 0, --七级编码
  rank8             int                  default 0, --八级编码
  rank9             int                  default 0, --九级编码
  constraint pk_system_region primary key (id)
);

comment on table system_regions is '系统区域信息';
comment on column system_regions.id is '编码';
comment on column system_regions.parentid is '上级节点编码';
comment on column system_regions.rank is '所在级别';
comment on column system_regions.postcode is '区号';
comment on column system_regions.seq is '显示序号';
comment on column system_regions.rank1 is '一级编码';
comment on column system_regions.rank2 is '二级编码';
comment on column system_regions.rank3 is '三级编码';
comment on column system_regions.rank4 is '四级编码';
comment on column system_regions.rank5 is '五级编码';
comment on column system_regions.rank6 is '六级编码';
comment on column system_regions.rank7 is '七级编码';
comment on column system_regions.rank8 is '八级编码';
comment on column system_regions.rank9 is '九级编码';

--区域信息－描述
create table system_region_descriptions (
  id                int                  not null, --编码
  parent_id         int                  default 0, --关联信息
  name              varchar2(32)         null        , --名称
  lang              varchar2(5)          null        , --语言
  description       varchar2(256)        null        , --描述
  constraint pk_system_region_descriptions primary key (id)
);

comment on table system_region_descriptions is '区域信息－描述';
comment on column system_region_descriptions.id is '编码';
comment on column system_region_descriptions.parent_id is '关联信息';
comment on column system_region_descriptions.name is '名称';
comment on column system_region_descriptions.lang is '语言';
comment on column system_region_descriptions.description is '描述';





insert into system_regions(id,parentid,postcode,seq) values(10000,0,'86',1);
insert into system_region_descriptions(id,parent_id,name,lang) values(100,10000,'中国大陆','zh_CN');

insert into system_regions(id,parentid,postid,seq) values(10100,10000,'',1);
insert into system_region_descriptions(id,parent_id,name,lang) values(101,10100,'北京','zh_CN');

insert into system_regions(id,parentid,postid,seq) values(12000,10000,'',4);
insert into system_region_descriptions(id,parent_id,name,lang) values(102,12000,'广东','zh_CN');

insert into system_regions(id,parentid,postid,seq) values(10200,12000,'',4);
insert into system_region_descriptions(id,parent_id,name,lang) values(103,10200,'广州','zh_CN');