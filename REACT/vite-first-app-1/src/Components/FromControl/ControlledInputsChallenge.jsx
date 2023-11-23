import React, { useState } from "react";
import { UseStateArrayData } from "../UseStateArrayData";

export const ControlledInputsChallenge = () => {
  const [name, setName] = useState("");
  const [users, setUsers] = useState(UseStateArrayData);

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!name) return;
    const newUser = { id: 5, name };
    const updatedUsers = [...users, newUser];
    setUsers(updatedUsers);
    setName("");
  };

  const removeUser = (id) => {
    const updatedUsers = users.filter((person) => person.id !== id);
    setUsers(updatedUsers);
  };

  return (
    <div>
      <form className="form" onSubmit={handleSubmit}>
        <h4>Add User</h4>
        <div className="form-row">
          <label htmlFor="name" className="form-label">
            Name
          </label>
          <input
            type="text"
            className="form-input"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
        </div>
        <button type="submit" className="btn btn-block">
          Submit
        </button>
      </form>
      {/* render Users Here */}
      <h4>Users</h4>
      {users.map((user) => {
        return (
          <div>
            <h6 key={user.id}>{user.name}</h6>
            <button onClick={() => removeUser(user.id)} className="btn">
              Remove
            </button>
          </div>
        );
      })}
    </div>
  );
};
