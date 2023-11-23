import React, { useState } from "react";

export const FormMultipleInputs = () => {
  const [user, setUser] = useState({
    name: "",
    email: "",
    password: "",
  });

  const handleChange = (e) => {
    // console.log(e.target.name);
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(user);
  };

  return (
    <div>
      <form className="form" onSubmit={handleSubmit}>
        <h4>Multiple Inputs</h4>
        <div className="form-row">
          <label htmlFor="name" className="form-label">
            Name
          </label>
          <input
            type="text"
            className="form-input"
            value={user.name}
            onChange={handleChange}
            name="name"
          />
        </div>
        <div className="form-row">
          <label htmlFor="email" className="form-label">
            Email
          </label>
          <input
            type="email"
            className="form-input"
            value={user.email}
            onChange={handleChange}
            name="email"
          />
        </div>
        <div className="form-row">
          <label htmlFor="password" className="form-label">
            Password
          </label>
          <input
            type="password"
            className="form-input"
            value={user.password}
            onChange={handleChange}
            name="password"
          />
        </div>
        <button type="submit" className="btn btn-block">
          Submit
        </button>
      </form>
    </div>
  );
};
