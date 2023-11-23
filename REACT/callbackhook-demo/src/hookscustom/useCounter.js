import { useState } from "react";

export const useCounter = (initialValue = 0, value) => {
  const [count, setCount] = useState(initialValue);
  const increment = () => {
    setCount(count + value);
  };
  const decrement = () => {
    setCount(count - value);
  };
  const reset = () => {
    setCount(initialValue);
  };

  return [count, increment, decrement, reset];
};
