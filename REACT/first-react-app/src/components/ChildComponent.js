export const ChildComponent = ({ greetHandler }) => {
  return (
    <button onClick={() => greetHandler("I am Child")}>Greet Parent</button>
  );
};
