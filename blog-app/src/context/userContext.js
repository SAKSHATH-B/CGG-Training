import React, { useState } from "react";

export const userContext = React.createContext(({ children }) => {
  const [user, setUser] = useState(undefined);
  return (
    <userContext.Provider value={{ user, setUser }}>
      {children}
    </userContext.Provider>
  );
});

// export const UserContextProvider = ({ children }) => {
//   const [user, setUser] = useState(undefined);
//   return (
//     <userContext.Provider value={{ user, setUser }}>
//       {children}
//     </userContext.Provider>
//   );
// };
