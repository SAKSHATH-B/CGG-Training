import React, { useState } from "react";

export const MultipleEffects = () => {
  const [value, setValue] = useState(0);
  const [secondValue, setSecondValue] = useState(0);
  return (
    <div>
      <h1>First count - {value}</h1>
      <button onClick={() => setValue(value + 1)}>value</button>
      <h1>Second count - {secondValue}</h1>
      <button onClick={() => setSecondValue(secondValue + 1)}>
        Second value
      </button>
    </div>
  );
};
