declare
v_name emp.ename%type;
v_empid emp.empno%type;
v_salry emp.sal%type;
cursor my_cur(id integer) is (select ename,empno,sal from emp where deptno = id);        --parameterized cursor
--cnt integer(3);
begin
    open my_cur(&a);
    if my_cur%isopen then
        dbms_output.put_line('True');
    end if;
    loop
        fetch my_cur into v_name,v_empid,v_salry;
        exit when my_cur%notfound;
        dbms_output.put_line(v_name||' , '||v_empid||' , '||v_salry);
    end loop;
    close my_cur;
    if my_cur%isopen then
        dbms_output.put_line('True');
    else DBMS_OUTPUT.PUT_LINE('False');
    end if;

    open my_cur(&b);
    if my_cur%isopen then
        dbms_output.put_line('True');
    end if;
    loop
        fetch my_cur into v_name,v_empid,v_salry;
        exit when my_cur%notfound;
        dbms_output.put_line(v_name||' , '||v_empid||' , '||v_salry);
    end loop;
    close my_cur;
    if my_cur%isopen then
        dbms_output.put_line('True');
    else DBMS_OUTPUT.PUT_LINE('False');
    end if;
        
        
--    update emp set sal = sal + 0;
--    cnt := SQL%rowcount;
--    dbms_output.put_line(cnt);
end;
