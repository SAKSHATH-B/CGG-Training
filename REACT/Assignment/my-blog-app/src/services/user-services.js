import { myAxios } from "./helper";

export const signUp = (user) => {
  return myAxios.post("/auth/register", user).then((res) => res.data);
};

export const userLogin = (login) => {
  return myAxios.post("/auth/login", login).then((res) => res.data);
};

export const getUser = (userId) => {
  return myAxios.get(`/users/${userId}`).then((res) => res.data);
};
