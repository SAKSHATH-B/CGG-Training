import React from "react";
import { useState } from "react";

export const UserChallenge = () => {
  const [user, setUser] = useState(null);

  const login = () => {
    setUser({ name: "Anonymous User" });
  };
  const logout = () => {
    setUser(null);
  };

  return (
    <div>
      {user ? (
        <div>
          <h4>Hello User, {user.name}</h4>
          <button className="btn" onClick={logout}>
            LogOut
          </button>
        </div>
      ) : (
        <div>
          <h4>Please Login</h4>
          <button className="btn" onClick={login}>
            Login
          </button>
        </div>
      )}
    </div>
  );
};
