import { NameListPerson } from "./NameListPerson";

export const NameList = () => {
  //   const names = ["BMW", "AUDI", "Porsche", "Benz"];
  //   const nameList = names.map((name, index) => (
  //     <h2 key={index}>
  //       {index + 1} : {name}
  //     </h2>
  //   ));

  const persons = [
    { id: 1, company: "CGG", type: "service" },
    { id: 2, company: "Google", type: "product" },
  ];

  //   const per = persons.map((person) => {
  //     return (
  //       <h2>
  //         I am Working in {person.company} of type {person.type}
  //       </h2>
  //     );
  //   });
  const per = persons.map((person) => {
    return <NameListPerson person={person} />;
  });

  //   return <div>{nameList}</div>;
  return <div>{per}</div>;
};
