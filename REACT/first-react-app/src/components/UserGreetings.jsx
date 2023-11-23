export const UserGreetings = () => {
  const isLoggedIn = false;
  return (
    //   <h1>Welcome {isLoggedIn && "ATOS"}</h1>
    <h1>Welcome {isLoggedIn ? "CGG" : ""}</h1>
  );
};
