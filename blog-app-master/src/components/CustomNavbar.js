import React, { useState ,useEffect} from 'react'
import { NavLink as ReactLink, useNavigate } from 'react-router-dom'
import {
    Collapse,
    Navbar,
    NavbarToggler,
    NavbarBrand,
    Nav,
    NavItem,
    NavLink,
    UncontrolledDropdown,
    DropdownToggle,
    DropdownMenu,
    DropdownItem,
    NavbarText,
  } from 'reactstrap'
import { doLogout, getCurrentUserDetails, isLoggedIn } from '../auth'
import { toast } from 'react-toastify'
export const CustomNavbar = () => {
    const [isOpen,setIsOpen]=useState(false)
    const [login,setLogin]=useState(false)
    const [user,setUser]= useState(undefined)
    const navigate=useNavigate()
    useEffect(()=>{
       setLogin(isLoggedIn())
       setUser(getCurrentUserDetails())
       
    },[login])
    
    const logout=()=>{
      doLogout(()=>{
        //logged out
        setLogin(false)
        toast.success('Logged out Successfully')
        navigate('/')
      })
    }
    return (
        <div>
        <Navbar color='dark' dark expand="md" >
        <NavbarBrand tag={ReactLink} to="/">MyBlog</NavbarBrand>
        <NavbarToggler onClick={()=>setIsOpen(!isOpen)}/>
        <Collapse isOpen={isOpen} navbar>
          <Nav className="me-auto" navbar>
            <NavItem>
              <NavLink tag={ReactLink} to="/about">New Feed</NavLink>
            </NavItem>
            <NavItem>
              <NavLink tag={ReactLink} to="/about">About</NavLink>
            </NavItem>
            <NavItem>
              <NavLink tag={ReactLink} to="/services">Services</NavLink>
            </NavItem>
            
            <UncontrolledDropdown nav inNavbar>
              <DropdownToggle nav caret>
               More
              </DropdownToggle>
              <DropdownMenu end>
                <DropdownItem>Contact Us</DropdownItem>
                <DropdownItem divider />
                <DropdownItem>Youtube</DropdownItem>
                <DropdownItem>Linked</DropdownItem>
                <DropdownItem>Facebook</DropdownItem>
              </DropdownMenu>
            </UncontrolledDropdown>
          </Nav>
          <Nav navbar>
           {
             !login &&(
              <>
              <NavItem>
              <NavLink tag={ReactLink} to="/login">
                Login
              </NavLink>
            </NavItem>
            <NavItem>
              <NavLink tag={ReactLink} to="/signup">
                Signup
              </NavLink>
            </NavItem>
            </>
             )
           }
           {
            login&&(
              <>
              <NavItem>
              <NavLink tag={ReactLink} to="/user/profile-info">
                Profile Info
              </NavLink>
            </NavItem>
            <NavItem>
              <NavLink tag={ReactLink} to="/user/dashboard">
                {user.email}
              </NavLink>
            </NavItem>
            <NavItem>
              <NavLink onClick={logout}>
                Logout
              </NavLink>
            </NavItem>
            </>
              
            )
           }

          </Nav>
          
        </Collapse>
      </Navbar>
        </div>
    )
}
