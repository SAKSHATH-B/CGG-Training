import React from "react";
import { buyIceCream } from "../redux/IceCream/iceCreamActions";
import { connect } from "react-redux";

function IceCreamContainer({ numOfIceCreams, buyIceCream }) {
  return (
    <div>
      <h2>Num of IceCreams : {numOfIceCreams}</h2>
      <button onClick={buyIceCream}>Buy IceCream</button>
    </div>
  );
}

const mapStateToPros = (state) => {
  return {
    numOfIceCreams: state.iceCream.numOfIceCreams,
  };
};

const mapDispatchToProps = (dispatch) => {
  return {
    buyIceCream: () => dispatch(buyIceCream()),
  };
};

export default connect(mapStateToPros, mapDispatchToProps)(IceCreamContainer);
