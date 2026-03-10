# Docker Container Deployment Portfolio

This repository is a compact, recruiter-friendly portfolio showing practical work across API development, infrastructure-as-code, and data pipelines in a deployment-focused setup.

It is designed to demonstrate how services are built, validated, and prepared for reliable container/cloud execution.

---

## Why this repository exists

Hiring managers and support/platform teams usually look for proof of three things:

- can you build and debug services,
- can you provision and manage infrastructure safely,
- can you document and operate systems clearly.

This repository bundles those signals into one place.

---

## Repository layout

```text
dockerContainerDeployment/
├── repositories/
│   ├── atlas-api/            # TypeScript API service
│   ├── harbor-infra/         # Terraform infrastructure modules + env configs
│   └── orbit-data-pipeline/  # Python data pipeline
├── qodana.yaml               # static analysis configuration
└── README.md
```

---

## Included projects

### 1) Atlas API (`repositories/atlas-api`)
- TypeScript API service with modular routing and structured config.
- Includes health endpoint support and test/build scripts.
- Demonstrates backend service design and operability basics.

### 2) Harbor Infrastructure (`repositories/harbor-infra`)
- Terraform modules and environment configuration.
- Shows repeatable environment provisioning patterns.
- Demonstrates infrastructure discipline and deployment readiness.

### 3) Orbit Data Pipeline (`repositories/orbit-data-pipeline`)
- Python pipeline with staged processing (extract, validate, transform, publish).
- Includes testing setup and operational notes.
- Demonstrates data reliability and contract-based processing.

---

## Skills demonstrated

- backend API development (Node.js/TypeScript)
- infrastructure-as-code (Terraform)
- data pipeline engineering (Python)
- testing and quality checks
- deployment-aware documentation and structure

---

## How to run each component

Use each project directory independently:

```bash
# API service
cd repositories/atlas-api
npm install
npm run dev

# Infrastructure
cd repositories/harbor-infra/envs/staging
terraform init
terraform plan

# Data pipeline
cd repositories/orbit-data-pipeline
python -m venv .venv
source .venv/bin/activate
pip install -e .[dev]
pytest
```

---

## Suggested next improvements

- Add Dockerfiles for each runnable service.
- Add a root `docker-compose.yml` for local multi-service orchestration.
- Add CI workflow to run API tests + pipeline tests + Terraform validate in one pipeline.
