import React, { useMemo, useState } from "react";

const Counter = () => {
  const [firstCounter, setFirstCounter] = useState(0);
  const [secondCounter, setSecondCounter] = useState(0);

  const firstIncrement = () => {
    setFirstCounter(firstCounter + 1);
  };
  const secondIncrement = () => {
    setSecondCounter(secondCounter + 1);
  };
  const isEven = useMemo(() => {
    let i = 0;
    while (i < 1000000000) i++;
    return firstCounter % 2 === 0;
  }, [firstCounter]);

  return (
    <div>
      <button onClick={firstIncrement}>First Counter - {firstCounter}</button>
      <span>{isEven ? "Even" : "Odd"}</span>
      <button onClick={secondIncrement}>
        Second Counter - {secondCounter}
      </button>
    </div>
  );
};

export default Counter;

//useMemo will cache only the return value of the function
