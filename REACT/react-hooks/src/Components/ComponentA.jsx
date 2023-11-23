import React, { useContext } from "react";
import { counterContext } from "../App";

export const ComponentA = () => {
  const count = useContext(counterContext);
  return (
    <div>
      Component A<div>count -- {count.counter}</div>
      <button onClick={() => count.dispatchCount("increment")}>
        Increment
      </button>
      <button onClick={() => count.dispatchCount("decrement")}>
        Decrement
      </button>
      <button onClick={() => count.dispatchCount("reset")}>Reset</button>
    </div>
  );
};
