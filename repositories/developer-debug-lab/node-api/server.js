const express = require("express");
const brokenEndpoint = require("./broken-endpoint");

const app = express();
app.get("/data", brokenEndpoint);

app.listen(3000, () => {
  console.log("Server running on port 3000");
});
