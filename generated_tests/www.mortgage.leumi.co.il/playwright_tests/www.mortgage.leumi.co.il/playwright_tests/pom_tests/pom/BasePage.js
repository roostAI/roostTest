export class BasePage {
  /**
   * @param {import('playwright').Page} page
   */
  constructor(page) {
    this.page = page;
  }

  /**
   * Wait for navigation to a specific URL
   * @param {string} url
   * @param {number} timeout
   */
  async waitForUrl(url, timeout = 60000) {
    await this.page.waitForURL(url, { timeout });
    return this;
  }

  /**
   * Wait for selector to appear
   * @param {string} selector
   * @param {number} timeout
   */
  async waitForSelector(selector, timeout = 30000) {
    await this.page.waitForSelector(selector, { timeout });
    return this;
  }
}
