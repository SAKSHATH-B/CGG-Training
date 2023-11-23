import React, { useEffect, useState } from "react";
import { useDocTitle } from "../../hookscustom/useDocTitle";

export const DocTitleOne = () => {
  const [count, setCount] = useState(0);

  useDocTitle(count);
  return (
    <div>
      <button onClick={() => setCount(count + 1)}>Count - {count}</button>
    </div>
  );
};
