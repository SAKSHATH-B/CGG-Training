import React from "react";
import { Link, Outlet, useSearchParams } from "react-router-dom";

export const Users = () => {
  const [searchParams, setSearchParams] = useSearchParams();
  const showActiveUsers = searchParams.get("filter") === "active";
  return (
    <div>
      <h5>
        <Link to="1">User 1</Link>
      </h5>
      <h5>
        <Link to="2">User 2</Link>
      </h5>
      <h5>
        <Link to="3">User 3</Link>
      </h5>
      <h5>
        <Link to="admin">Admin</Link>
      </h5>

      <Outlet />
      <button onClick={() => setSearchParams({ filter: "active" })}>
        Active Users
      </button>
      <button onClick={() => setSearchParams({})}>Reset Filter</button>
      {showActiveUsers ? (
        <h2>Showing Active Users</h2>
      ) : (
        <h2>Showing all users</h2>
      )}
    </div>
  );
};
