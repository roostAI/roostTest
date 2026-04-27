import { BasePage } from './BasePage.js';

export class HomePage extends BasePage {
  /**
   * @param {import('playwright').Page} page
   */
  constructor(page) {
    super(page);
    // Primary selector for 'בואו נתחיל' (Let's Start) link
    // Use unique parent '[class*="Menu"]' for disambiguation
    this.startWorkflowLink = this.page.locator('[class*="Menu"]').getByRole('link', { name: 'בואו נתחיל' });
  }

  /**
   * Navigates to the homepage.
   * @param {number} timeoutMs
   * @returns {Promise<HomePage>}
   */
  async gotoHomepage(timeoutMs = 60000) {
    await this.page.goto('https://www.mortgage.leumi.co.il', { waitUntil: 'domcontentloaded', timeout: timeoutMs });
    return this;
  }

  /**
   * Clicks the 'בואו נתחיל' (Let's Start) link to begin the mortgage workflow.
   * @param {number} timeoutMs
   * @returns {Promise<HomePage>}
   */
  async clickStartWorkflowLink(timeoutMs = 30000) {
    await this.startWorkflowLink.waitFor({ state: 'visible', timeout: timeoutMs });
    await this.startWorkflowLink.click({ timeout: timeoutMs });
    return this;
  }

  /**
   * Clicks the 'בואו נתחיל' (Let's Start) link again to retry starting the mortgage workflow.
   * @param {number} timeoutMs
   * @returns {Promise<HomePage>}
   */
  async clickStartWorkflowLinkRetry(timeoutMs = 30000) {
    await this.startWorkflowLink.waitFor({ state: 'visible', timeout: timeoutMs });
    await this.startWorkflowLink.click({ timeout: timeoutMs });
    return this;
  }
}
