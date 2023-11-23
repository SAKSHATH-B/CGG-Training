////////////////know more about arrow functions
//to use this function in another file use export default to normal function and export to arrow function

// import { Button } from "bootstrap"

//normal function
// export default function hel(){

// }

//arrow function
// export const func = ()=>{}


//////////////working with ternary operators

let x = 10
let n = x > 10 ? "pedro" : "jack"
console.log(n)

//normal if..else
// if(age>10){
//     name = 'pedro'
// }else{
//     name = 'jack'
// }


// const component = ()=>{
//     return age>10 ? '<div>Pedro</div>' : '<div>Jack</div>'
// }


//////////////////objects in js

// const name = "pedro"
// const age = 20
const person = {
    // name,
    // age,
    name : "pedro",
    age : 20,
    isMarried:false,
}

// const name = person.name
// const age = person.age
// const married = person.isMarried

// const {a,b,c} = person

const person2 = {...person,name:"jack"}

console.log(person2)

//map,filter,reduce functions
let names = ["pedro","Jessica","carol","pedro","pedro"]

// names.map((name)=>{
//     return '<h1>{name}</h1>'
// })

const s = names.filter((name)=>{
    return name !== "pedro"
})
console.log(s)


////Async Await Fetch Promises

// fetch

