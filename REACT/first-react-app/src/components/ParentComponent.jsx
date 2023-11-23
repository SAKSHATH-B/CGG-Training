import { ChildComponent } from "./ChildComponent";

const ParentComponent = () => {
  const greetParent = (childName) => {
    alert(`Hello Parent ${childName}`);
  };
  return <ChildComponent greetHandler={greetParent} />;
};

export default ParentComponent;
