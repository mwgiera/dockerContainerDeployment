resource "aws_ecs_cluster" "this" {
  name = var.name
  setting {
    name  = "containerInsights"
    value = "enabled"
  }
  tags = {
    Environment = var.environment
  }
}

resource "aws_cloudwatch_log_group" "service" {
  name              = "/ecs/${var.name}"
  retention_in_days = 30
}
