import React, { useState } from "react";
import { UseStateArrayData } from "../UseStateArrayData";
import { User } from "./User";
import { Counter } from "./Counter";

export const PerformanceBasics = () => {
  const [people, setPeople] = useState(UseStateArrayData);

  return (
    <div>
      <Counter />
      <User people={people} />
    </div>
  );
};
