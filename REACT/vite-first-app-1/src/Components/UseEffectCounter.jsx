import React, { useEffect, useState } from "react";

export const UseEffectCounter = () => {
  const [value, setValue] = useState(0);
  useEffect(() => {
    console.log("Hello I am running");
    // document.title = `${value} -- Count`;
  }, []);
  return (
    <div>
      <h1>Value : {value}</h1>
      <button onClick={() => setValue(value + 1)}>Increment</button>
    </div>
  );
};
