const insert = document.getElementById("insert");

window.addEventListener("keydown", (e) => {
  //   console.log(e.key);
  //   console.log(e.keyCode);
  //   console.log(e.code);
  insert.innerHTML = `
        <div class="color">
            <table>
                <tr>
                    <th>Key</th>
                    <th>KeyCode</th>
                    <th>Code</th>
                </tr>
                <tr>
                    <td>${e.key === " " ? "Space" : e.key}</td>
                    <td>${e.keyCode}</td>
                    <td>${e.code}</td>
                </tr>
            </table>
        </div>
    `;
});
