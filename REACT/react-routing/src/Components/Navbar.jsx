import React from "react";
import { NavLink } from "react-router-dom";

export const Navbar = () => {
  const navStyling = ({ isActive }) => {
    return {
      fontWeight: isActive ? "bold" : "normal",
      textDecoration: isActive ? "none" : "underline",
    };
  };
  return (
    <nav>
      <NavLink to="/" className="primaryNav" style={navStyling}>
        Home
      </NavLink>
      <NavLink to="/about" style={navStyling}>
        About
      </NavLink>
      <NavLink to="/products">Products</NavLink>
    </nav>
  );
};
