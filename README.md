# Baseball Simulation Project - Basic Setup

🌐 Available Languages:
- [English](https://github.com/pipeline-sim/plsim/blob/main/README.md)
- [한국어 (Korean)](https://github.com/pipeline-sim/plsim/blob/main/README.ko.md)

## Project Overview

### Basic Information
- **Project Name**: plsim (Pipeline Simulator)
- **Type**: Baseball Simulation League Game
- **Tech Stack**: Kotlin, Spring Boot 3.x, Gradle, JPA
- **Architecture**: Clean Architecture + Multi Module

### Game Features
1. **League System**: Limit of 30 teams per league + multiple leagues can run concurrently
2. **Player Acquisition**: Draft + Trade + Free Agency (FA) system
3. **Game Processing**: Batch processing of scheduled games (3 games per day)
4. **Simulation**: Detailed outcomes by inning, plate appearance, and pitch

## Multi-module Structure

```
baseball-sim/
├── build.gradle.kts           # Root - Shared Configuration
├── settings.gradle.kts        # Module Definitions
├── common/                    # Shared Utilities (Exceptions, Constants, Utils)
├── domain/                    # Core Domain Logic (Pure Java)
├── application/               # Business Logic (UseCase + Service)
├── infrastructure/            # Infrastructure (Repository Implementation, External Integration)
├── simulation-engine/         # Simulation Engine (Separate Module)
├── batch/                     # Batch processing (Games, Free Agency)
└── api/                       # REST API (Spring Boot Entry Point)
```

### Module Roles

- **common**: Common code used across all modules (exceptions, utilities, constants)
- **domain**: Core business logic of the baseball game (pure Java, minimal external dependencies)
- **application**: Business use case implementation (UseCase + Service pattern)
- **infrastructure**: Database and external API integration (repository implementations)
- **simulation-engine**: Baseball simulation engine (game, plate appearance, pitch simulation)
- **batch**: Scheduled batch jobs (daily games, weekly FA processing)
- **api**: REST API endpoints (main Spring Boot application)

### Dependency Graph

```
api → application → domain
  ↓         ↓
infrastructure → domain
     ↑
   common (referenced by all modules)
```
