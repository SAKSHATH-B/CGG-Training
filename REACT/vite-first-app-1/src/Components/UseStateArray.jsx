import React, { useState } from "react";
import { UseStateArrayData } from "./UseStateArrayData";

export default function UseStateArray() {
  const [item, setItem] = useState(UseStateArrayData);

  const removeItem = (id) => {
    const newPersons = item.filter((match) => match.id !== id);
    setItem(newPersons);
  };
  return (
    <div>
      {item.map((person) => {
        const { id, name } = person;
        return (
          <div key={id}>
            <h3>{name}</h3>
            <button onClick={() => removeItem(id)}>Remove</button>
          </div>
        );
      })}
      <button onClick={() => setItem([])} style={{ marginTop: "2rem" }}>
        ClearAllItems
      </button>
    </div>
  );
}
