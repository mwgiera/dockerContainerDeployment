module.exports = (req, res) => {
  const numbers = [];
  const sum = numbers.reduce((a, b) => a + b);
  res.json({ result: sum });
};
