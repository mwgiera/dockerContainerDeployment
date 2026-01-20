variable "name" {
  type = string
}

variable "environment" {
  type = string
}

variable "cidr_block" {
  type = string
}

variable "private_subnets" {
  type = list(string)
}

variable "availability_zones" {
  type = list(string)
}
