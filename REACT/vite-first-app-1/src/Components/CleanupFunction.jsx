import React from "react";
import { useEffect } from "react";
import { useState } from "react";

export const CleanupFunction = () => {
  const [toggle, setToggle] = useState(false);
  console.log("initial render");
  return (
    <div>
      <button onClick={() => setToggle(!toggle)}>Toggle</button>
      {toggle && <SecondComp />}
    </div>
  );
};

const SecondComp = () => {
  useEffect(() => {
    const someFunc = () => {};
    window.addEventListener("scroll", someFunc);
    return window.removeEventListener("scroll", someFunc);
  }, []);
  return <h2>Hello There</h2>;
};
