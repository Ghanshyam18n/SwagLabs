# SwagLabs
# Automation Test Report

# Objective


Automate the end-to-end purchase flow of SauceDemo and validate key functionalities.

## Test Flow Covered

### 1. Login
- Opened browser and navigated to the website  
- Logged in using:
  - Username: `standard_user`
  - Password: `secret_sauce`
- Verified successful login by checking navigation to the Products page  

---

### 2. Add Products
- Added two products to cart:
  - Sauce Labs Backpack  
  - Sauce Labs Bike Light  
- Verified cart icon shows correct item count (**2 items**)  

---

### 3. Check Cart
- Opened cart page  
- Performed validations:
  - Verified correct number of items  
  - Verified correct items are added  
  - Verified item names are displayed  
  - Verified item prices are displayed  
  - Verified exact product prices (additional validation)  

---

### 4. Checkout
- Clicked on checkout  
- Entered user details:
  - First Name  
  - Last Name  
  - Zip Code  
- Continued and completed checkout process  

---

### 5. Final Check
- Verified success message:
  **"Thank you for your order!"**

---

## Framework Design (POM)

This project follows the **Page Object Model (POM)** design pattern.

Separate classes are created for each page:

- `LoginPage` → Handles login functionality  
- `ProductsPage` → Handles product selection and cart navigation  
- `CartPage` → Handles cart validation and checkout  
- `CheckoutPage` → Handles user details and order completion  

✔ Improves readability  
✔ Improves maintainability  
✔ Supports reusability  

---

## Technical Implementation

- Used **Page Object Model (POM)**  
- Used **Explicit Waits (WebDriverWait)**  
- Did NOT use `Thread.sleep()`  
- Added **assertions for all validations**  
- Implemented **screenshot capture on failure (TestNG Listener)**  
- Added **console logs for execution tracking**

---

## Screenshot Handling
- Screenshot is automatically captured when any test fails  
- Helps in debugging and issue tracking  

---

## Validations Performed

- Login validation  
- Cart count validation  
- Correct item validation  
- Item name validation  
- Item price validation  
- Final success message validation  

---

## Result
- Test Execution: **PASS**  
- All steps executed successfully  
- All validations passed  
