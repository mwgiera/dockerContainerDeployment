if (!process.env.API_KEY) {
  throw new Error("Missing required environment variable: API_KEY");
}

console.log("Environment loaded successfully");
