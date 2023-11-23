import React, { useState } from "react";

export const UseStateObject = () => {
  const [person, setPerson] = useState({
    name: "Sakshath",
    age: 20,
    enjoys: "Riding Continental GT 650",
  });
  //   const [name, setName] = useState("Sakshath");
  //   const [age, setAge] = useState(22);
  //   const [enjoys, setEnjoys] = useState("Watching Cricket");

  const btnHandler = () => {
    // setName("Dinakar");
    // setAge(30);
    // setEnjoys("Watching Movies");
    // setPerson({ name: "Dinakaru", age: 30, enjoys: "Coding in React" });
    setPerson({ ...person, name: "Dinakare" });
  };
  return (
    <div>
      <h1>{person.name}</h1>
      <h3>{person.age}</h3>
      <h2>Enjoys : {person.enjoys}</h2>
      <button onClick={btnHandler}>Change</button>
    </div>
  );
};
