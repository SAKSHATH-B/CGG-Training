<html>
  <head>
    <style>
      .container {
        width: 40%;
        border: 1px solid black;
        margin: auto;
        padding: 20px;
        font-size: 20px;
      }
      #myForm table tr td input {
        font-size: 20px;
      }
    </style>
  </head>
  <body>
    <h2>Hello World!</h2>
    <h2>This is first project</h2>
    <h1><a href="first">FirstServlet</a></h1>
    <h1><a href="second">SecondServlet</a></h1>
    <h1><a href="third">ThirdServlet</a></h1>
    <div class="container">
      <form id="myForm" action="RegisterServlet" method="post">
        <h1>My Form</h1>
        <table>
          <tr>
            <td>Enter your name:</td>
            <td>
              <input type="text" name="user_name" placeholder="Enter here" />
            </td>
          </tr>
          <tr>
            <td>Enter your password:</td>
            <td>
              <input
                type="password"
                name="user_password"
                placeholder="Enter here"
              />
            </td>
          </tr>
          <tr>
            <td>Enter your email:</td>
            <td>
              <input type="email" name="user_email" placeholder="Enter here" />
            </td>
          </tr>
          <tr>
            <td>Select Gender:</td>
            <td>
              <input type="radio" name="user_gender" value="male" />Male
              &nbsp;&nbsp;
              <input type="radio" name="user_gender" value="female" />Female
              &nbsp;&nbsp;
            </td>
          </tr>
          <tr>
            <td>Select your course:</td>
            <td>
              <select name="user_course">
                <option value="Java">Java</option>
                <option value="Python">Python</option>
                <option value="Php">Php</option>
                <option value="Android">Android</option>
              </select>
            </td>
          </tr>
          <tr>
            <td style="text-align: right">
              <input type="checkbox" name="condition" value="checked" />
            </td>
            <td>Agree terms and conditions</td>
          </tr>
          <tr>
            <td></td>
            <td>
              <button type="submit">Submit</button>
              <button type="reset">Reset</button>
            </td>
          </tr>
        </table>
      </form>
    </div>
  </body>
</html>
