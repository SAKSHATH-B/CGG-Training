import React, { useState } from "react";

export const Counter = () => {
  const [counter, setCounter] = useState(0);
  return (
    <button onClick={() => setCounter(counter + 1)}>Count {counter}</button>
  );
};
