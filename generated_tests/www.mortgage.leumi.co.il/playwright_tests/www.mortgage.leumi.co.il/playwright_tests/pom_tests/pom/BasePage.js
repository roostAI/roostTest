export class BasePage {
  /**
   * @param {import('playwright').Page} page
   */
  constructor(page) {
    this.page = page;
  }

  /**
   * Waits for navigation to a specific URL with explicit timeout.
   * @param {string} url
   * @param {number} timeoutMs
   * @returns {Promise<void>}
   */
  async waitForUrl(url, timeoutMs = 60000) {
    await this.page.waitForURL(url, { timeout: timeoutMs });
  }

  /**
   * Navigates to a given URL with explicit timeout.
   * @param {string} url
   * @param {number} timeoutMs
   * @returns {Promise<void>}
   */
  async goto(url, timeoutMs = 60000) {
    await this.page.goto(url, { waitUntil: 'domcontentloaded', timeout: timeoutMs });
  }
}
