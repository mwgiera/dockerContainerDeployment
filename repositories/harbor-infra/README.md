# Harbor Infrastructure

Harbor Infrastructure defines the baseline cloud stack for internal services. It focuses on predictable environments and repeatable deployments.

## Structure
- `modules/` reusable Terraform modules.
- `envs/` per-environment configuration.
- `docs/` runbooks and operational guidance.

## Environments
| Environment | Purpose | State Backend |
| --- | --- | --- |
| staging | Pre-production validation | S3 + DynamoDB |

## Usage
```bash
cd envs/staging
terraform init
terraform plan
```

## Notes
- State locking is required for all environments.
- Use separate workspaces for feature validation.
