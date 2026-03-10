# Incident Analysis

## Scenario
Node.js `/data` endpoint fails at runtime.

## Root cause
`reduce()` is called without an initial value while operating on an empty array.

## Resolution
Use `numbers.reduce((a, b) => a + b, 0)`.
