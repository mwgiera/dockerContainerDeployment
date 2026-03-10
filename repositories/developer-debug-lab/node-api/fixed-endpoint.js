module.exports = (req, res) => {
  const numbers = [];
  const sum = numbers.reduce((a, b) => a + b, 0);
  res.json({ result: sum });
};
