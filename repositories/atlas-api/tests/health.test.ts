import { describe, expect, it } from "vitest";
import { healthCheck } from "../src/routes/health";

describe("healthCheck", () => {
  it("returns ok payload", () => {
    const response = healthCheck({
      now: () => new Date("2024-01-01T00:00:00.000Z"),
      version: "1.2.3",
      environment: "test",
    });

    expect(response).toEqual({
      status: "ok",
      checkedAt: "2024-01-01T00:00:00.000Z",
      version: "1.2.3",
      environment: "test",
    });
  });
});
