# Scenario Summary: w01_mortgage_1

## Overview

- **Workflow ID**: WF001
- **Title**: Mortgage (1)
- **Goal**: Mortgage (1)
- **Feature Area**: 78c3838a-b224-4e20-b664-e86a0f9fa56b
- **Site URL**: https://www.mortgage.leumi.co.il
- **Site Type**: service — Mortgage application and information portal
- **Confidence Score**: 0.95
- **Auth Required**: False
- **Generated On**: 2026-06-01T18:57:47.720592

## User Journeys

### 1. Primary Business Workflow
_Main user flow_

- **Business Value**: Enable users to start mortgage application process
- **User Persona**: Prospective home buyers seeking mortgage information
- **Frequency**: daily
- **Complexity**: low

## Scenarios

### 1. Discovered Workflow: Mortgage Initiation -- Partial
**Type**: partial_flow | **Priority**: high

> Test covers navigation to the mortgage site and initiation of the workflow, ending at the blank page blocker.

**Business Goal**: Verify users can initiate the mortgage workflow

**User Story**: As a prospective home buyer, I want to start the mortgage application process so that I can explore mortgage options.

**Workflow Narrative**:
A prospective home buyer visits the Leumi mortgage site, clicks 'בואו נתחיל' to begin the mortgage workflow, but encounters a blank page preventing further progress.

#### Implementation Guidance:
- Use waitForSelector for the 'בואו נתחיל' button before clicking.
- Verify navigation to the mortgage workflow URL.
- Detect blank page or missing content as a blocker.

#### Detailed Steps:

| # | Action | Component | Description | Verification | URL |
|---|--------|-----------|-------------|--------------|-----|
| 1 | Navigate to homepage | Navigation | Load homepage | Page loaded | https://www.mortgage.leumi.co.il |
| 2 | Click | 'בואו נתחיל' (Let's Start) button | Click the 'בואו נתחיל' button to initiate the mortgage workflow | Button click triggers navigation | https://www.mortgage.leumi.co.il/ |

#### Expected Results:
- User can access the homepage
- User can initiate mortgage workflow
- Workflow is blocked by blank page after initiation

#### Edge Cases:
- Blank page or missing content after workflow initiation
- Slow network
- Site not accessible

#### Data Requirements:
- Accessible homepage
- Visible 'בואו נתחיל' button

#### Prerequisites:
- Site accessible

## Captured Selectors

- **Total**: 2
