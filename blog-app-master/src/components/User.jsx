import React from 'react'
import { Base } from './Base'
import { Navigate, Outlet } from 'react-router-dom'
import { isLoggedIn } from '../auth'

export const User = () => {
    return (
        <Base>
            {isLoggedIn()?<Outlet/>:<Navigate to='/login'/>}
        </Base>
    )
}
