import "dotenv/config";

interface ServiceConfig {
  environment: string;
  version: string;
}

export const loadConfig = (): ServiceConfig => {
  const environment = process.env.NODE_ENV ?? "development";
  const version = process.env.SERVICE_VERSION ?? "0.0.0";

  if (!environment) {
    throw new Error("NODE_ENV must be defined");
  }

  return {
    environment,
    version,
  };
};
