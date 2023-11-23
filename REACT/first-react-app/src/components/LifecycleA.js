import React, { Component } from "react";
import LifecycleB from "./LifecycleB";

export default class LifecycleA extends Component {
  constructor(props) {
    super(props);

    this.state = {
      name: "CGG",
    };
    console.log("LifeCycle A Constructor");
  }

  static getDerivedStateFromProps(props, state) {
    console.log("LifeCycle A getDerivedStateFromProps");
    return null;
    //we should return new state or null
  }

  componentDidMount() {
    console.log("LifeCycle A ComponentDidMount");
  }

  shouldComponentUpdate() {
    console.log("LifeCycle A shouldComponentUpdate");
    return true;
    //if false it will not be updated
  }
  getSnapshotBeforeUpdate(prevProps, prevState) {
    console.log("LifeCycle A getSnapshotBeforeUpdate");
    return null;
    //it should return a null or a value
  }

  componentDidUpdate() {
    console.log("LifeCycle A componentDidUpdate");
  }

  changeState = () => {
    this.setState({
      name: "Welcome",
    });
  };

  render() {
    console.log("LifeCycle A render");
    return (
      <div>
        <div>LifecycleA</div>
        <button onClick={this.changeState}>Change State</button>
        <LifecycleB />
      </div>
    );
  }
}
