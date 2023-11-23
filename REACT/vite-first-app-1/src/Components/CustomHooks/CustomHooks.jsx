import { useToggle } from "./useToggle";

export const CustomHooks = () => {
  const { show, toggle } = useToggle(false);
  return (
    <div>
      <h4>Toggle Custom Hook</h4>
      <button onClick={toggle}>Toggle</button>
      {show && <h4>Hello World</h4>}
    </div>
  );
};

//use the same functionality in many components -- push the similar functionality to another file and import in the file to use the logic
