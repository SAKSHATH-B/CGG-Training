import React, { Suspense, lazy, useState, useTransition } from "react";
const SlowComponent = lazy(() => import("./SlowComponent"));

export const UseTransition = () => {
  const [text, setText] = useState("");
  const [items, setItems] = useState([]);
  const [show, setShow] = useState(false);

  const [isPending, startTransition] = useTransition();

  const handleChange = (e) => {
    setText(e.target.value);

    //slow down cpu
    startTransition(() => {
      const newItems = Array.from({ length: 5000 }, (_, index) => {
        return (
          <div key={index}>
            <img src="/vite.svg" alt="" />
          </div>
        );
      });
      setItems(newItems);
    });
  };
  return (
    <section>
      <form>
        <input type="text" value={text} onChange={handleChange} />
      </form>
      <h4>Items Below</h4>
      {isPending ? (
        <h4>Loading...</h4>
      ) : (
        <div
          style={{
            display: "grid",
            gridTemplateColumns: "1fr 1fr 1fr",
            marginTop: "2rem",
          }}
        >
          {items}
        </div>
      )}
      <button onClick={() => setShow(!show)}>Toggle</button>
      {show && (
        <Suspense fallback={<h4>Loading...</h4>}>
          <SlowComponent />
        </Suspense>
      )}
    </section>
  );
};
