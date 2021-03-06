---通过站点获取组织ID---{{{1
---function.GET_ORGID_FROMSITEID---{{{2
CREATE OR REPLACE FUNCTION GET_ORGID_FROMSITEID(
    INSITEID IN VARCHAR2) --参数为 siteid
  RETURN VARCHAR2 DETERMINISTIC
AS
  --返回siteid對應的ORGID
  temp    VARCHAR2(100);
  F_COUNT NUMBER;
BEGIN
  DBMS_OUTPUT.PUT_LINE('BEGIN');
  SELECT COUNT(*) INTO F_COUNT FROM site WHERE upper(siteid)= upper(INSITEID);
  IF F_COUNT =0 THEN
    RETURN NULL;
  END IF;
SELECT upper(orgid) INTO temp FROM site WHERE upper(siteid)= upper(INSITEID);
RETURN temp;
END GET_ORGID_FROMSITEID;

---function.GET_PERSON_DISPLAYNAME---{{{2
create or replace
function GET_PERSON_DISPLAYNAME
(INPERSONID        in varchar2)       --参数为personid
return varchar2 DETERMINISTIC as                    
--返回personid對應的中文名字
--	null	person表中无此personid
--	'%'		有此id但值为空
--	DISPLAYNAME的值
temp VARCHAR2(100);
  F_COUNT NUMBER;
BEGIN
SELECT
      COUNT(*)
    INTO
      F_COUNT
    FROM
      person
    WHERE
      upper(personid)= upper(inpersonid);
   IF F_COUNT       =0 THEN
   RETURN null;
    end if;
    SELECT
     upper(DISPLAYNAME)
    INTO
      temp
    FROM
      person
    WHERE
    upper(personid)= upper(inpersonid);
      if temp is null then return '%'; end if;
  RETURN temp;
END GET_PERSON_DISPLAYNAME;



---增加 ALN 域---{{{1
--sitedisplayname  站点显示名称

select * from alndomain where domainid='SITEDISPLAYNAME';
insert into alndomain (DOMAINID, VALUE, DESCRIPTION, SITEID, ORGID, ALNDOMAINID, VALUEID)
 (select 'SITEDISPLAYNAME' DOMAINID,siteid VALUE,DESCRIPTION ,null SITEID,null ORGID,ALNDOMAINseq.nextval ALNDOMAINID
,'SITEDISPLAYNAME|'||siteid VALUEID from site);



---新建 设备日志表---{{{1
CREATE SEQUENCE PHONEVERSIONIDSEQ INCREMENT BY 1 START WITH 0 MAXVALUE 99999999999999 MINVALUE 0;


CREATE TABLE PHONEVERSION 
(
  PHONEVERSIONID NUMBER DEFAULT  PHONEVERSIONIDSEQ.nextval NOT NULL 
, LOGINID VARCHAR2(200) 
, BRAND VARCHAR2(50) 
, IMEI VARCHAR2(50) 
, VERSION VARCHAR2(20) 
, ISANDROID NUMBER
, TOTALMEMORY NUMBER 
, AVAILMEMORY NUMBER 
, TOTALSPACE NUMBER 
, AVAILABLESPACE NUMBER 
, MODEL VARCHAR2(20) 
, REMARK VARCHAR2(200) 
, CREATEDATE DATE DEFAULT sysdate
);

COMMENT ON COLUMN PHONEVERSION.IMEI IS '设备唯一编码';

COMMENT ON COLUMN PHONEVERSION.VERSION IS '版本号';

COMMENT ON COLUMN PHONEVERSION.ISANDROID IS '是否android系统';

COMMENT ON COLUMN PHONEVERSION.TOTALMEMORY IS '内存总容量';

COMMENT ON COLUMN PHONEVERSION.AVAILMEMORY IS '内存可用容量';

COMMENT ON COLUMN PHONEVERSION.TOTALSPACE IS '空间总容量';

COMMENT ON COLUMN PHONEVERSION.AVAILABLESPACE IS '剩余空间容量';

COMMENT ON COLUMN PHONEVERSION.MODEL IS '系统名称(Redmi 3)';

COMMENT ON COLUMN PHONEVERSION.PHONEVERSIONID IS '主键';

COMMENT ON COLUMN PHONEVERSION.CREATEDATE IS '创建时间';

COMMENT ON COLUMN PHONEVERSION.REMARK IS '备注';

COMMENT ON COLUMN PHONEVERSION.LOGINID IS '登陆人';

COMMENT ON COLUMN PHONEVERSION.BRAND IS '系统定制商';



---域值---{{{1



----------------CommDataScript----------------

insert into alnDOMAIN ( DOMAINID, VALUE, DESCRIPTION, SITEID, ORGID, ALNDOMAINID, VALUEID) values ( 'MPSYSTEMTYPE', 'android', 'android', null, null, ALNDOMAINSEQ.nextval, 'MPSYSTEMTYPE|android');
insert into alnDOMAIN ( DOMAINID, VALUE, DESCRIPTION, SITEID, ORGID, ALNDOMAINID, VALUEID) values ( 'MPSYSTEMTYPE', 'ios', 'ios', null, null, ALNDOMAINSEQ.nextval, 'MPSYSTEMTYPE|ios');


----------------Update Maximo Sequence----------------

update maxsequence set maxreserved=(select max(ALNDOMAINID)+1 from alnDOMAIN) where tbname='ALNDOMAIN' and name='ALNDOMAINID';


----------------CommDataScript----------------

insert into MAXDOMAIN ( DOMAINID, DESCRIPTION, DOMAINTYPE, MAXTYPE, LENGTH, SCALE, MAXDOMAINID, INTERNAL, NEVERCACHE) values ( 'MPSYSTEMTYPE', '系统类别,android/ios', '字母数字', 'ALN', 30, 0, MAXDOMAINSEQ.nextval, 0, 0);


----------------Update Maximo Sequence----------------

update maxsequence set maxreserved=(select max(MAXDOMAINID)+1 from MAXDOMAIN) where tbname='MAXDOMAIN' and name='MAXDOMAINID';

