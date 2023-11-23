import React from "react";
import { useState } from "react";

export const ShortCircuitEvaluation = () => {
  const [test, setTest] = useState();
  const [testing, setTesting] = useState("Hello");

  return (
    <div>
      <h4>Truthy OR : {test || "Anonymous"}</h4>
      <h4>Truthy AND : {test && "Anonymous"}</h4>
      <h4>Falsy OR : {testing || "Anonymous"}</h4>
      <h4>Falsy AND : {testing && "Anonymous"}</h4>
    </div>
    //or - returns true
    //and - returns false
    //ternary operator
    //condition ? 1 : 2
  );
};
