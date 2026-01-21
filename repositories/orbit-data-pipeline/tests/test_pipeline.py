from datetime import datetime

import pytest

from orbit_pipeline.pipeline import RunMetadata, execute


def test_execute_returns_normalized_payloads():
    payloads = [
        {"account_id": "acc-1", "plan": "Pro", "status": "Active"},
        {"account_id": "acc-2", "plan": "Basic", "status": "Paused"},
    ]

    result = execute(
        payloads,
        RunMetadata(run_id="run-1", partner="orbit", started_at=datetime(2024, 1, 1)),
    )

    assert result["record_count"] == 2
    assert result["normalized"][0]["plan"] == "pro"


def test_execute_raises_on_missing_required_fields():
    payloads = [{"plan": "Pro"}]

    with pytest.raises(ValueError, match="Validation failed"):
        execute(
            payloads,
            RunMetadata(run_id="run-2", partner="orbit", started_at=datetime(2024, 1, 1)),
        )
