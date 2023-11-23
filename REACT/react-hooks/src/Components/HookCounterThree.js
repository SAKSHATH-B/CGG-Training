import React, { useState } from "react";

export const HookCounterThree = () => {
  const [name, setName] = useState({ firstName: "", lastName: "" });
  return (
    <div>
      <input
        type="text"
        value={name.firstName}
        onChange={(e) => setName({ ...name, firstName: e.target.value })}
      />
      <input
        type="text"
        value={name.lastName}
        onChange={(e) => setName({ ...name, lastName: e.target.value })}
      />
      <h3>your first name is : {name.firstName}</h3>
      <h3>your last name is : {name.lastName}</h3>
      <h2>{JSON.stringify(name)}</h2>
    </div>
  );
};

//we need to spread the data that makes copy to work with functional components which auto merges the data
//no need to use spread operator for class components
//the previous data will be preserved
