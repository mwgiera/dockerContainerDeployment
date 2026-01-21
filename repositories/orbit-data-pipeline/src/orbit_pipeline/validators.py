from collections.abc import Iterable
from dataclasses import dataclass


@dataclass(frozen=True)
class ValidationIssue:
    field: str
    message: str
    hint: str


def validate_payloads(payloads: Iterable[dict], metadata) -> None:
    issues = []
    for index, payload in enumerate(payloads):
        if "account_id" not in payload:
            issues.append(
                ValidationIssue(
                    field=f"payloads[{index}].account_id",
                    message="Missing account identifier",
                    hint="Ensure account_id is present in the partner payload",
                )
            )
        if "plan" not in payload:
            issues.append(
                ValidationIssue(
                    field=f"payloads[{index}].plan",
                    message="Missing plan tier",
                    hint="Populate plan with the partner tier name",
                )
            )
        if "status" not in payload:
            issues.append(
                ValidationIssue(
                    field=f"payloads[{index}].status",
                    message="Missing status",
                    hint="Provide an explicit status: active, paused, canceled",
                )
            )

    if issues:
        formatted = "; ".join(f"{issue.field}: {issue.message}" for issue in issues)
        raise ValueError(
            f"Validation failed for run {metadata.run_id} ({metadata.partner}): {formatted}"
        )
