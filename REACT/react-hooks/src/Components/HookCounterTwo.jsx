import React from "react";
import { useState } from "react";

export const HookCounterTwo = () => {
  const initialCount = 0;
  const [count, setCount] = useState(0);
  const incrementFive = () => {
    for (let index = 1; index <= 5; index++) {
      setCount((prevCount) => prevCount + 1);
    }
  };
  return (
    <div>
      count - {count}
      <div>
        <button onClick={() => setCount(initialCount)}>Reset</button>
        <button onClick={() => setCount((prevCount) => prevCount + 1)}>
          Increment
        </button>
        <button onClick={() => setCount((prevCount) => prevCount - 1)}>
          Decrement
        </button>
        <button onClick={incrementFive}>Increment 5</button>
      </div>
    </div>
  );
};
