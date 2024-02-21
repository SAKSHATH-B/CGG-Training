import { myAxios, myPrivateAxios } from "./helper";
export const loadingAllCategories = () => {
  console.log("This is category service running");
  return myPrivateAxios.get("/categories/").then((response) => {
    console.log(response);
    return response.data;
  });
};
