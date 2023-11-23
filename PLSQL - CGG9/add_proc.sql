create or replace procedure sum(x in integer,y in integer,z out integer) as

begin
    z:=x+y;
    dbms_output.put_line('sum is : '||z);
end;

declare
p integer;
q integer;
r integer;
begin
    p:=2;
    q:=3;
    sum(p,q,r);
end;