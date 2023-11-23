import React, { useState } from "react";

export const PostForm = () => {
  const [userid, setUserid] = useState();
  const [title, setTitle] = useState();
  const [desc, setDesc] = useState();

  const submitHandler = (e) => {
    e.preventDefault();
    fetch("https://jsonplaceholder.typicode.com/posts", {
      method: "POST",
      body: JSON.stringify({ userId: userid, title: title, body: desc }),
      headers: { "content-type": "application/json; charset=UTF-8" },
    })
      .then((response) => response.json())
      .then((data) => console.log(data))
      .catch((err) => console.log(err));
  };

  return (
    <form onSubmit={submitHandler}>
      <div>
        <input
          type="text"
          placeholder="Enter the UserID"
          value={userid}
          onChange={(e) => setUserid(e.target.value)}
        />
        <input
          type="text"
          placeholder="Title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />
        <input
          type="text"
          placeholder="Description"
          value={desc}
          onChange={(e) => setDesc(e.target.value)}
        />
      </div>
      <div>
        <button type="submit">Submit</button>
      </div>
    </form>
  );
};
