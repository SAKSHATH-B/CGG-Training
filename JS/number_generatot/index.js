let Number

const generate_number = ()=>{
    let n1 = Math.trunc(Math.random() * 10)
    n1 = (n1%6)+1
    console.log(n1)
    number = n1
}

//generate number
const generate = ()=>{
    document.querySelector('#section1').style.display = 'none' 
    document.querySelector('#section2').style.display = 'none' 
    document.querySelector('#section3').style.display = 'block'
    
    setTimeout(()=>{
        generate_number()
        document.querySelector('#form').value = ''
        document.querySelector('#section1').style.display = 'none'
        document.querySelector('#section2').style.display = 'block'
        document.querySelector('#section3').style.display = 'none'
        document.querySelector('#form').focus()

    },3000)
}


//check_number
const check_number = ()=>{
    let value = document.querySelector('#form').value
    if(value == number){
        alert('Congrats')
    }
    else{
        alert('Not Correct')
    }
    generate()
}