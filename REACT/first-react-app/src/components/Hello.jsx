import React from "react";

export const Hello = () => {
  return (
    // <div id='hello' className='dummyClass'>
    //   <h1>Hello Participants</h1>
    // </div>

    React.createElement(
      "div",
      { id: "hello", className: "dummyClass" },
      React.createElement("h1", null, "Hellll")
    )
  );
};
