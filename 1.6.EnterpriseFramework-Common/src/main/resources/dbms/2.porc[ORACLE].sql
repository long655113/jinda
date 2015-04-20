CREATE OR REPLACE function getnextcodeA(codename IN character varying, max_value in integer,MINVALUE in integer) return integer AS
  ICOUNT int;
  SSEQNAME VARCHAR2(30);
  NEXTVALUE int;
begin
  /*
  =======================================================
  ==        序列生成器                                        ==
  ==                                                   ==
  ==                           万志勇                      ==
  ==                             2009-03-11 17:29      ==
  =======================================================
  */

  SSEQNAME:=trim(upper(CODENAME));

  SELECT COUNT(*) INTO ICOUNT FROM system_sequences WHERE trim(NAME)=SSEQNAME;

  IF ICOUNT<>1 THEN
    INSERT INTO system_sequences VALUES(SSEQNAME,MINVALUE);
    NEXTVALUE:=MINVALUE;
  ELSE
    SELECT VALUE+1 INTO ICOUNT FROM system_sequences WHERE trim(NAME)=SSEQNAME;
    UPDATE system_sequences SET VALUE=ICOUNT WHERE trim(NAME)=SSEQNAME;
    NEXTVALUE := ICOUNT;
  END IF;
  
  IF NEXTVALUE>max_value THEN
    NEXTVALUE :=MINVALUE;
    update system_sequences set value=NEXTVALUE where trim(NAME)=SSEQNAME;
  END IF;
  return NEXTVALUE;
end;
;


CREATE OR REPLACE PROCEDURE getnextcode (NEXTVALUE OUT int,CODENAME VARCHAR2,MAXVALUE int,MINVALUE in integer) 
is
begin
  /*
  =======================================================
  ==        序列生成器                                 ==
  ==                                                   ==
  ==                           万志勇                  ==
  ==                             2002-05-08 16:04      ==
  ==       使用函数替换存储过程，更好支持事务处理  2009-03-11 ==
  =======================================================
  */
  NEXTVALUE :=getnextcodeA(CODENAME,MAXVALUE,MINVALUE);
end getnextcode;
