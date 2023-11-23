import React, { useState } from "react";

export const UnControlledInputs = () => {
  const handleSubmit = (e) => {
    e.preventDefault();
    const formData = new FormData(e.currentTarget);
    // console.log(formData);
    // const name = formData.get("password");
    // console.log([...formData.entries()]);
    const newUser = Object.fromEntries(formData);
    console.log(newUser);

    e.currentTarget.reset(); //clears all the input fields
  };
  return (
    <form onSubmit={handleSubmit}>
      <h4>FormData API</h4>
      <div>
        <label htmlFor="name">Name</label>
        <input type="text" id="name" name="name" />
      </div>
      <div>
        <label htmlFor="email">email</label>
        <input type="email" id="email" name="email" />
      </div>
      <div>
        <label htmlFor="password">password</label>
        <input type="password" id="password" name="password" />
      </div>
      <button type="submit">Submit</button>
    </form>
  );
};
