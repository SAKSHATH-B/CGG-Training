import React from "react";

export const Header = ({ name, title }) => {
  return (
    <div
      style={{
        background: "lightgreen",
        padding: "20px",
        width: "400px",
        margin: "auto",
      }}
    >
      <h1>{title}</h1>
      <h1>{name}</h1>
      <p>This is my first project in react</p>
    </div>
  );
};
