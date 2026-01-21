# Harbor Runbook

## Deploying Updates
1. Run `terraform plan` and review the diff.
2. Apply during the deployment window.
3. Validate ECS cluster insights in CloudWatch.

## Rollback Strategy
- Re-apply the previous Terraform plan.
- Validate service health checks and alarms.

## Alerts
| Alarm | Signal | Action |
| --- | --- | --- |
| ECS Service CPU High | Sustained CPU > 80% | Evaluate scaling policies |
| ALB 5xx Errors | Error rate > 2% | Check deployment health |
