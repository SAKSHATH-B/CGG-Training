import React from 'react'
import {Base} from '../Base'
export const Home = ({courseName,duration,children}) => {
    return (
        <div>
            <Base>
            <h1>This is home page {courseName}</h1>
            <h2>Duration is {duration}</h2>
             {children}
             </Base>
        </div>
    )
}
