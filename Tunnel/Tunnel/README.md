# LT-appium-java-testng

Sample repo to run app automation on real device on LambdaTest.

**Below is the curl request to upload the app for automation**

```
curl --location --request POST 'https://manual-api.lambdatest.com/app/upload/realDevice' \
--header 'Authorization: Basic <ENTER_BASIC_AUTH_TOKEN_HERE>' \
--form 'name="lambda1"' \
--form 'appFile=@"/path/to/file"'
```

### **Step-1: Upload your application**

```bash
curl -u "YOUR_LAMBDATEST_USERNAME":"YOUR_LAMBDATEST_ACCESS_KEY" \
--location --request POST 'https://manual-api.lambdatest.com/app/upload/realDevice' \
--form 'name="Android_App"' \
--form 'appFile=@"/Users/macuser/Downloads/proverbial_android.apk"'
```

> **Note:**
>
> - If you do not have any **.apk** or **.ipa** file, you can run your sample tests on LambdaTest by using our sample [Android app](https://prod-mobile-artefacts.lambdatest.com/assets/docs/proverbial_android.apk) or sample [iOS app](https://prod-mobile-artefacts.lambdatest.com/assets/docs/proverbial_ios.ipa).
> - Response of above cURL will be a **JSON** object containing the `App URL` of the format - <lt://APP123456789123456789> and will be used in the next step.

### **Step 2: Write Your Automation Script**

Write your automation script in the client language of your choice from the ones [supported by Appium](https://appium.io/downloads.html). In the sample automation script in Java for the sample app downloaded above. Ensure to update the `app_url`, `username` and `accesskey` in the below code.

### **Step 3: Execute Your Test Case**

Debug and run your code. Run iOSApp.java or AndroidApp.java in your editor.

**Android:**

```
mvn test -P android-single
```

```
mvn test -P android-parallel
```

**IOS:**

```
mvn test -P ios-single
```

```
mvn test -P ios-parallel
```

### **Step 4: View Test Execution**

Once you have run your tests, you can view the test execution along with logs. You will be able to see the test cases passing or failing. You can view the same at [LambdaTest Automation](https://accounts.lambdatest.com/login).
