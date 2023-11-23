import React, { useState } from "react";

const Form = () => {
  const [username, setUsername] = useState("");
  const submitHandler = (e) => {
    e.preventDefault();
    alert(`Welcome ${username} ${selectedOption} ${selectedBike} ${country}`);
  };

  const [selectedOption, setSelectedOption] = useState("male");
  const [selectedBike, setSelectedBike] = useState([
    "gt650",
    "vitplen",
    "hunter",
  ]);
  const [country, setCountry] = useState("");

  const changeCheckBoxHandler = (e) => {
    e.target.checked
      ? setSelectedBike([...selectedBike, e.target.value])
      : setSelectedBike(selectedBike.filter((i) => i !== e.target.value));
  };

  return (
    <div>
      <form onSubmit={submitHandler}>
        <div>
          <label htmlFor="">Username </label>
          <input
            type="text"
            onChange={(e) => {
              setUsername(e.target.value);
              // console.log(e.target.value)
            }}
          />
        </div>
        <div>
          <label htmlFor="">Gender </label>
          <input
            type="radio"
            name="gender"
            value="male"
            checked={selectedOption === "male"}
            onChange={(e) => setSelectedOption(e.target.value)}
          />
          Male
          <input
            type="radio"
            name="gender"
            value="female"
            checked={selectedOption === "female"}
            onChange={(e) => setSelectedOption(e.target.value)}
          />
          Female
        </div>
        <div>
          <label htmlFor="">Bikes </label>
          <input
            type="checkbox"
            value="gt650"
            checked={selectedBike.indexOf("gt650") !== -1 ? true : false}
            onChange={changeCheckBoxHandler}
          />
          Continental GT 650
          <input
            type="checkbox"
            value="vitplen"
            checked={selectedBike.indexOf("vitplen") !== -1 ? true : false}
            onChange={changeCheckBoxHandler}
          />
          Husqvarna Vitplen
          <input
            type="checkbox"
            value="hunter"
            checked={selectedBike.indexOf("hunter") !== -1 ? true : false}
            onChange={changeCheckBoxHandler}
          />
          Hunter 350
        </div>
        <div>
          <label htmlFor="">Select Country</label>
          <select value={country} onChange={(e) => setCountry(e.target.value)}>
            <option value="" hidden>
              ----Select Country----
            </option>
            <option value="abc">ABC</option>
            <option value="pqr">PQR</option>
            <option value="xyz">XYZ</option>
          </select>
        </div>
        <button>Submit</button>
      </form>
    </div>
  );
};

export default Form;
