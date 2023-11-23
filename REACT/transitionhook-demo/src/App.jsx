import { useState, useTransition } from "react";
import "./App.css";
import NAMES from "./Components/data.json";

function App() {
  const [query, setQuery] = useState("");
  const [inputValue, setInputValue] = useState("");
  const [isPending, startTransition] = useTransition();
  const changeHandler = (e) => {
    setInputValue(e.target.value);
    startTransition(() => setQuery(e.target.value));
  };
  const filteredNames = NAMES.filter(
    (item) => item.first_name.includes(query) || item.last_name.includes(query)
  );
  return (
    <div>
      <input type="text" value={inputValue} onChange={changeHandler} />
      {isPending && <p>Updating List...</p>}
      {filteredNames.map((item) => (
        <p key={item.id}>
          {item.first_name} {item.last_name}
        </p>
      ))}
    </div>
  );
}

export default App;
