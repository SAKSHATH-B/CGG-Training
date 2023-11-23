import React from "react";

const people = [
  { id: 1, name: "bob", nickName: "stud Muffin" },
  { id: 2, name: "peter" },
  {
    id: 3,
    name: "oliver",
    images: [
      {
        small: {
          url: "https://imgs.search.brave.com/ehCOw5yb_Zf8Wn7EKz90r_38iqvheX562vBpL7huENg/rs:fit:860:0:0/g:ce/aHR0cHM6Ly93MC5w/ZWFrcHguY29tL3dh/bGxwYXBlci83OC8z/NDIvSEQtd2FsbHBh/cGVyLWNvbnRpbmVu/dGFsLWd0LTY1MC1j/YWZlcmFjZXItZW5m/aWVsZC1ndDY1MC1y/b3lhbC5qcGc",
        },
      },
    ],
  },
  { id: 4, name: "david" },
];

function Person({ name, nickName = "HEYNA", images }) {
  const img =
    images?.[0]?.small?.url ||
    "https://imgs.search.brave.com/izwlyaKcVPmHXMTGmwl0Uyeg3tUUAqr5gA4dK3tMTLE/rs:fit:500:0:0/g:ce/aHR0cHM6Ly9hc3Nl/dHMuY2FyYW5kY2xh/c3NpYy5jb20vdXBs/b2Fkcy9jYXJzL2Zv/cmQvQzE2NTEzNzEv/MTk2NS1mb3JkLW11/c3RhbmctNjUzNjRh/ZDU5ODliYy5qcGc_/YXV0bz1jb21wcmVz/cyZmaXQ9ZmlsbG1h/eCZoPTI4MSZpeGxp/Yj1waHAtNC4xLjAm/cT03NSZ3PTUwMCZz/PWE1MmE5YWMyMDRh/NDNkZmU4NjkzYzli/YTQ5ZDkzOWUw";
  return (
    <div>
      <img src={img} alt={name} style={{ width: "100px" }} />
      <h3>{name}</h3>
      <p>NickName : {nickName}</p>
    </div>
  );
}

export const LeverageJavascript = () => {
  return (
    <div>
      <h2>LeverageJavascript</h2>
      <h4>
        {people.map((person) => {
          return <Person key={person.name} {...person} />;
        })}
      </h4>
    </div>
  );
};
