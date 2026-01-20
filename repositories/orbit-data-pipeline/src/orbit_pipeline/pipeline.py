from dataclasses import dataclass
from datetime import datetime
from typing import Iterable

from orbit_pipeline.validators import validate_payloads


@dataclass(frozen=True)
class RunMetadata:
    run_id: str
    partner: str
    started_at: datetime


def normalize_payloads(payloads: Iterable[dict]) -> list[dict]:
    normalized = []
    for payload in payloads:
        normalized.append({
            "account_id": payload["account_id"],
            "plan": payload["plan"].lower(),
            "status": payload["status"].lower(),
        })
    return normalized


def execute(payloads: Iterable[dict], metadata: RunMetadata) -> dict:
    validate_payloads(payloads, metadata)
    normalized = normalize_payloads(payloads)

    return {
        "run_id": metadata.run_id,
        "partner": metadata.partner,
        "record_count": len(normalized),
        "normalized": normalized,
    }
