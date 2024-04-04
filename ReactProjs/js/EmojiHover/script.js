const emoji = document.getElementById("emoji");
const emojis = [
  "😆",
  "😅",
  "🤣",
  "😂",
  "😀",
  "🤑",
  "🤨",
  "🙂",
  "😊",
  "😗",
  "😛",
  "😏",
  "🤥",
  "😴",
  "🥺",
  "😧",
  "😇",
  "😳",
  "🙃",
  "🥴",
  "🧐",
  "🤨",
  "😒",
  "🤔",
  "🤭",
  "🥰",
  "🤐",
  "👀",
  "🤔",
  "🤪",
  "🥲",
  "😃",
  "😁",
  "😬",
];

const randomEmojis = () => {
  index = Math.floor(Math.random() * emojis.length);
  return emojis[index];
};

emoji.addEventListener("mouseover", () => {
  const random = randomEmojis();
  emoji.innerHTML = random;
});

// emoji.addEventListener("mouseout", () => {
//   emoji.textContent = "👩‍🦰";
// });
