type LogLevel = "info" | "warn" | "error";

type LogPayload = Record<string, unknown>;

const emit = (level: LogLevel, message: string, payload?: LogPayload) => {
  const entry = {
    timestamp: new Date().toISOString(),
    level,
    message,
    payload,
  };

  console.log(JSON.stringify(entry));
};

export const log = {
  info: (message: string, payload?: LogPayload) => emit("info", message, payload),
  warn: (message: string, payload?: LogPayload) => emit("warn", message, payload),
  error: (message: string, payload?: LogPayload) => emit("error", message, payload),
};
