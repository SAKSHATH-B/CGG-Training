$(document).ready(()=>{
    $('#id1').click(()=>{
        // $('#container').show()
        // $('#container').fadeOut(2000)
        $('#container').fadeOut(2000,()=>alert('gone...'))
    })
    $('#id2').click(()=>{
        // $('#container').hide()
        $('#container').fadeIn(2000)
    })
    $('#id3').click(()=>{
        $('#container').fadeToggle()
    })
    $('#id4').click(()=>{
        $('#container').fadeTo(250,0.5)
    })



//----------------slide down,slide up,slide toggle-------------

    $('#id5').click(()=>{
        $('#container').slideDown(100)
    })
    $('#id6').click(()=>{
        $('#container').slideUp()
    })
    $('#id7').click(()=>{
        $('#container').slideToggle()
    })

//-------------animate-------------
//animate({params},speed,callback)

    $('#id8').click(()=>{
        $('#container').animate({width:'200',height:'200',opacity:'0.5',left:'250'},2000,()=>{
            $('#container').animate({borderRadius:'20',left:'0',width:'100',height:'100',opacity:1})
        })
    })

//////////

    $('#id9').click(()=>{
        //val
        // let v = $('#f').val()
        // console.log('Value is '+v)
        // $('#f').val('this is done using val function')

        //text
        let c = $('#content').text()
        console.log(c)
        $('#content').text('<b>this is new content by text()</b>')

        //html()
        $('#content').html('<b>this is new content by html()</b>')

        let s = $('.image').attr('src')
        console.log(s)
        $('.image').attr('src','https://imgs.search.brave.com/cu9Tj1j9X3ikCtsd7VDLKwbzrduMU4kQnzqpbvLIjtU/rs:fit:500:0:0/g:ce/aHR0cHM6Ly9idXJz/dC5zaG9waWZ5Y2Ru/LmNvbS9waG90b3Mv/YS1kcm9wLW9mLXBp/bmstYW5kLXllbGxv/dy1wYWludC1pbi13/YXRlci5qcGc_d2lk/dGg9MTAwMCZmb3Jt/YXQ9cGpwZyZleGlm/PTAmaXB0Yz0w')
    })


    // $('#box').on('click',function(){
    //     console.log(this)
    //     $(this).css('background','orange')
    // })

    // $('#box').on('mouseover mouseout',()=>{
    //     $('#box').toggleClass('boxbg')
    // })

    $('#box').on({
        'click':()=>{
            $('#box').css('background','orange')
        },
        'mouseover':()=>{
            $('#box').css('background','green')
        },
        'mouseout':()=>{
            $('#box').css('background','blue')
        }
    })

    $('#new').click(()=>{
        $('#box').off('mouseover mouseout')
    })

})