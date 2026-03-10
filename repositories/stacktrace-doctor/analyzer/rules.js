const rules = [
  {
    pattern: /Cannot find module/i,
    errorType: "Missing dependency",
    fix: "npm install <package>"
  },
  {
    pattern: /KeyError/i,
    errorType: "Python key access",
    fix: "Validate key before access"
  }
];

module.exports = { rules };
