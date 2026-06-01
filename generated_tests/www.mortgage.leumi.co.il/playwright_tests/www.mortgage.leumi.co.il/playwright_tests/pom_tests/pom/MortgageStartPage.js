import { BasePage } from './BasePage.js';

export class MortgageStartPage extends BasePage {
  constructor(page) {
    super(page);
    // Step 2 selector: page.getByRole('link', { name: 'בואו נתחיל' })
    // Alternate selectors:
    // page.getByRole('link', { name: /בואו נתחיל/ })
    // page.locator('[class*="Menu"]').getByRole('link', { name: 'בואו נתחיל' })
    this.startBtn = page.getByRole('link', { name: 'בואו נתחיל' });
  }

  /**
   * Click the 'בואו נתחיל' (Let's Start) button to initiate the mortgage workflow
   * @returns {Promise<MortgageStartPage>}
   */
  async clickStartButton() {
    await this.startBtn.click({ timeout: 45000 });
    return this;
  }
}
