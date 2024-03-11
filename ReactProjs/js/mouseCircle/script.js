const cursor = document.querySelector(".cursor");

const colors = [
  "#FF6633",
  "#FFB399",
  "#FF33FF",
  "#FFFF99",
  "#00B3E6",
  "#E6B333",
  "#3366E6",
  "#999966",
  "#99FF99",
  "#B34D4D",
];

function updateCursorPosition(e) {
  cursor.style.left = e.clientX + "px";
  cursor.style.top = e.clientY + "px";
  const colorIndex = Math.floor(Math.random() * colors.length);
  cursor.style.backgroundColor = colors[colorIndex];
}

document.addEventListener("mousemove", updateCursorPosition);
