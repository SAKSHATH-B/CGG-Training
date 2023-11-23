import React, { useState } from "react";

export const UseStateCounter = () => {
  const [count, setCount] = useState(0);
  const incrementCount = () => {
    setTimeout(() => {
      setCount((currentState) => {
        console.log(currentState);
        return currentState + 1;
      });
    }, 3000);
  };
  return (
    <div>
      <h1>{count}</h1>
      <button onClick={incrementCount}>Inc</button>
    </div>
  );
};
