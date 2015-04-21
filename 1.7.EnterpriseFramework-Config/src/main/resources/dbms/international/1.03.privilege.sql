drop table system_menus;
drop table system_menu_descriptions;
drop table system_roles;
drop table system_role_descriptions ;
drop table system_role_privileges;
--系统菜单
create table system_menus (
  code              varchar2(30)         not null, --控制器编码
  ucode             varchar2(30)         null        , --所属控制器
  url               varchar2(64)         null        ,
  status            int                  default 0, --状态
  seq               int                  default 0, --显示顺序
  css               varchar2(16)         null        , --样式
  lang              varchar2(5)          null        , --语言
  constraint pk_system_menus primary key (code)
);


comment on table system_menus is '系统菜单';
comment on column system_menus.code is '控制器编码';
comment on column system_menus.ucode is '所属控制器';
comment on column system_menus.status is '状态';
comment on column system_menus.seq is '显示顺序';
comment on column system_menus.css is '样式';
comment on column system_menus.lang is '语言';



--系统菜单描述
create table system_menu_descriptions (
  code              char(8)              not null, --编码
  ucode             varchar2(32)         null        , --关联信息
  lang              varchar2(5)          null        , --语言
  title             varchar2(32)         null        , --标题
  description       varchar2(256)        null        , --描述
  constraint pk_menu_descriptions primary key (code)
);

comment on table system_menu_descriptions is '系统菜单描述';
comment on column system_menu_descriptions.code is '编码';
comment on column system_menu_descriptions.ucode is '关联信息';
comment on column system_menu_descriptions.lang is '语言';
comment on column system_menu_descriptions.title is '标题';
comment on column system_menu_descriptions.description is '描述';

   
--系统角色
create table system_roles (
  code        char(8)              not null, --编码
  rank        int                  default 0, --层级
  rank1       varchar(8)           null        , --一级编码
  rank2       varchar(8)           null        , --二级编码
  rank3       varchar(8)           null        , --三级编码
  rank4       varchar(8)           null        , --四级编码
  rank5       varchar(8)           null        , --五级编码
  rank6       varchar(8)           null        , --六级编码
  rank7       varchar(8)           null        , --七级编码
  rank8       varchar(8)           null        , --八级编码
  rank9       varchar(8)           null        , --九级编码
  ucode       varchar(8)           null        , --上级编码
  status      int                  default  0,--角色状态
  constraint pk_system_roles primary key (code)
);

comment on table system_roles is '系统角色';
comment on column system_roles.code is '编码';
comment on column system_roles.rank is '层级';
comment on column system_roles.rank1 is '一级编码';
comment on column system_roles.rank2 is '二级编码';
comment on column system_roles.rank3 is '三级编码';
comment on column system_roles.rank4 is '四级编码';
comment on column system_roles.rank5 is '五级编码';
comment on column system_roles.rank6 is '六级编码';
comment on column system_roles.rank7 is '七级编码';
comment on column system_roles.rank8 is '八级编码';
comment on column system_roles.rank9 is '九级编码';
comment on column system_roles.ucode is '上级编码';

--角色语言描述
create table system_role_descriptions (
  code              char(8)              not null, --编码
  ucode             varchar2(16)         null        , --关联信息
  lang              varchar2(5)          null        , --语言
  name              varchar2(32)         null        , --角色名称
  description       varchar2(256)        null        , --描述
  constraint pk_system_role_descriptions primary key (code)
);

comment on table system_role_descriptions is '角色语言描述';
comment on column system_role_descriptions.code is '编码';
comment on column system_role_descriptions.ucode is '关联信息';
comment on column system_role_descriptions.lang is '语言';
comment on column system_role_descriptions.name is '角色名称';
comment on column system_role_descriptions.description is '描述';

--角色权限信息
create table system_role_privileges (
  code                 char(8)              not null, --权限编码
  role_code            varchar2(8)          null        , --角色编码
  privilege_code       varchar2(32)         null        , --权限编码
  constraint pk_system_role_privileges primary key (code)
);

comment on table system_role_privileges is '角色权限信息';
comment on column system_role_privileges.code is '权限编码';
comment on column system_role_privileges.role_code is '角色编码';
comment on column system_role_privileges.privilege_code is '权限编码';


insert into system_menus values('SYSTEM','*','',1,100,'','');
insert into system_menu_descriptions values('MENU0001','SYSTEM','zh_CN','系统管理','');
insert into system_menus values('AccountManagementController','SYSTEM','../../core/account/query',1,1,'','');
insert into system_menu_descriptions values('MENU0002','AccountManagementController','zh_CN','帐号管理','');

insert into system_menus values('PrivilegeQueryController','SYSTEM','../../core/privilege/query',1,2,'','');
insert into system_menu_descriptions values('MENU0003','PrivilegeQueryController','zh_CN','权限管理','');
