import { loadConfig } from "./lib/config";
import { log } from "./lib/logger";
import { healthCheck } from "./routes/health";

const config = loadConfig();

const server = {
  start() {
    log.info("atlas-api boot", { env: config.environment });
    log.info("registered routes", { routes: ["/health"] });

    healthCheck({
      now: () => new Date(),
      version: config.version,
      environment: config.environment,
    });
  },
};

server.start();
