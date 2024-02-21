import { myAxios, privateAxios } from "./helper";
export const loadAllCategories = () => {
  console.log("This is category service running");
  return privateAxios.get("/categories/").then((response) => {
    console.log(response);
    return response.data;
  });
};
