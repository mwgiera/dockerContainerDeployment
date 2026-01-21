# Atlas API

Atlas API is a lightweight service that powers account discovery and metadata for internal tooling. It prioritizes predictable contracts, easy operability, and clear boundaries between transport and domain logic.

## Highlights
- Modular routing layout with explicit ownership.
- Typed configuration with environment validation.
- Structured logging that is ready for observability pipelines.

## Architecture
- **Transport layer**: `src/routes/*` for HTTP concerns.
- **Domain services**: `src/services/*` (future expansion).
- **Shared utilities**: `src/lib/*` for logging, config, and helpers.

## Local Development
```bash
npm install
npm run dev
```

## Scripts
- `npm run dev` - start the dev server with ts-node.
- `npm run build` - compile TypeScript.
- `npm test` - run unit tests.

## Operational Notes
- Exposes `/health` for platform checks.
- Logs include request id for traceability.

## Roadmap
- Add OpenAPI contract generation.
- Wire metrics export (Prometheus).
