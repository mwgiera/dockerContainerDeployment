const { rules } = require("./rules");

function classifyError(input) {
  const match = rules.find((rule) => rule.pattern.test(input));
  return match || { errorType: "Unknown", fix: "Investigate manually" };
}

module.exports = { classifyError };
