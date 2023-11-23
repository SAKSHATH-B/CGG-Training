"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
Object.defineProperty(exports, "__esModule", { value: true });
var message = "Hello World";
console.log(message);
//variable declarations
var x = 10;
var y = 20;
var sum;
// const abs  --> error
//variable types
var Beginner = true;
var total = 0;
var name = "nodeJS";
var sentence = "My name is ".concat(name, "\nI am a beginner");
// name = true;  --> error
console.log(sentence);
var n = null;
var u = undefined;
// let myName: string = undefined;
// let work: boolean = null;
var list1 = [1, 2, 3];
var list2 = [1, 2, 3];
var student = ["Ajay", 22];
var color;
(function (color) {
    color[color["red"] = 10] = "red";
    color[color["green"] = 11] = "green";
    color[color["blue"] = 20] = "blue";
})(color || (color = {}));
var c = color.green;
console.log(c);
var random = 10;
random = true;
random = "Sakshath";
console.log(random);
var myVar = 10;
// console.log(myVar.name);
// (myVar as string).toUpperCase();
var a;
a = 10;
a = true;
// let b = 20;
// b = true;  --> b is inferring to number at the time of initialization
var multiType; //restricts to the type of number and boolean and provides intellisense support to the type specified
multiType = 20;
multiType = true;
var anyType;
anyType = 20;
anyType = true; // can be used for any types of variables and there is no intellisense support
function add(num1, num2) {
    if (num2 === void 0) { num2 = 10; }
    if (num2)
        return num1 + num2;
    else
        return num1;
}
add(5, 10);
// add(5, "10"); --> error
add(5);
console.log(add(5));
function fullName(person) {
    console.log("".concat(person.firstName, " ").concat(person.lastName));
}
fullName({ firstName: "Sakshath" });
//classes and access modifiers
var Employee = /** @class */ (function () {
    function Employee(name) {
        this.employeeName = name;
    }
    Employee.prototype.greet = function () {
        console.log("Good Morning ".concat(this.employeeName));
    };
    return Employee;
}());
var emp1 = new Employee("Sakshath");
console.log(emp1.employeeName);
emp1.greet();
var Manager = /** @class */ (function (_super) {
    __extends(Manager, _super);
    function Manager(managerName) {
        return _super.call(this, managerName) || this;
    }
    Manager.prototype.Work = function () {
        console.log("Manager Delegating Tasks");
    };
    return Manager;
}(Employee));
var m1 = new Manager("Ramu");
m1.Work();
m1.greet();
console.log(m1.employeeName);
