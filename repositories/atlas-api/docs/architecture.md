# Architecture Notes

## Ownership Boundaries
- **Routes** own HTTP serialization and validation.
- **Services** encapsulate orchestration and business rules.
- **Repositories** (future) isolate persistence details.

## Observability
- Structured logging via `log` helper.
- Every request must include a request id (not wired yet).

## Resiliency
- Use timeouts for downstream calls.
- Favor retry with backoff only for idempotent operations.
