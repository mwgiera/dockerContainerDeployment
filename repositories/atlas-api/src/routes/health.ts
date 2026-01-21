interface HealthDeps {
  now: () => Date;
  version: string;
  environment: string;
}

export const healthCheck = ({ now, version, environment }: HealthDeps) => {
  return {
    status: "ok",
    checkedAt: now().toISOString(),
    version,
    environment,
  };
};
