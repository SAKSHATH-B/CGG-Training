import React, { Component } from "react";

export default class LifecycleB extends Component {
  constructor(props) {
    super(props);

    this.state = {
      name: "CGG",
    };
    console.log("LifeCycle B Constructor");
  }

  static getDerivedStateFromProps(props, state) {
    console.log("LifeCycle B getDerivedStateFromProps");
    return null;
    //we should return new state or null
  }

  componentDidMount() {
    console.log("LifeCycle B ComponentDidMount");
  }

  render() {
    console.log("LifeCycle B render");
    return <div>LifecycleB</div>;
  }
}
