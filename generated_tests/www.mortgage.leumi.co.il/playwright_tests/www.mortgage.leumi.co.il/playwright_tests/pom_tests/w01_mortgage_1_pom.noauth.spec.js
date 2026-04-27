import 'dotenv/config';
import { test, expect } from '@playwright/test';
import { HomePage } from './pom/HomePage.js';
import path from 'path';
import { fileURLToPath } from 'url';

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const BASE_URL = process.env.BASE_URL;
const BASE_HOST_URL = process.env.BASE_HOST_URL;
let stepTimeout30 = { timeout: 30000 };

// Scenario: Discovered Workflow: Mortgage Initiation -- Partial
test('Discovered Workflow: Mortgage Initiation -- Partial', { tag: ['@smoke'] }, async ({ page }) => {
  const homePage = new HomePage(page);

  // Step 1: Navigate to homepage
  await homePage.gotoHomepage();
  await expect(page).toHaveURL('https://www.mortgage.leumi.co.il');

  // Step 2: Click the 'בואו נתחיל' link
  await homePage.clickStartWorkflowLink(stepTimeout30.timeout);
  // The expected URL after click is now the minisite mortgage page (with possible query params)
  await expect(page).toHaveURL(/https:\/\/mortgage\.leumi\.co\.il\/minisite\/mortgage.*/);

  // Step 3: Navigate to homepage (retry)
  await homePage.gotoHomepage();
  await expect(page).toHaveURL('https://www.mortgage.leumi.co.il');

  // Step 4: Click the 'בואו נתחיל' link again (retry)
  await homePage.clickStartWorkflowLinkRetry(stepTimeout30.timeout);
  await expect(page).toHaveURL(/https:\/\/mortgage\.leumi\.co\.il\/minisite\/mortgage.*/);
});

