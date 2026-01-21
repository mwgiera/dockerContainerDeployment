# Orbit Data Pipeline

Orbit Data Pipeline ingests partner feeds, validates schema contracts, and publishes normalized datasets for analytics.

## Goals
- Deterministic transforms that are easy to audit.
- Clear data contracts with enforced validation.
- Structured metrics for pipeline health.

## Local Setup
```bash
python -m venv .venv
source .venv/bin/activate
pip install -e .[dev]
pytest
```

## Pipeline Stages
1. **Extract**: load raw partner payloads.
2. **Validate**: enforce schema and contract checks.
3. **Transform**: map into canonical models.
4. **Publish**: emit snapshots to downstream consumers.

## Operational Notes
- Jobs are idempotent per `run_id`.
- Validation errors include remediation hints.
