// function one(call_two){
//     console.log('step1')
//     call_two()
// }
// function two(){
//     console.log('step2')
// }
// one(two)


//ice-cream business

let stocks = {
    fruits : ['Strawberry','banana','grapes','apple'],
    liquid : ['water','ice'],
    holder : ['cone','cup','stick'],
    toppings : ['chocolate','peanuts']
}



// let order = (Fruit_name,call_production)=>{
    
//     setTimeout(()=>{
//         console.log(`${stocks.fruits[Fruit_name]} was selected`)
//         call_production()
    
//     },2000)

// }

// //callback hell
// let production = ()=>{
//     setTimeout(()=>{
//         console.log("Production has started")
        
//         setTimeout(()=>{
//             console.log('The food has been chopped')

//             setTimeout(()=>{
//                 console.log(`${stocks.liquid[0]} and ${stocks.liquid[1]} was added`)

//                 setTimeout(()=>{
//                     console.log("Machine has been started")

//                     setTimeout(()=>{
//                         console.log(`${stocks.holder[0]} was selected`)

//                         setTimeout(()=>{
//                             console.log(`${stocks.toppings[0]} was added`)

//                             setTimeout(()=>{
//                                 console.log("Serve Ice Cream")
//                             },2000)
//                         },3000)
//                     },2000)
//                 },1000)
//             },1000)
//         },2000)
//     },0)
// }

// order(0,production)

//PROMISES

// let is_shop_open = true

// let order = (time,work)=>{
//     return new Promise( (resolve,reject)=>{

//         if(is_shop_open){
//             setTimeout(()=>{
//                 resolve(work())
//             },time)
            
//         }
//         else{
//             reject(console.log('our shop is closed'))
//         }
//     } )
// }

// order(2000,()=>console.log(`${stocks.fruits[0]} was selected`))

// .then(()=>{
//     return order(0,()=>console.log("Production has started"))
// })

// .then(()=>{
//     return order(2000,()=>console.log("The fruit was chopped"))
// })

// .then(()=>{
//     return order(1000,()=>console.log(`${stocks.liquid[0]} and ${stocks.liquid[1]} was added`))
// })

// .then(()=>{
//     return order(1000,()=>console.log("Machine has been started"))
// })

// .then(()=>{
//     return order(2000,()=>console.log(`${stocks.holder[0]} was selected`))
// })

// .then(()=>{
//     return order(3000,()=>console.log(`${stocks.toppings[0]} was added`))
// })

// .then(()=>{
//     return order(2000,()=>console.log("Serve Ice Cream"))
// })

// .catch(()=>console.log('customer left'))

// .finally(()=>console.log('Day ended, shop is closed'))


//async

let is_shop_open = true

// let toppings_choice = ()=>{
//     return new Promise((resolve,reject)=>{
//         setTimeout(()=>{
//             resolve(console.log('Which toppings would you love?'))
//         },3000)
//     })
// }

// async function kitchen(){
//     console.log('A')
//     console.log('B')
//     console.log('C')

//     await toppings_choice()

//     console.log('D')
//     console.log('E')
// }

// kitchen()
// console.log("Doing the Dishes")
// console.log("Cleaning the table")
// console.log("Taking others orders")

function time(ms){
    return new Promise((resolve,reject)=>{
        if(is_shop_open){
            setTimeout(resolve,ms)
        }
        else{
            reject(console.log("Shop is Closed"))
        }
    })
}

async function kitchen(){
    try{
        await time(2000)
        console.log(`${stocks.fruits[0]}`)

        await time(0)
        console.log("start the production")
    }
    catch(error){
        console.log("customer left",error)
    }
    finally{
        console.log("Day ended, shop is closed")
    }
}

kitchen()