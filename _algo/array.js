// Array

function doStuff(){                 // Function
    var x = 123;                    // Number
    var y = "test";                 // String
    var z = [10,11,12,13,14];       // Array

    console.log(x);
    console.log(y);
    console.log(z);             
    console.log(z[0]);              // Prints the first element in the array
    console.log(z[4]);              // Prints the last element in the array
    console.log(z.length);          // Prints the number of items inside the array
    console.log(z.length - 1);      // Prints the length of the array minus one
    console.log(z[z.length-1]);     // Prints the value of the last item in the array
}

console.log(doStuff);

// Loops

// for(FIRST; SECOND; FOURTH){
//     THIRD
// }

// FIRST: Set a value
// SECOND: Condition
// THIRD: Output
// FOURTH: 

for(var counter = 1; counter <3; counter = counter + 1){
    console.log("Code!");
    console.log(counter);
}
console.log("Counter value ", counter);

// NOTES
counter : 1,2,3
output: "Code!", "Code!";

// OBJECTS
x = "test"
var z = [9,8,7,6,5,4,3,2,1,x]

console.log(z[9]);

// Object with key and value pair
var obj = {
    a: "test",
    b: "test@test.com",
    c: "x",
    d:[1,2,3]
};

console.log(obj);
console.log(obj["a"]);           // Specifies the key of "name" inside obj
console.log(obj["b"]);
console.log(obj["c"]);
console.log(obj["d"][0]);

x=10;
y=20;

if(x<y){
    console.log("X is less than Y");
} else if (x === y){
    console.log("X is equal to Y");
}