import React from "react";

export const User = ({ people }) => {
  return (
    <div>
      {people.map((a) => {
        return <h1>{a.name}</h1>;
      })}
    </div>
  );
};
