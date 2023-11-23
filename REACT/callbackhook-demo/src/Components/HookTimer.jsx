import React, { useEffect, useRef, useState } from "react";

const HookTimer = () => {
  const [timer, setTimer] = useState(0);
  const intervalRef = useRef();
  useEffect(() => {
    intervalRef.current = setInterval(() => {
      setTimer((prev) => prev + 1);
    }, 1000);

    return () => {
      clearInterval(intervalRef.current);
    };
  }, []);
  return (
    <div>
      {timer}{" "}
      <button
        onClick={() => {
          clearInterval(intervalRef.current);
        }}
      >
        clearTimer
      </button>
    </div>
  );
};

export default HookTimer;

//useRef -- it acts as a container to store the current value
//when there is a rerender there is no change in value
//when there is a chane in value there will be no rerender
