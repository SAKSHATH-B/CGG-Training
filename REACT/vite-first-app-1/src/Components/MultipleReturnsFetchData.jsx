import React, { useState, useEffect } from "react";

export const MultipleReturnsFetchData = () => {
  const [isLoading, setIsLoading] = useState(true);
  const [isError, setIsError] = useState(false);
  const [user, setUser] = useState("");

  useEffect(() => {
    fetch("https://api.github.com/users/QuincyLarson")
      .then((res) => res.json(), setIsLoading(false))
      .then((res) => setUser(res))
      .catch(() => setIsError(true));
  }, []);

  const { avatar_url, name, company, bio } = user;
  return (
    <div>
      {isLoading ? (
        <h2>Loading...</h2>
      ) : (
        <>
          <h1>Fetch Data</h1>
          <img src={avatar_url} alt="Image" />
          <h1>{name}</h1>
          <h2>Works At {company}</h2>
          <h3>{bio}</h3>
        </>
      )}
      {isError ? <h2>There is some error</h2> : ""}
    </div>
  );
};
