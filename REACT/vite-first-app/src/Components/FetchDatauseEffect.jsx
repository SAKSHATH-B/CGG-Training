import React from "react";
import { useEffect, useState } from "react";

export const FetchDatauseEffect = () => {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    fetch("https://api.github.com/users")
      .then((res) => res.json())
      .then((res) => setUsers(res))
      .catch((err) => console.log(err));
  }, []);
  return (
    <div>
      <h1>Fetch Data Example</h1>
      <h2>Github Users</h2>

      {users.map((item) => (
        <div key={item.id} style={{ display: "flex" }}>
          <img src={item.avatar_url} alt="" />
          <div>
            <h3>{item.login}</h3>
            <a href={item.html_url}>Profile</a>
          </div>
        </div>
      ))}
    </div>
  );
};
