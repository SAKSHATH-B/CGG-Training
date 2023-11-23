import axios from "axios";
import React, { Component } from "react";

export default class PostFormAxios extends Component {
  constructor(props) {
    super(props);

    this.state = {
      userId: "",
      title: "",
      body: "",
    };
  }

  changeHandler = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  };

  submitHandler = (e) => {
    e.preventDefault();
    axios
      .post("https://jsonplaceholder.typicode.com/posts", this.state)
      .then((response) => console.log(response.data))
      .catch((err) => console.log(err));
  };

  render() {
    const { userId, title, body } = this.state;
    return (
      <form onSubmit={this.submitHandler}>
        <div>
          <input
            type="text"
            placeholder="user Id"
            name="userId"
            value={userId}
            onChange={this.changeHandler}
          />
          <input
            type="text"
            placeholder="title"
            name="title"
            value={title}
            onChange={this.changeHandler}
          />
          <input
            type="text"
            placeholder="description"
            name="body"
            value={body}
            onChange={this.changeHandler}
          />
        </div>
        <div>
          <button>Submit</button>
        </div>
      </form>
    );
  }
}
