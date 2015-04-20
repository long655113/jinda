--ϵͳ�ʺ���Ϣ
create table system_accounts (
  code                   char(12)             not null, --�ʺű���
  name                   varchar2(32)         null        , --��ʵ����
  nickname               varchar2(32)         null        , --�ǳ�
  photo                  varchar2(64)         null        , --ȱʡͼ��
  account                varchar2(32)         null        , --��½����/�ʺ�
  passwod_category       int                  default 0, --��������
  password               varchar2(32)         null        , --����
  deadline               date                 null        , --�������ʱ��
  mobile                 varchar2(21)         null        , --��ϵ�绰
  email                  varchar2(64)         null        , --��ϵ����
  org_id                 int                  default 0, --������֯
  theme                  varchar2(16)         null        , --ȱʡ��ʽ
  language               varchar2(8)          null        , --ȱʡ����
  timeout                int                  default 0, --ϵͳ��ʱ
  status                 int                  default 2, --�ʺ�״̬
  role_code              char(8)              null        , --��ɫ
  last_access_time       date                 null        , --�����½ʱ��
  ip                     varchar2(16)         null        , --��½IP
  availables             int                  default 0, --ʣ��ʹ�ô���
  constraint pk_system_accounts primary key (code)
);

comment on table system_accounts is 'ϵͳ�ʺ���Ϣ';
comment on column system_accounts.code is '�ʺű���';
comment on column system_accounts.name is '��ʵ����';
comment on column system_accounts.nickname is '�ǳ�';
comment on column system_accounts.photo is 'ȱʡͼ��';
comment on column system_accounts.account is '��½����/�ʺ�';
comment on column system_accounts.passwod_category is '��������';
comment on column system_accounts.password is '����';
comment on column system_accounts.deadline is '�������ʱ��';
comment on column system_accounts.mobile is '��ϵ�绰';
comment on column system_accounts.email is '��ϵ����';
comment on column system_accounts.org_id is '������֯';
comment on column system_accounts.theme is 'ȱʡ��ʽ';
comment on column system_accounts.language is 'ȱʡ����';
comment on column system_accounts.timeout is 'ϵͳ��ʱ';
comment on column system_accounts.status is '�ʺ�״̬';
comment on column system_accounts.role_code is '��ɫ';
comment on column system_accounts.last_access_time is '�����½ʱ��';
comment on column system_accounts.ip is '��½IP';
comment on column system_accounts.availables is 'ʣ��ʹ�ô���';

