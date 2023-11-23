import React from "react";

const MemoComp = ({ name }) => {
  console.log("rendering Memo component");
  return <div>{name}</div>;
};

export default React.memo(MemoComp);

//rendering in functional components
//called as Higher order component
//React.memo() add some function to the method
//and returns the enhanced component of the function passed
