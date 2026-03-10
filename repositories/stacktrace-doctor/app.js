const { classifyError } = require("./analyzer/classifyError");

const sample = "Error: Cannot find module 'axios'";
console.log(classifyError(sample));
