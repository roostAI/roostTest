import 'dotenv/config';
import { test, expect } from '@playwright/test';
import { HomePage } from './pom/HomePage.js';
import { MortgageStartPage } from './pom/MortgageStartPage.js';
import fs from 'fs';
import path from 'path';
import { fileURLToPath } from 'url';

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const BASE_HOST_URL = process.env.BASE_HOST_URL;
const BASE_URL = process.env.BASE_URL;

let stepTimeout30 = { timeout: 30000 };

test('Discovered Workflow: Mortgage Initiation -- Partial', { tag: ['@smoke'] }, async ({ page }) => {
  // Step 1: Navigate to homepage
  const homePage = new HomePage(page);
  await homePage.navigateToHomePage();
  await expect(page).toHaveURL('https://www.mortgage.leumi.co.il');

  // Step 2: Click 'בואו נתחיל' (Let's Start) button
  const mortgageStartPage = new MortgageStartPage(page);
  await mortgageStartPage.clickStartButton();

  // Edge case: Detect blank page or missing content as a blocker
  // (Partial flow: No further steps, but could check for visible content)
  // For now, just verify navigation did not fail
  await expect(page).not.toHaveTitle(''); // Title should not be blank
});

test.afterEach(async ({ page, context }, testInfo) => {
  if (testInfo.status !== 'passed') {
    try {
      const accessibilityTree = await page.accessibility.snapshot();
      const fileName = path.basename(testInfo.file)
        .replace('.auth.spec.js', '').replace('.noauth.spec.js', '').replace('.spec.js', '');
      const stateFile = path.join(__dirname, '..', `.accessibility_state_${fileName}.json`);
      fs.writeFileSync(stateFile, JSON.stringify({
        accessibility_tree: accessibilityTree,
        url: page.url(),
        all_page_urls: context.pages().map(p => p.url())
      }, null, 2));
    } catch (e) { /* Silent fail */ }
  }
});
