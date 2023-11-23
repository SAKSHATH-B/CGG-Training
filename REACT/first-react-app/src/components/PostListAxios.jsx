import React, { Component } from "react";
import axios from "axios";

export default class PostListAxios extends Component {
  constructor(props) {
    super(props);

    this.state = {
      posts: [],
      errorMsg: "",
    };
  }

  componentDidMount() {
    axios
      .get("https://jsonplaceholder.typicode.com/posts")
      .then((response) => {
        console.log(response);
        this.setState({ posts: response.data });
      })
      .catch((err) => {
        console.log(err);
        this.setState({ errorMsg: "Error Retreving Data" });
      });
  }
  render() {
    const { posts, errorMsg } = this.state;
    return (
      <div>
        <h2>List of Posts</h2>
        {posts.length
          ? posts.map((post) => <div key={post.id}>{post.title}</div>)
          : null}
        {errorMsg ? errorMsg : null}
      </div>
    );
  }
}
