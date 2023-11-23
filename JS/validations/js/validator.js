// alert('test')        --  test whether file is successfully connected or not

//validation code

function validate() {
  let f = false;

  //validation.....f-true,f-false

  //name-field validation
  let name = $(".name-field").val();
  // console.log(name)
  if (name == "" || name == undefined) {
    $(".name-field-msg").html("Name is required !!").addClass("text-danger");
  } else {
    $(".name-field-msg")
      .html("Ok !!")
      .removeClass("text-danger")
      .addClass("text-success");
    f = true;
  }

  //email validation
  let email = $(".email-field").val();
  // console.log(email)
  let exp = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
  if (email == "" || email == undefined) {
    $(".email-field-msg")
      .html(
        "Invalid Email,email must be in correct format(example@gmail.com) !!"
      )
      .addClass("text-danger");
    f = false;
  } else if (exp.test(email) == false) {
    $(".email-field-msg")
      .html(
        "Invalid Email,email must be in correct format(example@gmail.com) !!"
      )
      .addClass("text-danger");
    f = false;
  } else {
    $(".email-field-msg")
      .html("Ok !!")
      .removeClass("text-danger")
      .addClass("text-success");
    f = true;
  }

  //password validations
  let password = $(".password-field").val();
  // console.log(password)
  let exp1 = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;

  if (password == "" || password == undefined) {
    $(".password-field-msg")
      .html("Password is required !!")
      .addClass("text-danger");
    f = false;
  } else if (exp1.test(password) == false) {
    $(".password-field-msg")
      .html(
        "Password is Invalid, It must contain atleast 1 uppercase char, 1 lower case char, 1 special case char, 1 number"
      )
      .addClass("text-danger");
    f = false;
  } else {
    $(".password-field-msg")
      .html("Ok !!")
      .removeClass("text-danger")
      .addClass("text-success");
    f = true;
  }

  //phone number validation
  let phone = $(".phone-field").val();
  let exp2 = /^\d{10}$/;
  if (phone == "" || phone == undefined) {
    $(".phone-field-msg")
      .html("Phone number is required !!")
      .addClass("text-danger");
    f = false;
  } else if (exp2.test(phone) == false) {
    $(".phone-field-msg")
      .html(
        "Phone number is invalid, it must be 10 digit and all must be numbers!!"
      )
      .addClass("text-danger");
    f = false;
  } else {
    $(".phone-field-msg")
      .html("OK !!")
      .removeClass("text-danger")
      .addClass("text-success");
    f = f == false ? false : true;
  }

  //   f = false;
  return f;
}
