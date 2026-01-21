# 0001 - Data Contracts for Partner Feeds

## Status
Accepted

## Context
Partner feeds arrive with inconsistent naming and missing fields. The pipeline must enforce a contract that downstream reporting can rely on.

## Decision
We enforce a minimal contract at the ingestion boundary using validation rules. Missing required fields will fail the run and return a remediation hint.

## Consequences
- Upstream partners receive clear feedback quickly.
- The pipeline may block ingestion if required fields are missing.
