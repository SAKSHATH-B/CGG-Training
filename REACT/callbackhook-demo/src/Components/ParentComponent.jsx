// import { Button } from "bootstrap";
import React, { useCallback } from "react";
import { useState } from "react";
import Title from "./Title";
import Count from "./Count";
import Button from "./Button";

export const ParentComponent = () => {
  const [age, setAge] = useState(25);
  const [salary, setSalary] = useState(50000);
  const incrementAge = useCallback(() => {
    setAge(age + 1);
  }, [age]);
  const incrementSalary = useCallback(() => {
    setSalary(salary + 5000);
  }, [salary]);
  return (
    <div>
      <Title />
      <Count text="Age" count={age} />
      <Button handleClick={incrementAge}>Increment Age</Button>

      <Count text="Salary" count={salary} />
      <Button handleClick={incrementSalary}>Increment Salary</Button>
    </div>
  );
};

//usecallback is useful when passing callbacks to optimized child components that rely on reference equality and prevent unnecessary rerenders
//it will cache all the function
