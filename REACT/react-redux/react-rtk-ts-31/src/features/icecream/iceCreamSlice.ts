import { ordered as cakeOrdered } from "../cake/cakeSlice";

import { createSlice, PayloadAction } from "@reduxjs/toolkit";

type InitialState = {
  numOfIceCreams: number;
};

const initialState: InitialState = {
  numOfIceCreams: 20,
};

const iceCreamSlice = createSlice({
  name: "IceCream",
  initialState,
  reducers: {
    ordered: (state) => {
      state.numOfIceCreams--;
    },
    restocked: (state, action: PayloadAction<number>) => {
      state.numOfIceCreams += action.payload;
    },
  },
  //   extraReducers: {
  //     ["cake/ordered"]: (state) => {
  //       state.numOfIceCreams--;
  //     },
  //   },
  extraReducers: (builder) => {
    builder.addCase(cakeOrdered, (state) => {
      state.numOfIceCreams--;
    });
  },
});

export default iceCreamSlice.reducer;
export const { ordered, restocked } = iceCreamSlice.actions;
