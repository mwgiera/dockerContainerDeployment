terraform {
  backend "s3" {
    bucket         = "harbor-terraform-state"
    key            = "staging/terraform.tfstate"
    region         = "us-east-1"
    dynamodb_table = "harbor-terraform-locks"
    encrypt        = true
  }
}

provider "aws" {
  region = "us-east-1"
}

module "network" {
  source             = "../../modules/network"
  name               = "harbor"
  environment        = "staging"
  cidr_block         = "10.20.0.0/16"
  private_subnets    = ["10.20.1.0/24", "10.20.2.0/24"]
  availability_zones = ["us-east-1a", "us-east-1b"]
}

module "ecs" {
  source      = "../../modules/ecs"
  name        = "harbor-staging"
  environment = "staging"
}
