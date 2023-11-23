import { useEffect, useRef, useState } from "react";

export const MutableRef = () => {
  const [timer, setTimer] = useState(0);
  const inputRef = useRef<number | null>(null);

  const stopTimer = () => {
    if (inputRef.current) clearInterval(inputRef.current);
  };
  useEffect(() => {
    inputRef.current = setInterval(() => {
      setTimer((timer) => timer + 1);
    }, 1000);

    return () => stopTimer();
  }, []);
  return (
    <div>
      Timer - {timer}
      <button onClick={() => stopTimer()}>Stop Timer</button>
    </div>
  );
};
