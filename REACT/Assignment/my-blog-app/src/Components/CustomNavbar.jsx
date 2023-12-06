import React, { useContext, useEffect, useState } from "react";
import { NavLink as ReactLink, useNavigate } from "react-router-dom";
import {
  Navbar,
  NavbarBrand,
  NavbarToggler,
  Collapse,
  Nav,
  NavItem,
  NavLink,
  UncontrolledDropdown,
  DropdownToggle,
  DropdownMenu,
  DropdownItem,
} from "reactstrap";
import { doLogout, getCurrentUserDetail, isLoggedIn } from "../auth";
import { userContext } from "../context/userContext";

const CustomNavbar = () => {
  const userContextData = useContext(userContext);

  const [isOpen, setIsOpen] = useState(false);
  const [login, setLogin] = useState(false);
  const [user, setUser] = useState(undefined);
  const navigate = useNavigate();

  useEffect(() => {
    setLogin(isLoggedIn);
    setUser(getCurrentUserDetail());
  }, [login]);

  const logout = () => {
    doLogout(() => {
      setLogin(false);
      userContextData.setUser({
        data: null,
        login: false,
      });
      navigate("/");
    });
  };

  return (
    <div>
      <Navbar color="dark" dark expand="md" fixed=" " className="px-5">
        <NavbarBrand tag={ReactLink} to="/">
          MyBlogs
        </NavbarBrand>
        <NavbarToggler onClick={() => setIsOpen(!isOpen)} />
        <Collapse isOpen={isOpen} navbar>
          <Nav className="me-auto" navbar>
            <NavItem>
              <NavLink tag={ReactLink} to="/">
                New Feed
              </NavLink>
            </NavItem>
            <NavItem>
              <NavLink tag={ReactLink} to="/About/">
                About
              </NavLink>
            </NavItem>
            <NavItem>
              <NavLink tag={ReactLink} to="/Services/">
                Services
              </NavLink>
            </NavItem>

            <UncontrolledDropdown nav inNavbar>
              <DropdownToggle nav caret>
                More
              </DropdownToggle>
              <DropdownMenu right>
                <DropdownItem tag={ReactLink} to="/Services">
                  Contact Us
                </DropdownItem>
                <DropdownItem>Facebook</DropdownItem>
                <DropdownItem divider />
                <DropdownItem>Youtube</DropdownItem>
                <DropdownItem>Instagram</DropdownItem>
                <DropdownItem>Linkedin</DropdownItem>
              </DropdownMenu>
            </UncontrolledDropdown>
          </Nav>
          <Nav navbar>
            {login && (
              <>
                <NavItem>
                  <NavLink tag={ReactLink} to="/user/Profileinfo">
                    Profile Info
                  </NavLink>
                </NavItem>

                <NavItem>
                  <NavLink tag={ReactLink} to="/user/dashboard">
                    {user.email}
                  </NavLink>
                </NavItem>
                <NavItem>
                  <NavLink onClick={logout}>Logout</NavLink>
                </NavItem>
              </>
            )}
            {!login && (
              <>
                <NavItem>
                  <NavLink tag={ReactLink} to="/Login">
                    Login
                  </NavLink>
                </NavItem>
                <NavItem>
                  <NavLink tag={ReactLink} to="/Signup">
                    Signup
                  </NavLink>
                </NavItem>
              </>
            )}
          </Nav>
        </Collapse>
      </Navbar>
    </div>
  );
};

export default CustomNavbar;
