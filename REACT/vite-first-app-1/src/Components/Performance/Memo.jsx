import React, { useCallback, useMemo } from "react";
import { useState } from "react";
import { UseStateArrayData } from "../UseStateArrayData";
import MemoList from "./MemoList";
import { slowFunction } from "./slowFunction";

export const Memo = () => {
  const [people, setPeople] = useState(UseStateArrayData);

  const [count, setCount] = useState(0);

  const value = useMemo(() => slowFunction(), []);
  console.log(value);

  const removePerson = useCallback(
    (id) => {
      const newPeople = people.filter((person) => person.id !== id);
      setPeople(newPeople);
    },
    [people]
  );

  return (
    <div>
      <button onClick={() => setCount(count + 1)}>Count {count}</button>
      <MemoList people={people} removePerson={removePerson} />
    </div>
  );
};
