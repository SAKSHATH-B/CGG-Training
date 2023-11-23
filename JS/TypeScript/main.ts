export {};
let message = "Hello World";
console.log(message);

//variable declarations
let x = 10;
const y = 20;

let sum;
// const abs  --> error

//variable types
let Beginner: boolean = true;
let total: number = 0;
let name: string = "nodeJS";
let sentence: string = `My name is ${name}
I am a beginner`;
// name = true;  --> error
console.log(sentence);

let n: null = null;
let u: undefined = undefined;

// let myName: string = undefined;
// let work: boolean = null;

let list1: number[] = [1, 2, 3];
let list2: Array<number> = [1, 2, 3];

let student: [string, number] = ["Ajay", 22];

enum color {
  red = 10,
  green,
  blue = 20,
}
let c: color = color.green;
console.log(c);

let random: any = 10;
random = true;
random = "Sakshath";
console.log(random);

let myVar: unknown = 10;
// console.log(myVar.name);
// (myVar as string).toUpperCase();

let a;
a = 10;
a = true;

// let b = 20;
// b = true;  --> b is inferring to number at the time of initialization

let multiType: number | boolean; //restricts to the type of number and boolean and provides intellisense support to the type specified
multiType = 20;
multiType = true;

let anyType: any;
anyType = 20;
anyType = true; // can be used for any types of variables and there is no intellisense support

function add(num1: number, num2: number = 10): number {
  if (num2) return num1 + num2;
  else return num1;
}
add(5, 10);
// add(5, "10"); --> error
add(5);
console.log(add(5));

//interfaces

interface Person {
  firstName: string;
  lastName?: string;
}
function fullName(person: Person) {
  console.log(`${person.firstName} ${person.lastName}`);
}
fullName({ firstName: "Sakshath" });

//classes and access modifiers

class Employee {
  employeeName: string;

  constructor(name: string) {
    this.employeeName = name;
  }
  greet() {
    console.log(`Good Morning ${this.employeeName}`);
  }
}
let emp1 = new Employee("Sakshath");
console.log(emp1.employeeName);
emp1.greet();

class Manager extends Employee {
  constructor(managerName: string) {
    super(managerName);
  }
  Work() {
    console.log("Manager Delegating Tasks");
  }
}
let m1 = new Manager("Ramu");
m1.Work();
m1.greet();
console.log(m1.employeeName);
