--系统帐号信息
create table system_accounts (
  code                   char(12)             not null, --帐号编码
  name                   varchar2(32)         null        , --真实姓名
  nickname               varchar2(32)         null        , --昵称
  photo                  varchar2(64)         null        , --缺省图像
  account                varchar2(32)         null        , --登陆名称/帐号
  passwod_category       int                  default 0, --密码类型
  password               varchar2(32)         null        , --密码
  deadline               date                 null        , --密码过期时间
  mobile                 varchar2(21)         null        , --联系电话
  email                  varchar2(64)         null        , --联系邮箱
  org_id                 int                  default 0, --所属组织
  theme                  varchar2(16)         null        , --缺省样式
  language               varchar2(8)          null        , --缺省语言
  timeout                int                  default 0, --系统超时
  status                 int                  default 2, --帐号状态
  role_code              char(8)              null        , --角色
  last_access_time       date                 null        , --最近登陆时间
  ip                     varchar2(16)         null        , --登陆IP
  availables             int                  default 0, --剩余使用次数
  constraint pk_system_accounts primary key (code)
);

comment on table system_accounts is '系统帐号信息';
comment on column system_accounts.code is '帐号编码';
comment on column system_accounts.name is '真实姓名';
comment on column system_accounts.nickname is '昵称';
comment on column system_accounts.photo is '缺省图像';
comment on column system_accounts.account is '登陆名称/帐号';
comment on column system_accounts.passwod_category is '密码类型';
comment on column system_accounts.password is '密码';
comment on column system_accounts.deadline is '密码过期时间';
comment on column system_accounts.mobile is '联系电话';
comment on column system_accounts.email is '联系邮箱';
comment on column system_accounts.org_id is '所属组织';
comment on column system_accounts.theme is '缺省样式';
comment on column system_accounts.language is '缺省语言';
comment on column system_accounts.timeout is '系统超时';
comment on column system_accounts.status is '帐号状态';
comment on column system_accounts.role_code is '角色';
comment on column system_accounts.last_access_time is '最近登陆时间';
comment on column system_accounts.ip is '登陆IP';
comment on column system_accounts.availables is '剩余使用次数';

