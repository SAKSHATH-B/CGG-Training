document.write('<code>The actual script is in external script file called "Hello.js"</code><hr>')

function dispHello(){
    return '<code>This text is displayed by calling external function : <strong>Hello World</strong></code>'
}

document.write(dispHello())