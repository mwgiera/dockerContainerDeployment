function formatResponse(result) {
  return `${result.errorType}: ${result.fix}`;
}

module.exports = { formatResponse };
