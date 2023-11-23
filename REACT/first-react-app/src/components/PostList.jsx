import React, { useEffect, useState } from "react";

export const PostList = () => {
  const [posts, setPosts] = useState([]);
  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/posts/1")
      .then((resopnse) => {
        console.log(resopnse);
        return resopnse.json();
      })
      .then((data) => setPosts(data))
      .catch((err) => console.log(err));
  }, []);
  return (
    <div>
      POSTLIST
      <ul>
        {posts.map((post) => (
          <li key={post.id}>{post.title}</li>
        ))}
      </ul>
    </div>
  );
};
