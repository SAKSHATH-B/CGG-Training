import React from "react";
import { useState } from "react";
import { UseStateArrayData } from "../UseStateArrayData";
import MemoList from "./MemoList";

export const Memo = () => {
  const [people, setPeople] = useState(UseStateArrayData);

  const [count, setCount] = useState(0);
  const removePerson = (id) => {
    const newPeople = people.filter((person) => person.id !== id);
    setPeople(newPeople);
  };

  return (
    <div>
      <button onClick={() => setCount(count + 1)}>Count {count}</button>
      <MemoList people={people} removePerson={removePerson} />
    </div>
  );
};
