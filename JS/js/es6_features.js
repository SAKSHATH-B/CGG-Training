console.log('new features of js')
console.log('this is second line')

//default parameters
const sum = (x=1,y=2) => x+y
console.log(sum(2,3))
console.log(sum())

//array destructuring
const myArr = [23,34]
// let x = myArr[0]
// let y = myArr[1]

let [x,y] = myArr
console.log(x)
console.log(y)

//object destructuring
const ob = {
    name : 'js',
    dbName : 'mongodb'
}
let{name,dbName} = ob
console.log(name)
console.log(dbName)

let myarr = [23,34,45,56,67,77]
let [a,b,...rest] = myarr
console.log(a)
console.log(b)
console.log(rest)

//enhanced object literals
let name1='abs',city='hyd',active = 'dkd'

let student = {
    name1,city,[active]:true,
    display(){
        console.log(this.name1)
        console.log(this.city)
    }
}
console.log(student)
student.display()

function obj(a,b,c){
    return {a,b,c}
}
let obj1 = obj(2,3,4)
console.log(obj1)


//promise in js
//promise is used with asynchronous operation
//promise is an object that represents eventual completion or failure

let prom = new Promise((resolve,reject)=>{
    //server call - asynchronous work
    //time taking

    let flag = true
    setTimeout(()=>{
        if(flag){
            resolve()
        }
        else{
            reject()
        }
    },5000)
})


console.log('First line after promise')
console.log('Second line after promise')
console.log('Third line after promise')
console.log('Fourth line after promise')

prom.then(()=>{
    console.log('promise is resolved')
}).catch(()=>{
    console.log('promise is rejected')
})


//spread operator

// const per = {...text,..."test",...10}
// console.log(per)

const n = [1,2,3,4]
const per2 = {...n}
console.log(n)


const datearr = [2023,9,1]
let date =new Date(...datearr)
console.log(date)

const parts = ['shoulders','knees']
const lyrics = ['head',...parts,'and','toes']
console.log(lyrics)

const marr = [1,2,3]
const marr2 = [...marr]
console.log(marr2)
marr2.push(4)
console.log(marr)
console.log(marr2)

const marr3 = [[1],[2],[3]]
const marr4 = [...marr3]
console.log(marr4)

marr3.shift().shift()
console.log(marr3)
console.log(marr4)


const m1 = {foo:'sks',x:53}
const m2 = {bar:'aka',y:55}
// const m2 = {foo:'aka',y:55}

const merge = {...m1,x:55, ...m2 , y:9}
console.log(merge)


const isSummer = true;
const fruits = {
    apple:12,banana:13,
    ...(isSummer? {watermelon : 30} : {}),
}
console.log(fruits)