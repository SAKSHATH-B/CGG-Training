import React, { useEffect, useRef, useState } from "react";

export const UseRefHook = () => {
  const [value, setValue] = useState(0);
  const refContainer = useRef(null);
  const isMounted = useRef(false);
  //   console.log(refContainer);
  useEffect(() => {
    refContainer.current.focus();
    if (!isMounted.current) {
      isMounted.current = true;
    }
    console.log("re-render"); //everytime if the value changes the rerender is consoled
  }, [value]);
  const handleSubmit = (e) => {
    e.preventDefault();
    const name = refContainer.current.value;
    console.log(name);
  };
  return (
    <div>
      <form onSubmit={handleSubmit}>
        <h2>UseRef Hook</h2>
        <label htmlFor="name">Name</label>
        <input type="text" name="name" ref={refContainer} />
        <button type="submit">Submit</button>
      </form>
      <h1>Value : {value}</h1>
      <button onClick={() => setValue(value + 1)}>Increase</button>
    </div>
  );
};
