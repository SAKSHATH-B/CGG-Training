import React, { useState, createContext } from "react";
import NavLinks from "./NavLinks";

export const NavbarContext = createContext();

const Navbar = () => {
  const [user, setUser] = useState({ name: "john" });
  const logout = () => {
    setUser(null);
  };
  return (
    <NavbarContext.Provider value={{ user, logout }}>
      <nav className="navbar">
        <h5>Context API</h5>
        <NavLinks />
      </nav>
    </NavbarContext.Provider>
  );
};

export default Navbar;
