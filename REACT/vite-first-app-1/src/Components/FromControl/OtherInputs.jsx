import React, { useState } from "react";
const frameworks = ["react", "angular", "vue", "node"];

export const OtherInputs = () => {
  const [shipping, setShipping] = useState(false);
  const [framework, setFramework] = useState("react");

  const handleShipping = (e) => {
    // console.log(e.target.checked);
    setShipping(e.target.checked);
  };
  const handleFramework = (e) => {
    setFramework(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(shipping, framework);
  };

  return (
    <div>
      <form className="form" onSubmit={handleSubmit}>
        <h4>Other Inputs</h4>
        <div className="form-row">
          <label htmlFor="shipping" className="form-label">
            Free Shipping
          </label>
          <input
            type="checkbox"
            className="form-input"
            onChange={handleShipping}
            checked={shipping}
          />
        </div>
        <div className="form-row">
          <label htmlFor="framework" className="form-label">
            FrameWork
          </label>
          <select value={framework} onChange={handleFramework}>
            {frameworks.map((framework) => {
              return <option key={framework}>{framework}</option>;
            })}
          </select>
        </div>

        <button type="submit" className="btn btn-block">
          Submit
        </button>
      </form>
    </div>
  );
};
